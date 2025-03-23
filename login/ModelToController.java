package login;


	public interface ModelToController
	{
		void passloginsucc(String name,String pwd);
		void passloginfail(String name,String pwd);
		void managerloginsucc(String mname,String mpwd);
		void managerloginfail(String mname,String mpwd);
	}

