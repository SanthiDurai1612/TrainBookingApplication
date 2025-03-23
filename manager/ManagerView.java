package Manager;

import java.util.List;
import java.util.Scanner;

import dto.Train;

public class ManagerView {

	Scanner in=new Scanner(System.in);
	public ManagerController controll;

	public ManagerView()
	{
		controll=new ManagerController(this);
		
	}
	public void moption()
	{
		System.out.println();
		System.out.println(" ---------Welcome To Manager Login--------- ");
		System.out.println("1) Add New Train");
		System.out.println("2) Delete Train");
		System.out.println("3) Exit");
		System.out.println();
		int choice=in.nextInt();
		if(choice==1)
		{
			addtrain();
		}
		else if(choice==2)
		{
			removetrain();
		}
		else
		{
			System.out.println("Exitted");
			return;
		}
	}
	
	public void addtrain()
	{
		System.out.println("Enter Train Id:");
		int id=in.nextInt();
		System.out.println("Enter Source:");
		String src=in.next();
		System.out.println("Enter Destination:");
		String des=in.next();
		System.out.println("Enter Date:");
		String dt=in.next();
		System.out.println("Enter No of Seats:");
		int seats=in.nextInt();
		System.out.println("Enter No of RAC Seats:");
		int rac=in.nextInt();
		System.out.println("Enter No of WaitingList Seats:");
		int wl=in.nextInt();
		System.out.println("Enter No of Tatkal Seats:");
		int tatkal=in.nextInt();
		
		
		List<Train> alltrain=controll.addtrain(id,src,des,dt,seats,rac,wl,tatkal);
		
			System.out.println("Train Added Successfully With TrainId:"+id);
			
	System.out.println();
	
			System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ", "Train Id","Source",
					"Destination","Date","No of Seats","No of Rac","No of WL","No of Tatkal Tkts \n ");
			 System.out.println("---------------------------------------------------------------------------------------------------------------------");
			    
			 
			for(int i=0;i<alltrain.size();i++)
			{
				System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ",alltrain.get(i).gettrainid(),alltrain.get(i).getsource(),alltrain.get(i).getdestination(),
			alltrain.get(i).getdate(),alltrain.get(i).getnoofseats(),alltrain.get(i).getnoofrac(),alltrain.get(i).getnoofwaitinglist(),alltrain.get(i).getnooftatkaltickets());
				
			}
			System.out.println();
			System.out.println("==============================================================================================================================");
		moption();
		
		
	}
	
	public void removetrain()
	{
		System.out.println("");
		System.out.println("Enter Train ID Which You Want To Remove");
		int rtid=in.nextInt();
		List<Train> alltrain=controll.removetrain(rtid);
		
		System.out.println("Train Removed Successfully With TrainId:"+rtid);
		
		System.out.println();
		
				System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ", "Train Id","Source",
						"Destination","Date","No of Seats","No of Rac","No of WL","No of Tatkal Tkts \n ");
				 System.out.println("---------------------------------------------------------------------------------------------------------------------");
				    
				 
				for(int i=0;i<alltrain.size();i++)
				{
					System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ",alltrain.get(i).gettrainid(),alltrain.get(i).getsource(),alltrain.get(i).getdestination(),
				alltrain.get(i).getdate(),alltrain.get(i).getnoofseats(),alltrain.get(i).getnoofrac(),alltrain.get(i).getnoofwaitinglist(),alltrain.get(i).getnooftatkaltickets());
					
				}
				System.out.println();
				System.out.println("==============================================================================================================================");
				moption();
			
	}
	
	
}
