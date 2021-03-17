package com.Cast.Vtiger;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.BaseClass;
import com.vtigercrm.objectrepositoryutility.ContactInfoPage;
import com.vtigercrm.objectrepositoryutility.CreateContactWithOrg;
import com.vtigercrm.objectrepositoryutility.CreateOpportunity1;
import com.vtigercrm.objectrepositoryutility.opportunity_search;

@Listeners(com.vtigercrm.genericutilies.ListenerTest.class)
public class AdvanceSearchAndSearchWithDropdownOpportunityNameDropdownNotEqualstest extends BaseClass {
	

	@Test(groups = "regressionTest")
	public void createOpportunityWithContact2() throws IOException, Throwable {

				
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
				
		

}
}
