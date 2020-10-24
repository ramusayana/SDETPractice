package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utilities {
	
	public String timestamp() {
		Date dateObj = new Date();
		String dateFormat = "dd-MMM-yyyy (hh-mm-ss)";
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(dateObj).toString();
	}
	
	/*public static int randomNumberBetweenZeroToSpecifiedValue(int n)
	{
		Random randomNumber = new Random(); 
		return randomNumber.nextInt(n);
	} */
}
