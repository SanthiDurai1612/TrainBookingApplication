package booking;

import java.util.List;

import dto.Passenger;

public class BookingController {
   public BookingView view;
   public BookingModel model;
	public BookingController(BookingView view)
	{
		this.view=view;
		model=new BookingModel();
	}
	
	public void passdtls(int pid,String pname,int age,String gender,String berthprefer,int trainid,String dt)
	{
		String res=model.passdtls(pid,pname,age,gender,berthprefer,trainid,dt);
		
		view.bookedtkt(res);
		
	}
	
	public void allpassdtls()
	{
		List<Passenger> plist=model.allpasslist();
		view.showallpass(plist);
	}
	
	
}
