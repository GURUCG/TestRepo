package com.Cast.Vtiger1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.BaseClass;
import com.vtigercrm.objectrepositoryutility.CreateContactWithOrg;
import com.vtigercrm.objectrepositoryutility.CreateNewOrganization;

public class CreateContactWithOrgp extends BaseClass {

	@Test
	public void CreateContactWithOrganization() throws IOException {

		/*step 1 :read test script data */
		String orgname = excel.getDataFromExcel("Sheet", "TC_01", "ORGANIZATION NAME")+ javaUtil.generateRandomNum();
		String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME")+ javaUtil.generateRandomNum();
			
		/*step 2 :Create Organization */
		CreateNewOrganization co=new CreateNewOrganization(driver);
		co.CreateOrg(orgname);
		
		/*step 3 :Create Contact with Organization */
		CreateContactWithOrg cc = new CreateContactWithOrg(driver);
		cc.CreatContactInApp(contactname, orgname, driver, wd);
        
		/*verifying the contactName and organizationName */
		String ActualConName = cc.getActualnme();
		String ActualOrgName = cc.getOrgname();
		Assert.assertTrue(orgname.equals(ActualOrgName) && contactname.equals(ActualConName));

		
	}
}
