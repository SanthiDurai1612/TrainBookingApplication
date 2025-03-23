package login;

public class ControllerToModel {

	public interface controllertomodel
	{
		void checkispass(String name,String pwd);
		void checkismanager(String mname,String mpwd);
	}
}
