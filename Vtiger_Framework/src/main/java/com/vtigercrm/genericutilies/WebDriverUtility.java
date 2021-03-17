package com.vtigercrm.genericutilies;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class WebDriverUtility {
	
	/*
	 * !parm driver
	 */
	public void waitforElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void elementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void invisibilityofWebelement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void visibilityofWebelement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAlertToDisplay(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void selectDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(0);
	}
	public void selectDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectDropDown(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToFrame(WebDriver driver,String idorNAme)
	{
		driver.switchTo().frame(idorNAme);
	}
	public void switchWindow(WebDriver driver,String partialPageTitle)
	{
		Set<String> WindowIDs = driver.getWindowHandles();
		for(String window:WindowIDs)
		{
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(partialPageTitle))
			{
				break;
			}
		}
	}
//	public void switchToWindow(WebDriver driver)
//	{
//		String parent = driver.getWindowHandle();
//		Set<String> windowAddress = driver.getWindowHandles();
//		windowAddress.remove(parent);
//		for(String W:windowAddress)
//		{
//			driver.switchTo().window(W);
//		}
//		driver.switchTo().window(parent);
//	}
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement source, WebElement destination)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}
	public void dragAndDrop(WebElement source, WebElement target,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(source).release(target).build().perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		int y=element.getLocation().getY();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+")");
	}
	public String takeScreenShot(WebDriver driver,String methodname) throws IOException
	{
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String screenShotpath=System.getProperty("user.dir")+"/Screenshot/"+methodname+jUtil.getDateAndTime()+".png";
		File dest=new File(screenShotpath);		
		Files.copy(src, dest);
		return screenShotpath;
	}
	
	
	
	
	
}
