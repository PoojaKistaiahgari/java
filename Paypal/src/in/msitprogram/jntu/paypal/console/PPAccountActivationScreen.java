package in.msitprogram.jntu.paypal.console;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

import java.io.IOException;
import java.util.Scanner;

public class PPAccountActivationScreen {
	
	public static void show(String email) throws Exception {
		Scanner sc=new Scanner(System.in);
		int i=0;
		do
		{
			System.out.println(" enter the registered email id:");
		    String mail=sc.nextLine();
		if(mail.equals(email))
		{
			System.out.println("Email address is valid");
			i=1;
		}
		else
		{
			System.out.println("invalid account"+"Please enter register mail id");
		}
		}while(i==0);
		PPAccount account=DataStore.lookupAccount(email);
		if(account.getstatus())
		{
			MainMenu.show();
		}
		else
		{
			int i5=0;
			do
			{
				String activationCode=account.getactivate();
			System.out.println("activate code is:"+activationCode);
			System.out.println("enter the activation code:");
			String code=sc.next();
			if(activationCode.equals(code))
			{
				System.out.println("account is activated");
				account.setstatus(true);
				DataStore.writeAccount(account);
				break;
			}
			else
			{
				System.out.println("enter a proper code");
				i5++;
			}
			}while(i5<3);
			MainMenu.show();
		}
		/*
		 * TODO
		 * fetch the account object using email address
		 * check if the account is suspended
		 * if suspended then activate it
		 * if activation code invalid, retry for 2 more attempts
		 * on successful activation show main menu
		 * on failure show the error message and continue to main menu
		 */				
		
		// account = DataStore.lookupAccount(email);
	
		//check if account is active. if yes then ask for suspending it
		
		// if yes suspend it if not go back to main menu
		
		// accept activation code, check if valid, if not give 2 more attempts
		
		//proceed to main menu
		MainMenu.show();
	
	}

}