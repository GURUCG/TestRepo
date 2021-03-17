package com.Cast.Vtiger1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtigercrm.genericutilies.BaseClass;
import com.vtigercrm.genericutilies.ExcelUtilty;
import com.vtigercrm.genericutilies.FileUtility;
import com.vtigercrm.genericutilies.JavaUtility;
import com.vtigercrm.genericutilies.WebDriverUtility;

public class DeleteContactp extends BaseClass {
	static WebDriver driver;
@Test
public void delete() throws Throwable {


	
	//String orgname = excel.getDataFromExcel("Sheet", "TC_01", "ORGANIZATION NAME");
	//String contactname = excel.getDataFromExcel("Sheet", "TC_02", "ORGANIZATION NAME")+ javaUtil.generateRandomNum();


/*navigate to contacts*/

driver.findElement(By.xpath("//a[text()='Contacts' and @href='index.php?module=Contacts&action=index']")).click();

java.util.List<WebElement> check = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
 java.util.List<WebElement> lname = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));

// table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']
/*
* logic to check the specific row which is matching with expected and perfoem delete option
*
int rowcount=0;
for(int i=0;i<lname.size();i++){

String last = lname.get(i).getText();
if(last.equals(expected)){

break;

}

rowcount++;
check.get(i).click();

}

check.get(rowcount).click();
driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();*/

/*performing delete by clicking on del link */

driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[10]/a[text()='del']")).click();
Alert a = driver.switchTo().alert();
a.accept();


}
}
