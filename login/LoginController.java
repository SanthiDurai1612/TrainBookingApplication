package login;

class LoginController implements ViewToController,ModelToController{

	public LoginModel model;
	private loginview view;
	
	
	public LoginController(loginview view) {
		this.view=view;
		this.model=new LoginModel(this);
	}
	
	
	public void checkispass(String name,String pwd)
	{
		model.checkispass(name,pwd);
	}
	public void checkismanager(String mname,String mpwd)
	{
		model.checkismanager(mname,mpwd);
	}
	
	public void passloginsucc(String name,String pwd)
	{
		view.passloginsucc(name, pwd);
	}
	
	public void passloginfail(String name,String pwd)
	{
		view.passloginfail(name, pwd);
		
	}
	
	public void managerloginsucc(String mname,String mpwd)
	{
		view.managerloginsucc(mname, mpwd);
	}
	
	public void managerloginfail(String mname,String mpwd)
	{
		view.managerloginfail(mname, mpwd);
	}
	
	
}
