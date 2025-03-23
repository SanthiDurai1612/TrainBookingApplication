package Cancellation;

import java.util.List;

import dto.Passenger;

public class CancelController {

	CancelView view;
	CancelModel model;
	CancelController(CancelView view)
	{
		this.view=view;
		model=new CancelModel();
	}
	
	public void canceltrain(int pid,int tid)
	{
		List<Passenger> plist=model.canceltrain(pid,tid);
		view.cancelsucc(plist);
	}
}
