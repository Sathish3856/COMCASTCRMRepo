 package com.comcast.crm.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
		
	}
	
	public String getSystemDateYYYYDDMM()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days)
	{
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        
        // Create a Calendar object and set it to the current date
        Calendar cal = Calendar.getInstance();
        
        // Add the specified number of days to the current date
        cal.add(Calendar.DAY_OF_MONTH, days);
        
        // Format the future date to the required format
        String reqDate = sim.format(cal.getTime());
        return reqDate;
		
	}
	
   
}
