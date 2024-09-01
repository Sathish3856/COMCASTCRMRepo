package com.testng;

import java.util.Date;

import org.testng.annotations.Test;

public class CaptureTimeStamps 
{

	@Test
	public void catureTime()
	{
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
		
	}
}
