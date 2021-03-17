package com.vtigercrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.WebDriverUtility;

public class CreateContactWithOrg {
	ExcelUtilty excel=new ExcelUtilty();
	
	
	public CreateContactWithOrg(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//click on contacts
	@FindBy(linkText="Contacts")
	private WebElement conclick;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcon;
	

	@FindBy(name="lastname")
	private WebElement conname;
	
	//select Organization	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectbtn;
	
	//search for organisation
	@FindBy(id="search_txt")
	private WebElement searchbtn;
	
	@FindBy(name="search")
	private WebElement searchme;
	
	@FindBy(linkText="Test Yantra")
	private WebElement selectorg;
	
	
	//save contact
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
    private WebElement savebtn;
	
	@FindBy(id="dtlview_Last Name")
    private WebElement actualnme;
	
	@FindBy(linkText="Test Yantra")
	private WebElement orgname;
	
	public WebElement getConclick() {
		return conclick;
	}

	public WebElement getCreatecon() {
		return createcon;
	}

	public WebElement getConname() {
		return conname;
	}

	public WebElement getSelectbtn() {
		return selectbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchnme() {
		return searchme;
	}

	public WebElement getSelectorg() {
		return selectorg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public String getActualnme() {
		return actualnme.getText();
	}

	public String getOrgname() {
		return orgname.getText();
	}

	 public void CreatContactInApp(String contactname, String orgname, WebDriver driver ,WebDriverUtility wd)
	 {
		 conclick.click();
		 createcon.click();
		 conname.sendKeys(contactname);
		 selectbtn.click();
		 wd.switchWindow(driver, "module=Accounts&action");
		 searchbtn.sendKeys(orgname);
		 searchme.click();
		 selectorg.click();
		 wd.switchWindow(driver, "module=Contacts&action");
		 savebtn.click();		
	 }
	 public void CreateContactInApp1(String contactname)
	 {
		 conclick.click();
		 createcon.click();
		 conname.sendKeys(contactname);
		 savebtn.click();
	 }

}
