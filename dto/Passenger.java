package dto;

public class Passenger {
	
	String name;
	int age;
	String gender;
	String source;
	String destination;
	int trainid;
	String berthpreference;
	String allotedseat;
	int id;
	String dt;
	int amount;
	int tatkalamt;
	
	public Passenger(int id,String name,int age,String gender,String source,String destination,int trainid,
			String berthpreference,String dt,String allotedseat)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.source=source;
		this.destination=destination;
		this.trainid=trainid;
		this.berthpreference=berthpreference;
		this.allotedseat=allotedseat;
		this.dt=dt;
		
	
	}
	
	//for tatkal passenger
	Passenger(int id,String name,int age,String gender,String source,String destination,int trainid)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.source=source;
		this.destination=destination;
		this.trainid=trainid;
		this.allotedseat=allotedseat;
		
	
	}
	
	public int getpid()
	{
		return id;
	}
	
	public void setallotedseat(String allotedseat)
	{
		this.allotedseat= allotedseat;
	}
	
	public String getallotedseat()
	{
		return allotedseat;
	}
	public String getname()
	{
		return name;
	}
	public int getage()
	{
		return age;
	}
	public String getgender()
	{
		return gender;
	}
	public String getsource()
	{
		return source;
	}
	public String getdestination()
	{
		return destination;
	}
	public int gettrainid()
	{
		return trainid;
	}
	public String getberthpreference()
	{
		return berthpreference;
	}
	public String getallotedberth()
	{
		return allotedseat;
	}

}
