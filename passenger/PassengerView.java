package passenger;

import java.util.*;
import Cancellation.CancelView;
import repository.*;
import dto.Passenger;
import dto.Train;
import booking.BookingView;
public class PassengerView {

	
	public PassengerController controll;
	public BookingView bview;
	
	
	public PassengerView()
	{
		this.controll=new PassengerController(this);
		this.bview=new BookingView(this);
	}
	
	public void option()
	{
		Scanner in=new Scanner(System.in);
		System.out.println();
		System.out.println("Welcome To Passenger Login!!!");
		System.out.println();
		System.out.println("1) Book Tickets");
		System.out.println("2) Show All Available Trains");
		System.out.println("3) Show Trains For Your Source To Destination");
		System.out.println("4) Cancel Booked Tickets");
		System.out.println("5) Exit For Now");
		System.out.println();
		int choice=in.nextInt();
		
		if(choice==1)
		{
			
			
			bview.view();
			
		}
		else if(choice==2)
		{
			System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ", "Train Id","Source",
					"Destination","Date","No of Seats","No of Rac","No of WL","No of Tatkal Tkts \n ");
			 System.out.println("---------------------------------------------------------------------------------------------------------------------");
			    
			controll.showalltrain();
			
		}
		
		else if(choice==3)
		{
			System.out.println("Enter Your Source:");
			String src=in.next();
			System.out.println("Enter Your Destination:");
			String destination=in.next();
			System.out.println("Enter Your Date:(d/m/yyyy)");
			String date=in.next();
			System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s %13s %13s %13s ", "Train Id","Source",
					"Destination","Date","No of Seats","No of Lower","No of Middle","No of Upper","No of Rac","No of WL","No of Tatkal Tkts \n ");
			 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
			    
			
			controll.showspecifictrain(src,destination,date);
			
			
		}
		else if(choice==4)
		{
			CancelView view=new CancelView();
			view.cview();
		}
		
		else
		{
			System.out.println("---------Exitted----------");
			return;
		}
	}

	
	public void showalltrain(List<Train> alltrain)
	{
		for(int i=0;i<alltrain.size();i++)
		{
			System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s ",alltrain.get(i).gettrainid(),alltrain.get(i).getsource(),alltrain.get(i).getdestination(),
		alltrain.get(i).getdate(),alltrain.get(i).getnoofseats(),alltrain.get(i).getnoofrac(),alltrain.get(i).getnoofwaitinglist(),alltrain.get(i).getnooftatkaltickets());
			
		}
		System.out.println();
		System.out.println("==============================================================================================================================");
	}
	
	public void spectrainlist(List<Train> spectrain)
	{
		for(int i=0;i<spectrain.size();i++)
		{
			System.out.printf("\n %10s %13s  %13s  %13s  %13s  %13s  %13s  %13s %13s %13s %13s",spectrain.get(i).gettrainid(),spectrain.get(i).getsource(),spectrain.get(i).getdestination(),
		spectrain.get(i).getdate(),spectrain.get(i).getnoofseats(),spectrain.get(i).getnooflower(),spectrain.get(i).getnoofupper(),spectrain.get(i).getnoofmiddle(),spectrain.get(i).getnoofrac(),spectrain.get(i).getnoofwaitinglist(),spectrain.get(i).getnooftatkaltickets());
			
		}
		System.out.println();
		System.out.println("=============================================================================================================================================================================");
	}
	
}
