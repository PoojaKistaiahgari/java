package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;
import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPBusinessAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

public class PPNewAccountScreen {
	Profile profile;
	PPAccount account;
	String email;
	Scanner scan;
	int type;
	
	public PPNewAccountScreen(String email) {
		profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
	}

	public void show() throws Exception {
		//check if the account with the given email address exists 
		//if not create the user profile
		//show the account types
		//based on the given account type selected create the account object
		profile=createProfile();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Personal account\n"+"2.Student account\n"+"3.Bussinessaccount");
		System.out.println("enter your choices:");
		int s=sc.nextInt();
		switch(s)
		{
		case 1:
			System.out.println("Personal account");
			createPersonalAccount();
			completeAccountCreation();
			break;
		case 2:
			System.out.println("Student account");
			createStudentAccount();
			completeAccountCreation();
			break;
		case 3:
			System.out.println("Bussiness account");
			createBusinessAccount();
			completeAccountCreation();
			break;
		 default:System.out.println("enter your choice:");
		}
	}

	private Profile createProfile() {
		// use this for creating the profile
		System.out.println("enter your name:");
		Scanner sc1=new Scanner(System.in);
		String n=sc1.nextLine();
		profile.setname(n);
		System.out.println("enter your address:");
		String add=sc1.nextLine();
		profile.setaddress(add);
		System.out.println("enter your phone:");
		String ph=sc1.nextLine();
		profile.setphone(ph);
		return profile;
	}

	private void createBusinessAccount() throws IOException {
		//use this for creating the business account
		account=new PPAccount(profile);
		account.setEmail(email);
		Scanner sc2=new Scanner(System.in);
		System.out.println("enter business name:");
		String bn=sc2.nextLine();
		account.setbname(bn);
		System.out.println("enter PAN number:");
		String bpan=sc2.nextLine();
		account.setpan(bpan);
		account.setstatus(false);
		
	}

	private void createStudentAccount() throws IOException {
		//use this for creating the student account 
		account=new PPAccount(profile);
		Scanner sc3=new Scanner(System.in);
		System.out.println("enter date of birth:");
		String Dob=sc3.nextLine();
		account.setdob(Dob);
		System.out.println("enter parent paypal emailid:");
		String pemail=sc3.nextLine();
		account.setpemail(pemail);
		account.setstatus(false);
	}

	/*
	 * this method create the personal account, saves it to the file system
	 * and redirects the users to the next screen
	 */
	
	private void createPersonalAccount() throws IOException {
		//use this for creating the personal account
		account=new PPAccount(profile);
		Scanner sc4=new Scanner(System.in);
		account.setEmail(email);
		System.out.println("enter date of birth:");
		String Dob=sc4.nextLine();
		account.setdob(Dob);
		System.out.println("enter PAN number:");
		String pan1=sc4.nextLine();
		account.setpan(pan1);
		System.out.println("enter the amount :");
		double amt=sc4.nextDouble();
		account.setamt(amt);
		account.setstatus(false);
	}
	
	private void completeAccountCreation() throws Exception{
		//generate activation code and set it to account
		String code=PPToolkit.generateActivationCode();
		account.activate(code);
		DataStore.writeAccount(account);
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Activate account\n"+"2.Mainmenu");
		System.out.println("enter your choice:");
		int c=sc.nextInt();
		switch(c)
		{
		  case 1:System.out.println("--Activate account--");
		  PPAccountActivationScreen.show(email);
		  break;
		  case 2:System.out.println("--Mainmenu--");
		  PPAccountScreen.show();
		  break; 
		}
		//send activation code to the phone
		//ask & redirect the user to the activation screen or the main menu
		
	}

}
