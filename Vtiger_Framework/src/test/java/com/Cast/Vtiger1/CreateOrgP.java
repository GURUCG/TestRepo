package com.Cast.Vtiger1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.BaseClass;
import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.JavaUtility;
import com.vtigercrm.objectrepositoryutility.CreateNewOrganization;

public class CreateOrgP extends BaseClass {
	@Test(groups = "regressionTest")
	public void createorg() throws Exception
	{ 
		/*step 1 :read test script data */
		JavaUtility javaUtil=new JavaUtility();
		ExcelUtilty excel=new ExcelUtilty();
		String orgname=excel.getDataFromExcel("Sheet", "TC_01", "ORGANIZATION NAME")+javaUtil.generateRandomNum();
				
		
		/*step 2 :Create Organization */
		CreateNewOrganization co=new CreateNewOrganization(driver);
		co.CreateOrg(orgname);
		
		/*verifying the Organization */
	    String text = co.getHeadertxt();
		Assert.assertTrue(text.contains(orgname));

		
	}
}
