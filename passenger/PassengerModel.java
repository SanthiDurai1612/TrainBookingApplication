package passenger;
import repository.*;

import java.util.List;

import dto.*;

public class PassengerModel {

	public List<Train> showalltrain()
	{
		List<Train> alltrains = TrainDetails.getInstance().showalltrain();
		return alltrains;
		
	}
	public List<Train> showspecifictrain(String src,String desti,String dt)
	{
		List<Train> spectrain=TrainDetails.getInstance().showspectrain(src,desti,dt);
		return spectrain;
		
	}

}
