package Cancellation;

import java.util.List;
import java.util.Scanner;

import booking.BookingView;
import dto.Passenger;
import passenger.PassengerView;

public class CancelView {

	public CancelController control;
	Scanner in=new Scanner(System.in);
	public CancelView()
	{
		control=new CancelController(this);
	}
	public void cview()
	{
		System.out.println();
		System.out.println("Enter PassengerID:");
		int pid=in.nextInt();
		System.out.println("Enter Train ID:");
		int tid=in.nextInt();
		control.canceltrain(pid,tid);
		
	}
	
	public void cancelsucc(List<Passenger> plist)
	{
		PassengerView view=new PassengerView();
         BookingView bview=new BookingView(view);
		System.out.println("Ticket Cancelled Successfully");
		bview.showallpass(plist);
			view.option();
		  
		}
	}
