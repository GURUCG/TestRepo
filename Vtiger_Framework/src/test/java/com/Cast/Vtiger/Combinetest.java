package com.Cast.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.BaseClass;
import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.WebDriverUtility;
import com.vtigercrm.objectrepositoryutility.ContactInfoPage;
import com.vtigercrm.objectrepositoryutility.CreateContactWithOrg;
import com.vtigercrm.objectrepositoryutility.CreateOpportunity1;
import com.vtigercrm.objectrepositoryutility.opportunity_search;

@Listeners(com.vtigercrm.genericutilies.ListenerTest.class)
public class Combinetest extends BaseClass{
	@Test(groups = "smokeTest")
	public void createOpportunityWithContact1() throws Throwable {
	
		
		/*step 1 :read test script data */
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME");
		String opportunity = excel.getDataFromExcel("Sheet", "TC_03", "ORGANIZATION NAME");
		 
		 
		/*step 2 :Navigating to Create contact and creating contact */
		 CreateContactWithOrg cc=new CreateContactWithOrg(driver);
		 cc.CreateContactInApp1(contactname);
		 
		 /*verify the contact in contact info Page*/
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String actContactNAme = cip.getSuccessMsg().getText();
		  boolean flag = actContactNAme.contains(contactname);		  
		  Assert.assertTrue(flag);
		 
		  /*step 3 :Navigating to opportunity and creating opportunity */
		  CreateOpportunity1 adv = new CreateOpportunity1(driver);
		adv.CreateOppo(opportunity);

		// DropDown
		WebElement drop1 = adv.getDrop1();
		wd.selectDropDown(drop1, "Contacts");

		// SelectContact
		adv.Createoppo1(driver, contactname, wd);

		// SelectDate
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int count = 0;
		while (count < 2) {			
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectmonth())).click();
			count++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// SaveOpportunity
		adv.CreateOppo2();
		
		/*verify the opportunity in opportunity info Page*/
		String text = adv.getHeadertxt();
		Assert.assertTrue(text.contains(opportunity));

		/*step 4 :Navigating to advanceSearch link */
		opportunity_search co = new opportunity_search(driver);
		co.Advsearch();

		/*step 5 :SearchWithDropdown "Opportunity Name" Dropdown"Equals" */
		WebElement drop2 = adv.getDrop2();
		wd.selectDropDown("Opportunity Name", drop2);
		WebElement drop3 = adv.getDrop3();
		wd.selectDropDown(drop3, "c");
		
		
		/*verify the opportunity in Advance search Page*/
		 String text1 = co.Advsearch1(opportunity);
		 Assert.assertTrue(text1.equals(opportunity));
		 System.out.println(text1 +"="+ " the opportunity name is eqauls "+ opportunity);		
		
       
}
	
	@Test(groups = "smokeTest")
	public void createOpportunityWithContact2() throws IOException, Throwable {

		ExcelUtilty excel = new ExcelUtilty();
		WebDriverUtility wd = new WebDriverUtility();
		
		/*step 1 :read test script data */
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME");
		String opportunity = excel.getDataFromExcel("Sheet", "TC_03", "ORGANIZATION NAME");
		 
		 
		/*step 2 :Navigating to Create contact and creating contact */
		 CreateContactWithOrg cc=new CreateContactWithOrg(driver);
		 cc.CreateContactInApp1(contactname);
		 
		 /*verify the contact in contact info Page*/
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String actContactNAme = cip.getSuccessMsg().getText();
		  boolean flag = actContactNAme.contains(contactname);		  
		  Assert.assertTrue(flag);
		 
		  /*step 3 :Navigating to opportunity and creating opportunity */
		  CreateOpportunity1 adv = new CreateOpportunity1(driver);
		adv.CreateOppo(opportunity);

		// DropDown
		WebElement drop1 = adv.getDrop1();
		wd.selectDropDown(drop1, "Contacts");

		// SelectContact
		adv.Createoppo1(driver, contactname, wd);

		// SelectDate
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int count = 0;
		while (count < 2) {			
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectmonth())).click();
			count++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// SaveOpportunity
		adv.CreateOppo2();
		
		/*verify the opportunity in opportunity info Page*/
		String text = adv.getHeadertxt();
		Assert.assertTrue(text.contains(opportunity));

		/*step 4 :Navigating to advanceSearch link */
		opportunity_search co = new opportunity_search(driver);
		co.Advsearch();

		/*step 5 :SearchWithDropdown "Opportunity Name" Dropdown"Equals" */
		WebElement drop2 = adv.getDrop2();
		wd.selectDropDown("Opportunity Name", drop2);
		WebElement drop3 = adv.getDrop3();
		wd.selectDropDown(drop3, "n");
		
		/*verify the opportunity in Advance search Page*/
		String text3 = co.Advsearch2(opportunity, wd);		
		System.out.println(text3 +"="+ " the opportunity name is not equal to "+ opportunity);		
		//Assert.assertNotEquals(text1, opportunity);
				
		

}
	
	@Test(groups = "regressionTest")
	public void createOpportunityWithContact3() throws IOException, Throwable {

		ExcelUtilty excel = new ExcelUtilty();
		WebDriverUtility wd = new WebDriverUtility();
		
		/*step 1 :read test script data */
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME");
		String opportunity = excel.getDataFromExcel("Sheet", "TC_03", "ORGANIZATION NAME");
		 
		 
		/*step 2 :Navigating to Create contact and creating contact */
		 CreateContactWithOrg cc=new CreateContactWithOrg(driver);
		 cc.CreateContactInApp1(contactname);
		 
		 /*verify the contact in contact info Page*/
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String actContactNAme = cip.getSuccessMsg().getText();
		  boolean flag = actContactNAme.contains(contactname);		  
		  Assert.assertTrue(flag);
		 
		  /*step 3 :Navigating to opportunity and creating opportunity */
		  CreateOpportunity1 adv = new CreateOpportunity1(driver);
		adv.CreateOppo(opportunity);

		// DropDown
		WebElement drop1 = adv.getDrop1();
		wd.selectDropDown(drop1, "Contacts");

		// SelectContact
		adv.Createoppo1(driver, contactname, wd);

		// SelectDate
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int count = 0;
		while (count < 2) {			
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectmonth())).click();
			count++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// SaveOpportunity
		adv.CreateOppo2();
		
		/*verify the opportunity in opportunity info Page*/
		String text = adv.getHeadertxt();
		Assert.assertTrue(text.contains(opportunity));

		/*step 4 :Navigating to advanceSearch link */
		opportunity_search co = new opportunity_search(driver);
		co.Advsearch();

		/*step 5 :SearchWithDropdown "Opportunity Name" Dropdown"Equals" */
		WebElement drop2 = adv.getDrop2();
		wd.selectDropDown("Opportunity Name", drop2);
		WebElement drop3 = adv.getDrop3();
		wd.selectDropDown(drop3, "s");
		
		
		/*verify the opportunity in Advance search Page*/
		String text1 = co.Advsearch1(opportunity);
		Assert.assertTrue(text1.startsWith(opportunity));
		System.out.println(text1 +"="+ " the opportunity name is starts with "+ opportunity);
				
		

}
	
	@Test(groups = "regressionTest")
	public void createOpportunityWithContact4() throws IOException, Throwable {

		ExcelUtilty excel = new ExcelUtilty();
		WebDriverUtility wd = new WebDriverUtility();
		
		/*step 1 :read test script data */
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME");
		String opportunity = excel.getDataFromExcel("Sheet", "TC_03", "ORGANIZATION NAME");
		 
		 
		/*step 2 :Navigating to Create contact and creating contact */
		 CreateContactWithOrg cc=new CreateContactWithOrg(driver);
		 cc.CreateContactInApp1(contactname);
		 
		 /*verify the contact in contact info Page*/
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String actContactNAme = cip.getSuccessMsg().getText();
		  boolean flag = actContactNAme.contains(contactname);		  
		  Assert.assertTrue(flag);
		 
		  /*step 3 :Navigating to opportunity and creating opportunity */
		  CreateOpportunity1 adv = new CreateOpportunity1(driver);
		adv.CreateOppo(opportunity);

		// DropDown
		WebElement drop1 = adv.getDrop1();
		wd.selectDropDown(drop1, "Contacts");

		// SelectContact
		adv.Createoppo1(driver, contactname, wd);

		// SelectDate
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int count = 0;
		while (count < 2) {			
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectmonth())).click();
			count++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// SaveOpportunity
		adv.CreateOppo2();
		
		/*verify the opportunity in opportunity info Page*/
		String text = adv.getHeadertxt();
		Assert.assertTrue(text.contains(opportunity));

		/*step 4 :Navigating to advanceSearch link */
		opportunity_search co = new opportunity_search(driver);
		co.Advsearch();

		/*step 5 :SearchWithDropdown "Opportunity Name" Dropdown"Equals" */
		WebElement drop2 = adv.getDrop2();
		wd.selectDropDown("Opportunity Name", drop2);
		WebElement drop3 = adv.getDrop3();
		wd.selectDropDown(drop3, "ew");
		
		
		/*verify the opportunity in Advance search Page*/
		String text1 = co.Advsearch1(opportunity);
		Assert.assertTrue(text1.endsWith(opportunity));	
		System.out.println(text1 +"="+ " the opportunity name is ends with "+ opportunity);

}
	
	@Test(groups = "regressionTest")
	public void createOpportunityWithContact5() throws IOException, Throwable {
        
		ExcelUtilty excel = new ExcelUtilty();
		WebDriverUtility wd = new WebDriverUtility();
		
		/*step 1 :read test script data */
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME");
		String opportunity = excel.getDataFromExcel("Sheet", "TC_03", "ORGANIZATION NAME");
		 
		 
		/*step 2 :Navigating to Create contact and creating contact */
		 CreateContactWithOrg cc=new CreateContactWithOrg(driver);
		 cc.CreateContactInApp1(contactname);
		 
		 /*verify the contact in contact info Page*/
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String actContactNAme = cip.getSuccessMsg().getText();
		  boolean flag = actContactNAme.contains(contactname);		  
		  Assert.assertTrue(flag);
		 
		  /*step 3 :Navigating to opportunity and creating opportunity */
		  CreateOpportunity1 adv = new CreateOpportunity1(driver);
		adv.CreateOppo(opportunity);

		// DropDown
		WebElement drop1 = adv.getDrop1();
		wd.selectDropDown(drop1, "Contacts");

		// SelectContact
		adv.Createoppo1(driver, contactname, wd);

		// SelectDate
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int count = 0;
		while (count < 2) {			
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
			wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectmonth())).click();
			count++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(adv.getSelectyear())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// SaveOpportunity
		adv.CreateOppo2();
		
		/*verify the opportunity in opportunity info Page*/
		String text = adv.getHeadertxt();
		Assert.assertTrue(text.contains(opportunity));

		/*step 4 :Navigating to advanceSearch link */
		opportunity_search co = new opportunity_search(driver);
		co.Advsearch();

		/*step 5 :SearchWithDropdown "Opportunity Name" Dropdown"Equals" */
		WebElement drop2 = adv.getDrop2();
		wd.selectDropDown("Opportunity Name", drop2);
		WebElement drop3 = adv.getDrop3();
		wd.selectDropDown(drop3, "c");

				
		/*verify the opportunity in Advance search Page*/
		String text1 = co.Advsearch1(opportunity);
		Assert.assertTrue(text1.contains(opportunity));	
		System.out.println(text1 +"="+ " the opportunity name is conatains "+ opportunity);
		
	}
	
}
