package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import in.msitprogram.jntu.paypal.utils.PPToolkit;

public class PPAccount implements Serializable
{
	/**
	 * 
	 */
	private Profile profile;
	private String email;
	private double accountBal;
	private boolean isActivated;
	private String activationCode;
	private ArrayList<Transaction> transactions;
	private String dob;
	private String p;
	private String bname;
	private double amount;
	private String pemail;
	private int type;
	int Result;
	public PPAccount(Profile profile) 
	{
		// TODO Auto-generated constructor stub
		this.profile=profile;
		
	}
 
	 public void setstatus(boolean status)
	 {
		 isActivated=status;
	 }
	 public boolean getstatus()
	 {
		 return isActivated;
	 }
	 
	public String toString()
	{
		// implement this function to return a beautiful looking string
		// to display the summary of the account
		return null;
	}

	public void activate(String activationCode) 
	{
	this.activationCode=activationCode;			
	}
	public String getactivate(){
		return activationCode;
	}
	public void suspend() 
	{
		// TODO Auto-generated method stub
	}


	public boolean withdraw(float withdrawAmount)
	{
		
		return false;
	}


	public boolean addFunds(float creditAmount) 
	{
		
		return false;
	}
	
	public boolean sendMoney(float creditAmount) 
	{
		
		return false;
	}
	
	public boolean requestMoney(float creditAmount) 
	{
		
		return false;
	}

	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		// TODO Auto-generated method stub
		return email;
	}
	public void setdob(String d)
	{
		dob=d;
	}
	public void getdob()
	{
		System.out.println(dob);
	}
	public void setpan(String pan)
	{
		p=pan;
	}
	public void getpan()
	{
		System.out.println(p);
	}
	public void setbname(String name)
	{
		bname=name;
	}
	public String getbname()
	{
		System.out.println(bname);
		return bname;
	}
	public void setpemail(String email)
	{
		pemail=email;
	}
	public String getpemail()
	{
		System.out.println(pemail);
		return pemail;
	}
	public void setamt(double a)
	{
		amount=a;
	}
	public void settype(int t)
	{
		type=t;
	}
	public int gettype()
	{
		System.out.println(type);
		return type;
	}
	public double getamt()
	{
		System.out.println(amount);
		return amount;
	}
	/*public void setcredit(double credit)
	{
		accountBal=amount+credit;
	}
	public double getcredit()
	{
		return accountBal;
	}
	public void setdebit(double debit)
	{
		accountBal=amount-debit;
	}
	public double getdebit()
	{
		return accountBal;
	}
	public double balance()
	{
		return accountBal;
	}*/
}

