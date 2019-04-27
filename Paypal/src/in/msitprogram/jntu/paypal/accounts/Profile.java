package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;

public class Profile implements Serializable{
	
	private String name;
	private String address;
	private String phone;
	public void setname(String na)
	{
		name=na;
	}
	public void getname()
	{
		System.out.println(name);
	}
	public void setaddress(String ad)
	{
		address=ad;
	}
	public void getaddress()
	{
		System.out.println(address);
	}
	public void setphone(String pho)
	{
		phone=pho;
	}
	public void getphone()
	{
		System.out.println(phone);
	}
}
