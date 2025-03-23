package booking;

import java.util.List;

import java.util.Scanner;

import dto.Passenger;
import dto.Train;
import login.*;
import passenger.*;
import repository.TrainDetails;
public class BookingView {

	Scanner in=new Scanner(System.in);
	public BookingController bcontroll;
	public loginview loginview;
	public PassengerView passview;
	public TrainDetails dtls;
	int id=0;
	public BookingView(PassengerView passview)
	{
        
		loginview=new loginview();
		this.passview=passview;
		bcontroll=new BookingController(this);
		
	}
	public void view()
	{
		System.out.println("Enter Train Id");
		int trainid=in.nextInt();
		System.out.println("Enter Travel Date");
		String dt=in.next();
		dtls=new TrainDetails();
		int totalseats=dtls.totalseats(trainid,dt);
		
		System.out.println("Enter No of Passengers");
		int n=in.nextInt();
		if(n>totalseats)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Only "+totalseats+" Tickets "+" Are Available ");
			System.out.println("------------------------------------------------");
			passview.option();
			
		}

		for(int i=0;i<n;i++)
		{
			id=id+1;
			System.out.println("Enter Passenger Name:");
			String pname=in.next();
			System.out.println("Enter Age");
			int age=in.nextInt();
			System.out.println("Enter Gender");
			String gender=in.next();

			System.out.println("Enter BerthPreference: Ex) L/M/U");
			String berthprefer=in.next();
			System.out.println();
			bcontroll.passdtls(id,pname,age,gender,berthprefer,trainid,dt);
			
		}
		
		bcontroll.allpassdtls();
	}
	
	public void bookedtkt(String res)
	{
		System.out.println("Successfully Booked Your Ticket:"+" "+ res);
	}
	
	public void showallpass(List<Passenger> plist)
	{
		System.out.printf("\n %10s %13s %13s %13s %13s %13s %13s %13s \n","PassengerId","Name","Age","Gender","Source","Destination","PreferedBerth","AllotedBerth");
		for(int i=0;i<plist.size();i++)
		{
			System.out.printf("\n %10s %13s %13s %13s %13s %13s %13s %13s \n",plist.get(i).getpid(), plist.get(i).getname(),plist.get(i).getage(),plist.get(i).getgender(),
				plist.get(i).getsource(),plist.get(i).getdestination(),plist.get(i).getberthpreference(),plist.get(i).getallotedberth());
		}
		Train train=new Train();
		int amt=train.amount;
		int total=plist.size()*amt;
		System.out.println();
		System.out.println("Total Amount To Pay:"+total);
		System.out.println();
		
		id=plist.size();
		System.out.println("Do you need to continue the booking? Press 1");
		int n=in.nextInt();
		if(n==1)
		{
			view();
		}
		else
		{
		passview.option();
		}
	}
	
	
	
	
}
