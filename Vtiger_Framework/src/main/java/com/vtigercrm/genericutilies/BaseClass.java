package com.vtigercrm.genericutilies;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtigercrm.objectrepositoryutility.Home;
import com.vtigercrm.objectrepositoryutility.Login;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	public FileUtility fUtil = new FileUtility();
	public JavaUtility javaUtil = new JavaUtility();
	public ExcelUtilty excel = new ExcelUtilty();
	public WebDriverUtility wd = new WebDriverUtility();
	public DataBaseUtilities db=new DataBaseUtilities();
	
	public  WebDriver driver;
	public static WebDriver staticDriver;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("=====================DB & extend repost config=====================");
		db.connectToDB();
	}
	//@Parameters("brosweName")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("=============launch the browser================");
	       /*read common Data*/
		String brosweName = fUtil.getPropertykeyvalue("browser");
		String url = fUtil.getPropertykeyvalue("url");
			 /* launch the browser*/
		if (brosweName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (brosweName.equals("firefox")) {	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("provide valid browser");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("==============login==========");
		String username = fUtil.getPropertykeyvalue("username");
		String password = fUtil.getPropertykeyvalue("password");
		  
		 /*step 1 login to app*/
		Login lp = new Login(driver);
		lp.loginToAPP(username, password);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("==============logout==========");
		 /*step 5:  logout*/
		Home hp = new Home(driver);
		  hp.logout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=============close the browser================");
		 /*step 2 : close the browser*/ 
		  driver.close();

	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("=====================close DB & extend repost objects=====================");
		db.closeDb();
	}
}
