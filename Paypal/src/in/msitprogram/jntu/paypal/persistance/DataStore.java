package in.msitprogram.jntu.paypal.persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;

public class DataStore
{
	
	public static PPAccount lookupAccount(String email) throws Exception 
	{
		PPAccount account = null; //initialize it after reading from file
		// write code to open the files, read
		try
		{
		FileInputStream fis=new FileInputStream("F:\\project\\project.txt");
		ObjectInputStream oi = new ObjectInputStream(fis);
		Vector<PPAccount> v=(Vector<PPAccount>)oi.readObject();
		
		for(int i=0;i<v.size();i++)
		{
			account=v.get(i);
			System.out.println("entered email id:"+account.getEmail());
		
		if(account.getEmail().equals(email))
			return account;
		}
		oi.close();
		fis.close();
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		return null;
	}
	
	public static void writeAccount(PPAccount account) throws Exception
	{
		Vector<PPAccount>v =new Vector<PPAccount>();
		try
		{
		FileInputStream fis=new FileInputStream("F:\\project\\project.txt");
		ObjectInputStream oi = new ObjectInputStream(fis);
		 v=(Vector<PPAccount>)oi.readObject();
		oi.close();
		fis.close();
		}
		catch(Exception e)
		{
		}
		for(int i=0;i<v.size();i++)
		{
			if(account.getEmail().equals(v.get(i).getEmail()))
			{
				v.remove(v.get(i));
			}
		}
		try
		{
		
		FileOutputStream fout=new FileOutputStream("F:\\project\\project.txt");
		ObjectOutputStream os=new ObjectOutputStream(fout);
		v.add(account);
		os.writeObject(v);
		System.out.println("data writed ");
        os.close();
        fout.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
}
