package com.vtigercrm.genericutilies;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * this method return random number
	 * @return random number
	 */
	public int generateRandomNum()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}
	/*
	 * this method return the current date and time
	 * @return current date and time
	 */
	public String getDateAndTime()
	{
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	public static void main(String[] args) {
		System.out.println(new JavaUtility().generateRandomNum());
		System.out.println(new JavaUtility().getDateAndTime());
	}
}
