package Manager;

import java.util.List;

import dto.Train;
import repository.TrainDetails;

public class ManagerModel {

	public TrainDetails dtls;
	public ManagerModel()
	{
		dtls =new TrainDetails();
	}
	public List<Train> addtrain(int id,String src,String des,String dt,int seats,int rac,int wl,int tatkal)
	{
		List<Train> alltrain=dtls.addtrain(id,src,des,dt,seats,rac,wl,tatkal);
		return alltrain;
	}
	
	public List<Train> removetrain(int rtid)
	{
		List<Train> alltrain=dtls.removetrain(rtid);
		return alltrain;
	}
}
