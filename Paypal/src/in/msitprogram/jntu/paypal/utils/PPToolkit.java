/**
 * 
 */
package in.msitprogram.jntu.paypal.utils;
import java.util.*;
/**
 * @author K.POOJA 18031J0097
 *
 */
public class PPToolkit {

	public static String generateActivationCode() 
	{
		Random rnum = new Random();
	      System.out.println("Random Numbers:");
	      System.out.println("***************");
	         int Low = 10;
	         int High = 10000;
	         int Result = rnum.nextInt(High-Low) + Low;
	      System.out.println(Result);
	    return String.valueOf(Result);
	}

	public static void sendActivationCode(String phone) 
	{
		
		
	}

}
