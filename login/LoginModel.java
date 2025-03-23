package login;

import login.ControllerToModel.*;

public class LoginModel implements controllertomodel {
	
	private ModelToController logincontroller;

	
	public LoginModel(LoginController logincontroller) {
		this.logincontroller=logincontroller;
	}
	
	
	public void checkispass(String name,String pwd)
	{
		if(name.isEmpty())
		{
			System.out.println("Name Should Not Be Empty");
			logincontroller.passloginfail(name,pwd);
		}
		else if(pwd.length()< 8 || pwd.length()>10)
		{
			System.out.println("Password Length Should Not Below 8 And Max 10");
			logincontroller.passloginfail(name,pwd);
		}
		else
		{
			logincontroller.passloginsucc(name,pwd);
		}
		
	}
	
	public void checkismanager(String mname,String mpwd)
	{
		if(mname.equals("santhi") && mpwd.equals("santhi@10"))
		{
			logincontroller.managerloginsucc(mname,mpwd);
			
		}
		else
		{
			logincontroller.managerloginfail(mname,mpwd);
		}
		
	}

}
