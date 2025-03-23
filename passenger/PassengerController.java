package passenger;

import java.util.List;

import dto.Train;

public class PassengerController {
	
	public PassengerView view;
	public PassengerModel model;
	PassengerController(PassengerView view)
	{
		this.view = view;
		this.model=new PassengerModel();
	}
	
	public void showalltrain()
	{
		List<Train> alltrain = model.showalltrain();
		view.showalltrain(alltrain);
		view.option();
	}
	
	public void showspecifictrain(String src,String destination,String date)
	{
		List<Train> spectrain=model.showspecifictrain(src,destination,date);
		view.spectrainlist(spectrain);
		view.option();
		
	}
	

}
