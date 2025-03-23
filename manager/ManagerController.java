package Manager;

import java.util.List;

import dto.Train;

public class ManagerController {
	
	public ManagerView view;
	public ManagerModel model;
	public ManagerController(ManagerView view)
	{
		this.view=view;
		model=new ManagerModel();
	}
	
	public List<Train> addtrain(int id,String src,String des,String dt,int seats,int rac,int wl,int tatkal)
	{
		List<Train> res=model.addtrain(id,src,des,dt,seats,rac,wl,tatkal);
		return res;
	}
	public List<Train> removetrain(int rtid)
	{
		List<Train> res=model.removetrain(rtid);
		return res;
	}

}
