package com.vtigercrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	 
	
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement btnclick;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorg;
	
	@FindBy(name="accountname")
	private WebElement acntname;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertxt;
	
	
	public WebElement getBtnclick() {
		return btnclick;
	}
	

	public WebElement getCreateorg() {
		return createorg;
	}
	

	public WebElement getAcntname() {
		 
		return acntname;
	}
	

	public WebElement getSavebtn() {
		 
		return savebtn;
	}
	

	public String getHeadertxt() {
		 return headertxt.getText();
	}

	
	public void CreateOrg(String orgname) {
		btnclick.click();
		createorg.click();
		acntname.sendKeys(orgname);
		savebtn.click();
		//headertxt.getText();
	}


	


}
	


