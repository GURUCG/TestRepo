package com.vtigercrm.genericutilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class FileUtility {
	/*
	 This method wull return key property value by passing key as an argument
	 @param key
	 @return value
	 @throws thowable
	 */
	public String getPropertykeyvalue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\TestData\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	public static void main(String[] args) throws IOException {
		System.out.println(new FileUtility().getPropertykeyvalue("browser"));
		System.out.println(new FileUtility().getPropertykeyvalue("url"));
		System.out.println(new FileUtility().getPropertykeyvalue("username"));
		System.out.println(new FileUtility().getPropertykeyvalue("password"));
		
	}

}
