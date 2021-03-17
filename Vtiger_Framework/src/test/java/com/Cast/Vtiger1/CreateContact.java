package com.Cast.Vtiger1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.FileUtility;
import com.vtigercrm.genericutilies.JavaUtility;
import com.vtigercrm.genericutilies.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
static WebDriver driver;
	
	@Test
	public void createorganizationWithcontact()throws IOException {
	
	FileUtility fUtil=new FileUtility();
	JavaUtility javaUtil=new JavaUtility();
	ExcelUtilty excel=new ExcelUtilty();
	WebDriverUtility wd=new WebDriverUtility();
	String brosweName=fUtil.getPropertykeyvalue("browser");
	String url=fUtil.getPropertykeyvalue("url");
	String username=fUtil.getPropertykeyvalue("username");
	String password=fUtil.getPropertykeyvalue("password");	
	
   //String orgname=excel.getDataFromExcel("Sheet", "TC_01", "ORGANIZATION NAME");
   String contactname=excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME")+javaUtil.generateRandomNum();
	
	//launch browser
	if(brosweName.equals("chrome"))
	{
      WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(brosweName.equals("firefox"))
	{
      WebDriverManager.firefoxdriver().setup();
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
	
	//click on contact
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(contactname);
						
//			//save contact
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//			String actualConname = driver.findElement(By.id("dtlview_Last Name")).getText();
//			String actualOrgname = driver.findElement(By.linkText(orgname)).getText();
//			Assert.assertTrue(orgname.equals(actualOrgname)&&contactname.equals(actualConname), contactname+" :contact created by "+orgname+ " name  successfully. ");
			
			//logout app
			WebElement more = driver.findElement(By.xpath("//td[@class='small']//td[2]"));
			//Actions act=new Actions(driver);
			//act.moveToElement(more).perform();
			wd.mouseHover(driver, more);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.quit();
	}
}
