package repository;

import java.util.ArrayList;

import dto.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import dto.Passenger.*;
import dto.Train;
import passenger.PassengerView;
public class TrainDetails {

	public Train train;
    public static TrainDetails repinstance;
    public Passenger passenger;
    Set<Integer> existingpid=new HashSet<>();
    Map<Integer,Passenger> pmap=new HashMap<>();
	Map<Integer,Train> map=new HashMap<>(); 
	List<Integer> lowerposition = new ArrayList<>();
	List<Integer> upperposition = new ArrayList<>();
	List<Integer> middleposition = new ArrayList<>();
	Queue<Integer> racposition=new LinkedList<>();
	Queue<Integer> wlposition=new LinkedList<>();
	List<Integer> tatkalposition=new ArrayList<>();
	List<Passenger> plist=new ArrayList<>();
	public PassengerView pview;
	public int totalseats;
      public void traindtls()
	{
    	  
    	  if (!map.isEmpty()) {
              return; // Prevents duplicate data
          }
    	  
		train = new Train(1,"Tenkasi","Tirunelveli","13/03/2025",3,1,1,1);
		map.put(1, train);
		Train train1=new Train(2,"Madurai","Tirunelveli","18/03/2025",36,10,10,5);
		map.put(2, train1);
		Train train2=new Train(3,"Perambalur","Chennai","19/03/2025",36,10,10,5);
		map.put(3, train2);
		Train train3=new Train(4,"Trichy","Sankarankovil","28/03/2025",36,10,10,5);
		map.put(4, train3);
		settrainpos(map);

	}
      
      public List<Train> addtrain(int id,String src,String des,String dt,int seats,int rac,int wl,int tatkal)
      {
    	  traindtls();
    	  Train train5=new Train(id,src,des,dt,seats,rac,wl,tatkal);
    	  map.put(id, train5);
    	  settrainpos(map);
    	  List<Train> alltrain=showalltrain();
    	  return alltrain;
      }
      
      public List<Train> removetrain(int rtid)
      {
    	  traindtls();
    	  map.remove(rtid);
    	  settrainpos(map);
    	  List<Train> alltrain=showalltrain();
    	  return alltrain;
      } 
      public void settrainpos(Map<Integer,Train> map)
      {
    	  for(Map.Entry<Integer, Train> entry:map.entrySet())
    	  {
    		  int noofseats=entry.getValue().getnoofseats();
    		  entry.getValue().setnooflower(noofseats/3);
    		  entry.getValue().setnoofupper(noofseats/3);
    		  entry.getValue().setnoofmiddle(noofseats/3);
    		  for(int i=0;i<noofseats;i++)
    		  {
    			  lowerposition.add(i+1);
    			  middleposition.add(i+1);
    			  upperposition.add(i+1);
    		  }
    		  int noofwl=entry.getValue().getnoofwaitinglist();
    		 
    		  int noofrac=entry.getValue().getnoofrac();
    		
    		  int nooftatkal=entry.getValue().getnooftatkaltickets();
    		  for(int i=0;i<nooftatkal;i++)
    		  {
    			  tatkalposition.add(i);
    		  }
    		  
    	  }
      }
      
      public int totalseats(int tid,String dt)
      {
    	    traindtls();
    	  
    	    if(map.get(tid).getdate().equalsIgnoreCase(dt))
    	    {
    	    	totalseats=map.get(tid).getnoofseats()+map.get(tid).getnoofrac()+map.get(tid).getnoofwaitinglist();
    	    	
    	    }
    	
    	  return totalseats;
      }
      public static TrainDetails getInstance()
      {
    	  if(repinstance==null)
    	  {
    	  repinstance=new TrainDetails();
    	  }
    	  return repinstance;
      }
	public List<Train> showalltrain()
	{
		traindtls();
         List<Train> alltrainlist=new ArrayList<>();
		for (Map.Entry<Integer, Train> entry : map.entrySet()) {
			alltrainlist.add(entry.getValue());
		}
		return alltrainlist;
		
	}
	
	public List<Train> showspectrain(String src,String desti,String dt)
	{
		traindtls();
		List<Train> spectrain=new ArrayList<>();
		for(Map.Entry<Integer, Train> entry: map.entrySet())
		{
			if(entry.getValue().getsource().equalsIgnoreCase(src) && entry.getValue().getdestination().equalsIgnoreCase(desti) 
					&& entry.getValue().getdate().equalsIgnoreCase(dt))
			{
				spectrain.add(entry.getValue());
			}
			
		}
		return spectrain;
	}
	
	public String booktopass(int pid,String pname,String gender,int age,String bprefer,int trainid,String dt)
	{
		traindtls();
		
		for(Map.Entry<Integer, Train> entry: map.entrySet())
		{
			
			if(bprefer.equalsIgnoreCase("L") && entry.getValue().gettrainid()==trainid && entry.getValue().getnooflower()>0 )
			{
				System.out.println("Preferred berth Position is Available");
				train.setnooflower((entry.getValue().getnooflower()) -1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String lp= "lower"+lowerposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,lp);
				pmap.put(pid, passenger);
				return lp;

			}
			if(bprefer.equalsIgnoreCase("L") && entry.getValue().gettrainid()==trainid && entry.getValue().getnooflower()==0 && entry.getValue().getnoofmiddle()>0  )
			{
				System.out.println("Preferred berth Position is Not Available");
				train.setnoofmiddle((entry.getValue().getnoofmiddle())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String mp= "Middle"+middleposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,mp);
				pmap.put(pid, passenger);
				return mp;

			}
			if(bprefer.equalsIgnoreCase("L") && entry.getValue().gettrainid()==trainid && entry.getValue().getnooflower()==0 && entry.getValue().getnoofmiddle()==0 && entry.getValue().getnoofupper()>0   )
			{
				System.out.println("Preferred berth Position is Not Available");
				train.setnoofupper((entry.getValue().getnoofupper())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String up= "Upper"+upperposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,up);
				pmap.put(pid, passenger);
				return up;
			}
		
			if(bprefer.equalsIgnoreCase("M") && entry.getValue().gettrainid()==trainid && entry.getValue().getnoofmiddle()>0 )
			{
				System.out.println("Preferred berth Position is Available");
				train.setnoofmiddle((entry.getValue().getnoofmiddle())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String mp= "Middle"+middleposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,mp);
				pmap.put(pid, passenger);
				return mp;

			}
			if(bprefer.equalsIgnoreCase("M") && entry.getValue().gettrainid()==trainid && entry.getValue().getnooflower()>0 && entry.getValue().getnoofmiddle()==0)
			{
				System.out.println("Preferred berth Position is Not Available");
				train.setnooflower((entry.getValue().getnooflower())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String mp= "Lower"+lowerposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,mp);
				pmap.put(pid, passenger);
				return mp;

			}
			if(bprefer.equalsIgnoreCase("M") && entry.getValue().gettrainid()==trainid && entry.getValue().getnooflower()==0 && entry.getValue().getnoofmiddle()==0 && entry.getValue().getnoofupper()>0   )
			{
				System.out.println("Preferred berth Position is Not Available");
				train.setnoofupper((entry.getValue().getnoofupper())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String up= "Upper"+upperposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,up);
				pmap.put(pid, passenger);
				
				return up;
			}
			
			
			if(bprefer.equalsIgnoreCase("U") && entry.getValue().gettrainid()==trainid && entry.getValue().getnoofupper()>0 )
			{
				System.out.println("Preferred berth Position is Available");
				train.setnoofupper((entry.getValue().getnoofupper())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String up= "Upper"+upperposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,up);
				pmap.put(pid, passenger);
				return up;
			

			}
			if(bprefer.equalsIgnoreCase("U") && entry.getValue().gettrainid()==trainid && entry.getValue().getnoofupper()==0  && entry.getValue().getnooflower()>0 )
			{
				System.out.println("Preferred berth Position is Available");
				train.setnooflower((entry.getValue().getnooflower())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String up= "Lower"+lowerposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,up);
				pmap.put(pid, passenger);
				return up;
			

			}
			
			if(bprefer.equalsIgnoreCase("U") && entry.getValue().gettrainid()==trainid && entry.getValue().getnoofupper()==0  && entry.getValue().getnooflower()==0 && entry.getValue().getnoofmiddle()>0 )
			{
				System.out.println("Preferred berth Position is Available");
				train.setnoofmiddle((entry.getValue().getnoofmiddle())-1);
				train.setnoofseats(entry.getValue().getnoofseats()-1);
				String up= "Middle"+middleposition.remove(0);
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,up);
				pmap.put(pid, passenger);
				return up;
			

			}
			if((bprefer.equalsIgnoreCase("U") || bprefer.equalsIgnoreCase("L") || bprefer.equalsIgnoreCase("M")) &&  
					   entry.getValue().getnoofupper() == 0 && entry.getValue().getnooflower() == 0 &&  
					   entry.getValue().getnoofmiddle() == 0 && entry.getValue().getnoofrac() > 0)
			{
				
				racposition.add(pid);
			    entry.getValue().setnoofrac((entry.getValue().getnoofrac()) -1);
				
				
				String rac="Ticket Added Into Rac";
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,rac);
				pmap.put(pid, passenger);
				return rac;
				
			}
			
			if( (bprefer.equalsIgnoreCase("U") ||bprefer.equalsIgnoreCase("L") || bprefer.equalsIgnoreCase("M")) &&  entry.getValue().getnoofupper()==0 && 
					 entry.getValue().getnooflower()==0 &&  entry.getValue().getnoofmiddle()==0 && entry.getValue().getnoofrac()==0 && entry.getValue().getnoofwaitinglist()>0)  
			{
				
				wlposition.add(pid);
				
					entry.getValue().setnoofwaitinglist((entry.getValue().getnoofwaitinglist()) -1);
				
				
				String wl="Ticket Added Into WaitingList";
				passenger=new Passenger(pid,pname,age,gender,entry.getValue().getsource(),entry.getValue().getdestination(),trainid,bprefer,dt,wl);
				pmap.put(pid, passenger);
				return wl;
				
			}
			else
			{

				return "No Tickets Available";
			}
			
		}
		return "";
		
		
	}
	
	public List<Passenger> allpasslist()
	{
		
		for(Map.Entry<Integer, Passenger> entry:pmap.entrySet()) 
		{
			Passenger p1=entry.getValue();
			if(!existingpid.contains(p1.getpid()))
			{
			plist.add(p1);
			existingpid.add(p1.getpid());
			}
		}
		return plist;
		
	}
	
	public List<Passenger> canceltrain(int pid,int tid)
	{
		
		for(int i=0;i<plist.size();i++)
		{
			if(plist.get(i).getpid()==pid && plist.get(i).gettrainid()==tid )
			{
				int index=i;
				String alloted=plist.get(i).getallotedseat();
				if(String.valueOf(alloted.charAt(0)).equalsIgnoreCase("l"))
				{
					int nooflower=(map.get(tid).getnooflower())+1;
					map.get(tid).setnooflower(nooflower);
					int noofseats=(map.get(tid).getnoofseats())+1;
					map.get(tid).setnoofseats(noofseats);
					if(racposition.size()>0)
					{
						int rpid=racposition.remove();
						System.out.println("The Passenger In Rac Now Move To "+ " "+alloted);
						nooflower=(map.get(tid).getnooflower())-1;
						map.get(tid).setnooflower(nooflower);
						noofseats=(map.get(tid).getnoofseats())-1;
						map.get(tid).setnoofseats(noofseats);
						
						int noofrac=(map.get(tid).getnoofrac())+1;
						map.get(tid).setnoofrac(noofrac);
						
						plist.get(rpid-1).setallotedseat(alloted);
						
						if(wlposition.size()>0 && map.get(tid).getnoofrac() > 0)
						{
							int wpid=wlposition.remove();
							System.out.println("The Passenger In WaitingList Now Move To Rac");
							
							racposition.add(wpid);
							noofrac=(map.get(tid).getnoofrac())-1;
							map.get(tid).setnoofrac(noofrac);
							
							int noofwl=(map.get(tid).getnoofwaitinglist())+1;
							map.get(tid).setnoofwaitinglist(noofwl);
							plist.get(wpid-1).setallotedseat("RAC");
							
							
							
						}
						
					}
					plist.remove(index);
					return plist;
				}
				
				if(String.valueOf(alloted.charAt(0)).equalsIgnoreCase("u"))
				{
					 index=i;
					int noofupper=(map.get(tid).getnoofupper())+1;
					int noofseats=(map.get(tid).getnoofseats())+1;
					map.get(tid).setnoofupper(noofupper);
					map.get(tid).setnoofseats(noofseats);
					if(racposition.size()>0)
					{
						int rpid=racposition.remove();
						System.out.println("The Passenger In Rac Now Move To "+ " "+alloted);
						noofupper=(map.get(tid).getnoofupper())-1;
						map.get(tid).setnoofupper(noofupper);
						noofseats=(map.get(tid).getnoofseats())-1;
						map.get(tid).setnoofseats(noofseats);
						int noofrac=(map.get(tid).getnoofrac())+1;
						map.get(tid).setnoofrac(noofrac);
						plist.get(rpid-1).setallotedseat(alloted);
						
						if(wlposition.size()>0 && map.get(tid).getnoofrac() > 0)
						{
							int wpid=wlposition.remove();
							System.out.println("The Passenger In WaitingList Now Move To Rac");
							
							racposition.add(wpid);
							noofrac=(map.get(tid).getnoofrac())-1;
							map.get(tid).setnoofrac(noofrac);
							
							int noofwl=(map.get(tid).getnoofwaitinglist())+1;
							map.get(tid).setnoofwaitinglist(noofwl);
							plist.get(wpid-1).setallotedseat("RAC");
							
							
							
						}
						
					}
					plist.remove(index);
					return plist;
				}
				
				if(String.valueOf(alloted.charAt(0)).equalsIgnoreCase("m"))
				{
					index=i;
					int noofmiddle=(map.get(tid).getnoofmiddle())+1;
					map.get(tid).setnoofmiddle(noofmiddle);
					int noofseats=(map.get(tid).getnoofseats())+1;
					map.get(tid).setnoofseats(noofseats);
					if(racposition.size()>0)
					{
						int rpid=racposition.remove();
						System.out.println("The Passenger In Rac Now Move To "+ " "+alloted);
						noofmiddle=(map.get(tid).getnoofmiddle())-1;
						map.get(tid).setnoofmiddle(noofmiddle);
						noofseats=(map.get(tid).getnoofseats())-1;
						map.get(tid).setnoofseats(noofseats);
						int noofrac=(map.get(tid).getnoofrac())+1;
						map.get(tid).setnoofrac(noofrac);
						plist.get(rpid-1).setallotedseat(alloted);
						
						if(wlposition.size()>0 && map.get(tid).getnoofrac() > 0)
						{
							int wpid=wlposition.remove();
							System.out.println("The Passenger In WaitingList Now Move To Rac");
							
							racposition.add(wpid);
							noofrac=(map.get(tid).getnoofrac())-1;
							map.get(tid).setnoofrac(noofrac);
							
							int noofwl=(map.get(tid).getnoofwaitinglist())+1;
							map.get(tid).setnoofwaitinglist(noofwl);
							plist.get(wpid-1).setallotedseat("RAC");
							
							
							
						}
						
					}
					
					plist.remove(index);
					return plist;
				}
				
			
				
				
			}
			
		
		}
		return plist;
	}

	public int passengerlist()
	{
		return plist.size();
	}
}
