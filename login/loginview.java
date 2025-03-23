package login;

import java.util.*;

import Manager.ManagerController;
import Manager.ManagerView;
import passenger.*;
public class loginview implements ControllerToView {
	
    Scanner in=new Scanner(System.in);
    private LoginController logincontroller;
    public ManagerView mview;
    public ManagerController controll;
    public loginview() {
		logincontroller=new LoginController(this);
		mview=new ManagerView();
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginview view=new loginview();
		view.loginweb();

	}
	
	public void loginweb()
	{
		
		System.out.println("---WELCOME TO THE ONLINE TRAIN BOOKING APPLICATION---");
		System.out.println();
		System.out.println("HERE ARE TWO LOGINS \n 1) PASSENGER \n 2) MANAGER");
		System.out.println();
		int choice=in.nextInt();
		if(choice==1)
		{
			System.out.println("Enter Your Name:");
			String name=in.next();
			in.nextLine();
			System.out.println("Enter Password:");
			String pwd=in.next();
			logincontroller.checkispass(name,pwd);
			
		}
		else if(choice==2)
		{
			System.out.println("Enter Your Name:");
			String mname=in.next();
			
			System.out.println("Enter Password:");
			String mpwd=in.next();
			logincontroller.checkismanager(mname,mpwd);
		}
		else
		{
			System.out.println("Exited");
		}
	}
	
	public void passloginsucc(String name,String pwd)
	{
		
		System.out.println("Passenger Login Successfull with Name"+" "+name);
		System.out.println("---------------------------------------------------");
		System.out.println();
		PassengerView pview=new PassengerView();
		pview.option();
		
	}

	public void passloginfail(String name,String pwd)
	{
		System.out.println("Passenger Login Failure");
		System.out.println();
		loginweb();
	}
	
	public void  managerloginsucc(String mname,String mpwd)
	{
		
		System.out.println("Manager Login Successfull With Name"+" "+mname);
		mview.moption();
		
	}

	public void managerloginfail(String mname,String mpwd)
	{
		
		System.out.println("Manager Login Failure");
		loginweb();
	}

	
	
}
