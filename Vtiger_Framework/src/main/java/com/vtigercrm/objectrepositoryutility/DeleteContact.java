package com.vtigercrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilies.ExcelUtilty;

public class DeleteContact {
ExcelUtilty excel=new ExcelUtilty();
	
	
	public DeleteContact(WebDriver driver) {
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
	


	 public void CreatContactInApp()
	 {
		 conclick.click();
		
	 }
}
