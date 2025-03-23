package Cancellation;

import java.util.List;

import dto.Passenger;
import repository.TrainDetails;

public class CancelModel {

	public List<Passenger> canceltrain(int pid,int tid)
	{
		List<Passenger> plist=TrainDetails.getInstance().canceltrain(pid, tid);
		return plist;
	}
}
