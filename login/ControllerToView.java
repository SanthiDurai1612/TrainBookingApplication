package login;


	public interface ControllerToView
	{
		void passloginsucc(String name,String pwd);
		void passloginfail(String name,String pwd);
		void managerloginsucc(String mname,String mpwd);
		void managerloginfail(String mname,String mpwd);
	}
