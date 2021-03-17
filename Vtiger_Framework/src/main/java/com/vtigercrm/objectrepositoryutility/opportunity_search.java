package com.vtigercrm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilies.WebDriverUtility;

public class opportunity_search {
	WebDriver driver;
	public opportunity_search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
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
		
		@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
		private WebElement btnclick;
		
	    @FindBy(xpath = "//a[.='abc']")
		private WebElement filter;	
	    
	    @FindBy(xpath="//img[@src='themes/softed/images/status.gif']")
	    private WebElement loadingbar;
  		
		public WebElement getLoadingbar() {
			return loadingbar;
		}

		public String getFilter() {
			return filter.getText();
		}

		public WebElement getAdvsearchlink() {
			return advsearchlink;
		}

		public WebElement getBtnclick() {
			return btnclick;
		}

		public WebElement getDrop2() {
			return drop2;
		}

		public WebElement getDrop3() {
			return drop3;
		}

		public WebElement getEnteroppo() {
			return enteroppo;
		}

		public WebElement getSearchbtn() {
			return searchbtn;
		}
		
		public void Advsearch()
		{
			btnclick.click();
			advsearchlink.click();
		}
		
		public String Advsearch1(String opportunity)
		{
			enteroppo.sendKeys(opportunity);
			searchbtn.click();
			WebElement filter1 = driver.findElement(By.linkText(opportunity));
			return filter1.getText();
		}
		public String Advsearch2(String opportunity, WebDriverUtility wd)
		{
			enteroppo.sendKeys(opportunity);
			searchbtn.click();
			wd.invisibilityofWebelement(driver, loadingbar);
			String text2 = driver.findElement(By.xpath("//a[@title='Opportunities']")).getText();
			return text2;
		}
}
