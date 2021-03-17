package com.Cast.Vtiger1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.FileUtility;
import com.vtigercrm.genericutilies.JavaUtility;

public class CreateOrganizationByExcelData {
	static WebDriver driver;
	
	@Test
	public void createorganizationWithcontact()throws IOException {
	
	FileUtility fUtil=new FileUtility();
	JavaUtility javaUtil=new JavaUtility();
	ExcelUtilty excel=new ExcelUtilty();
	String brosweName=fUtil.getPropertykeyvalue("browser");
	String url=fUtil.getPropertykeyvalue("url");
	String username=fUtil.getPropertykeyvalue("username");
	String password=fUtil.getPropertykeyvalue("password");
	String orgname=excel.readDatafromExcel("Sheet", 1, 2);
	String contactname=excel.readDatafromExcel("Sheet", 1, 3);
	
	//launch browser
	if(brosweName.equals("chrome"))
	{
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(brosweName.equals("firefox"))
	{
		//WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("provide valid browser");
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//navigate to Vtider
	driver.get(url);
	//login
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	//navigate to organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//create organization
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	String orgInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue(orgInfo.contains(orgname));
	//Assert
	//click on contact
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(contactname);
	
	//create contact by selecting organization
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	//capture the session id
	Set<String> windowsIDs = driver.getWindowHandles();
	Iterator<String> itr = windowsIDs.iterator();
	String pid = itr.next();
	String cid = itr.next();
	//switch to chid id
	driver.switchTo().window(cid);
	
	//search for organization
	driver.findElement(By.id("search_txt")).sendKeys(orgname);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText(orgname)).click();
	//switch back to parent window
	driver.switchTo().window(pid);
	
	//save contact
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	String actualname = driver.findElement(By.id("dtlview_Last Name")).getText();
	String actualOrgname = driver.findElement(By.linkText(orgname)).getText();
	Assert.assertTrue(orgname.equals(actualOrgname)&&contactname.equals(actualname), contactname+" :contact created by "+orgname+ " name  successfully. ");
	
	//logout app
	WebElement more = driver.findElement(By.xpath("//td[@class='small']//td[2]"));
	Actions act=new Actions(driver);
	act.moveToElement(more).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
	} 
}
