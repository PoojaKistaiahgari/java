package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;

public class PPAccountScreen {
	static PPAccount account;
	Scanner scan;
	static String email;
	static double balance;
	static double creditbal;
	static double debitbal;
	
	public PPAccountScreen(String email) throws Exception {
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email);
		this.email=email;
	}

	public static void show() throws Exception {
		
		//check if account is active
		System.out.println(account.getstatus());
		if(account.getstatus())
		{
			System.out.println("**--welcome to  account--**");
			System.out.println("1.credit\n"+"2.debit\n"+"3.balance\n"+"4.sendmoney\n"+"5.exit");
			Scanner sc3=new Scanner(System.in);
			System.out.println("enter your choice:");
			int l=sc3.nextInt();
			switch(l)
			{
			case 1:System.out.println("--credit--");
			System.out.println("enter the amount to add into balance:");
			double c=sc3.nextDouble();
			credit(c);
			PPAccountScreen.show();
			break;
			case 2:System.out.println("--debit--");
			System.out.println("enter the amount to debit:");
			double d=sc3.nextDouble();
			debit(d);
			PPAccountScreen.show();
			break;
			case 3:System.out.println("--balance--");
			balance=account.getamt();
			System.out.println(balance);
			PPAccountScreen.show();
			break;
			case 4:System.out.println("--sendmoney--");
			sendMoney();
			break;
			case 5:System.out.println("--exit--");
			MainMenu.show();
			break;
			default:System.out.println("enter your choice:");
			}
		}
		//if active
		
			// print the account summary
			//System.out.println(account);
			
			// print menu and accept menu options
			// for all the paypal account operations
			else
			{
				PPAccountActivationScreen.show(email);		
			}
		
	}
	
	public static void credit(double credit) throws Exception
	{
		balance=account.getamt();
		creditbal=balance+credit;
		account.setamt(creditbal);
		System.out.println("credited amount"+creditbal);
		DataStore.writeAccount(account);
	}
	
	public static void debit(double debit) throws Exception
	{
		balance=account.getamt();
		debitbal=balance-debit;
		account.setamt(debitbal);
		System.out.println("debited amount"+debitbal);
		DataStore.writeAccount(account);
	}
	
	
	private void withdrawFunds() throws IOException {
		// implement the withdraw funds user interface here
		
		//use the account object as needed for withdraw funds
		
	}

	private void requestMoney() {
		// 	implement the request money user interface here
		
		//use the account object as needed for request money funds
	}

	private static void sendMoney() throws Exception {
		// implement the send moeny user interface here
		
		//use the account object as needed for send money funds
		System.out.println("enter email");
		Scanner sc=new Scanner(System.in);
		String mail=sc.nextLine();
		PPAccount account1=DataStore.lookupAccount(mail);
		if(account1!=null)
		{
			System.out.println("enter the amount to credit for sender:");
			double c=sc.nextDouble();
			balance=account.getamt();
			if(balance>c)
			{
				double bal1=account1.getamt();
				bal1=bal1+c;
				account1.setamt(bal1);
				account.setamt(balance-c);
				DataStore.writeAccount(account);
				DataStore.writeAccount(account1);
			}
			else
			{
				System.out.println("entered the amount is excesss");
				System.out.println("available:"+balance);
				
			}
			
		}
	}

	private void addFunds() throws IOException {
		// implement the add funds user interface here
		
		//use the account object as needed for add funds
	}
	

}