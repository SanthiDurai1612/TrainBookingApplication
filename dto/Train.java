package dto;

import java.util.List;
import java.util.Queue;

public class Train {
	
	int trainid;
	String source;
	String destination;
	String date;
	int noofseats;
	int nooflower;
	int noofupper;
	int noofmiddle;
	String berthprefernce;
	int noofrac;
	int noofwaitinglist;
	int nooftatkaltickets;
	List<Integer> lowerpositions;
	List<Integer> upperpositions;
	List<Integer> middlepositions;
	Queue<Integer> racpositions;
	Queue<Integer> waitinglistpositions;
	public int amount=250;
	public int tatkalamount=500;
	
	public Train(int trainid,String source,String destination,String date,int noofseats,int noofrac,int noofwaitinglist,int nooftatkaltickets)
	{
		this.settrainid(trainid);
		this.setsource(source);
		this.setdestination(destination);
		this.setdate(date);
		this.setnoofseats(noofseats);
		nooflower=noofseats/3;
		this.setnooflower(nooflower);
		noofupper=noofseats/3;
		this.setnoofupper(noofupper);
		noofmiddle=noofseats/3;
		this.setnoofmiddle(noofmiddle);
		this.setnoofrac(noofrac);
		this.setnoofwaitinglist(noofwaitinglist);
		this.setnooftatkaltickets(nooftatkaltickets);
		
	}
	public Train()
	{
		
	}
	public void setamount(int amount)
	{
		this.amount=amount;
	}
	public int getamount()
	{
		return amount;
	}
	public void settatkalamt(int tatkalamt)
	{
		this.tatkalamount=tatkalamt;
	}
	
	public int gettatkalamt()
	{
		return tatkalamount;
	}
	public void settrainid(int trainid)
	{
		this.trainid=trainid;
		
	}
	public int gettrainid()
	{
		return trainid;
	}
	public void setsource(String source)
	{
		this.source=source;
	}
	public String getsource()
	{
		return source;
	}
	public void setdestination(String destination)
	{
		this.destination=destination;
	}
	public String getdestination()
	{
		return destination;
	}
	public void setdate(String date)
	{
		this.date=date;
	}
	public String getdate()
	{
		return date;
	}
	public void setnoofseats(int noofseats)
	{
		this.noofseats=noofseats;
	}
	public int getnoofseats()
	{
		return noofseats;
	}
	public void setnooflower(int nooflower)
	{
		this.nooflower=nooflower;
		
	}
	public int getnooflower()
	{
		return nooflower;
	}
	public void setnoofupper(int noofupper)
	{
		this.noofupper=noofupper;
		
	}
	public int getnoofupper()
	{
		return noofupper;
		
	}
	public void setnoofmiddle(int noofmiddle)
	{
		this.noofmiddle=noofmiddle;
	}
	public int getnoofmiddle()
	{
		return noofmiddle;
	}
	
	public void setnoofrac(int noofrac)
	{
		this.noofrac=noofrac;
	}
	public int getnoofrac()
	{
		return noofrac;
	}
	public void setnoofwaitinglist(int noofwaitinglist)
	{
		this.noofwaitinglist=noofwaitinglist;
	}
	public int getnoofwaitinglist()
	{
		return noofwaitinglist;
	}
	public void setnooftatkaltickets(int nooftatkaltickets)
	{
		this.nooftatkaltickets=nooftatkaltickets;
	}
	public int getnooftatkaltickets()
	{
		return nooftatkaltickets;
	}
	
	

}
