package com.vtigercrm.genericutilies;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerTest implements ITestListener						
{		

	public ExtentReports report;
	public ExtentTest test;
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        	report.flush();	
	    }	 	    		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub
	    	ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReport.html");
	    	htmlReporter.config().setTheme(Theme.DARK);
	    	htmlReporter.config().setDocumentTitle("VTiger App");
	    	htmlReporter.config().setReportName("Full regression test");
	    	report = new ExtentReports();
	    	report.attachReporter(htmlReporter);
	    	report.setSystemInfo("Platform", "Windows");
	    	report.setSystemInfo("OS", "Windows 10 Pro");
	    	report.setSystemInfo("Environment", "Testing Environment");
	    	report.setSystemInfo("Reporter", "Nithesh");	        		
	    }		

	   		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        // TODO Auto-generated method stub		
	    	test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	    	test.log(Status.FAIL, result.getThrowable());
	    	WebDriverUtility wUtiles=new WebDriverUtility();
	    	try {
	    		String	path=wUtiles.takeScreenShot(BaseClass.staticDriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		
	    }		

	    		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	    	test.log(Status.FAIL, result.getThrowable());
	    	WebDriverUtility wUtiles=new WebDriverUtility();
	    	try {
			String	path=wUtiles.takeScreenShot(BaseClass.staticDriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        		
	    }		

	    		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
	        test.log(Status.SKIP,result.getThrowable());
	    }		

	    		
	    public void onTestStart(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        test=report.createTest(result.getMethod().getMethodName());		
	    }		

	    		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");		
	    }
}
