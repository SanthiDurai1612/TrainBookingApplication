package booking;
import java.util.List;

import dto.Passenger;
import repository.*;

public class BookingModel {

	public String passdtls(int pid,String name,int age,String gen,String bprefer,int trainid,String dt)
	{
		String bookedtkt=TrainDetails.getInstance().booktopass(pid,name,gen,age,bprefer,trainid,dt);
		return bookedtkt;
	}
	
	public List<Passenger> allpasslist()
	{
		List<Passenger> plist=TrainDetails.getInstance().allpasslist();
		return plist;
	}
	
	
}
