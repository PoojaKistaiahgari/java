/**
 * 
 */
package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.persistance.DataStore;

/**
 * @author K.POOJA  18031J0097
 *
 */
public class MainMenu {
	
	public static void show() throws Exception{
		System.out.print("1.sign up\n"+"2.sign in or login\n"+"3.exit\n");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your choices:");
		int s=sc.nextInt();
		sc.nextLine();
		String email;
		switch(s)
		{
		     case 1:
		    	 System.out.print("1.sign up\n");
		    	System.out.print("enter emailid:");
		    	 email=sc.nextLine();
		    	 if(( DataStore.lookupAccount(email))!=null)
		    	 {
	                System.out.println("Already used mail Address");
		    		 MainMenu.show();
		    	 }
		    	 else
		    	 {
		    		 System.out.println("**--Ready create a account--** ");
		    		 PPNewAccountScreen account= new PPNewAccountScreen(email);
		    		 account.show();
		    	 }
		    	break;
		    case 2:
		    	 System.out.print("sign in\n");
		    	System.out.println("enter emailid:");
		    	 email=sc.nextLine();
		    	 if(( DataStore.lookupAccount(email))!=null)
		    	 {
		    		 PPAccountScreen screen=new PPAccountScreen(email);
		    		 screen.show();
		    	 }
		    	 else
		    	 {
		    		 System.out.println("Goto signup and register");
		    		 MainMenu.show();
		    	 }
		    	break;
		    case 3:
		    	System.out.println("exit");
		    	break;
		    default:System.out.println("enter your choice:");
		   }
	}

}
