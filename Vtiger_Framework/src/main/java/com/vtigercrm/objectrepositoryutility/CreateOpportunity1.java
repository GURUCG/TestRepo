package com.vtigercrm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilies.WebDriverUtility;

public class CreateOpportunity1 {
	WebDriver driver;
	public CreateOpportunity1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement btnclick;

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createorg;

	@FindBy(name = "potentialname")
	private WebElement oppname;

	// DropDown
	@FindBy(xpath = "//select[@id='related_to_type']")
	private WebElement drop1;

	// select Contact
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectbtn;
	
	//search for Contact
	@FindBy(id="search_txt")
	private WebElement searchbtn1;
		
	@FindBy(name="search")
	private WebElement searchme;
		
	@FindBy(linkText="Test Yantra1")
	private WebElement selectCon;

	// AssignedTO
	@FindBy(xpath = "//input[@value='U']")
	private WebElement Asgntouser;

	// Expected end date
	@FindBy(xpath = "//img[@id='jscal_trigger_closingdate']")
	private WebElement closedate;

	@FindBy(xpath = "//td[@class='button nav' and .='«']")
	private WebElement selectyear;

	@FindBy(xpath = "(//td[@class='button nav' and .='‹'])[1]")
	private WebElement selectmonth;
	
	@FindBy(xpath="//td[.='9']")
	private WebElement date;

	// Save
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;

	//Advanced Search
	@FindBy(xpath = "//a[.='Go to Advanced Search']")
	private WebElement advsearchlink;
	
	@FindBy(xpath="//select[@id='fcol0']")
	private WebElement drop2;
	
	@FindBy(xpath="//select[@id='fop0']")
	private WebElement drop3;
	
	@FindBy(xpath="//input[@id='fval0']")
	private WebElement enteroppo;
	
	@FindBy(xpath="(//input[@value=' Search Now ' and @class='crmbutton small create'])[2]")
	private WebElement searchbtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertxt;
    
    public String getHeadertxt() {
		return headertxt.getText();
	}
	//Initialization
	public WebElement getDrop3()
	{
		return drop3;
	}
	public WebElement getBtnclick() {
		return btnclick;
	}
	public WebElement getCreateorg() {
		return createorg;
	}
	public WebElement getOppname() {
		return oppname;
	}
	public WebElement getDrop1() {
		return drop1;
	}
	public WebElement getSelectbtn() {
		return selectbtn;
	}
	public WebElement getSearchbtn1() {
		return searchbtn1;
	}
	public WebElement getSearchme() {
		return searchme;
	}
	public WebElement getSelectCon() {
		return selectCon;
	}
	public WebElement getAsgntouser() {
		return Asgntouser;
	}
	public WebElement getClosedate() {
		return closedate;
	}
	public WebElement getSelectyear() {
		return selectyear;
	}
	public WebElement getSelectmonth() {
		return selectmonth;
	}
	public WebElement getDate() {
		return date;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getAdvsearch() {
		return advsearchlink;
	}
	public WebElement getDrop2() {
		return drop2;
	}
	public WebElement getSearchbtn() {
		return enteroppo;
	}
	public void CreateOppo(String opportunity) {
		 btnclick.click();
		 createorg.click();
		 oppname.sendKeys(opportunity);
	}
	public void Createoppo1(WebDriver driver,String contactname,WebDriverUtility wd) throws Throwable{
		selectbtn.click();
		wd.switchWindow(driver, "module=Accounts&action");
		searchbtn1.sendKeys(contactname);
		searchme.click();
		driver.findElement(By.linkText(contactname)).click();
		 wd.switchWindow(driver, "module=Potentials&action");
		 Asgntouser.click();
		 closedate.click();
			int count = 0;
			while (count < 2) {			
			selectyear.click();
			selectmonth.click();
				count++;
			}
			selectyear.click();
			date.click();
			savebtn.click();
	}
	public void CreateOppo2()
	{
		//date.click();
		//savebtn.click();
		//btnclick.click();
		//advsearchlink.click();
	}
	public void CreateOppo3(String opportunity)
	{
		enteroppo.sendKeys(opportunity);
		searchbtn.click();
	}
	
	}
