
package FuziXerox.FX;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.LoginPage;
import pagelibrary.PrintJob;
import report.HtmlReport;
import testBase.TestBase;


public class ClientPrintJob extends TestBase
{
	
	private PrintJob printJob;
	private LoginPage loginPage;

	
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("ClientPrintJob");
	//	GlobalVariables.setBrowserName(browser);
		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}
	
	@Test(dataProvider="loginData")
	public void test1(String username, String password) throws Exception
	
	{
		init();
		loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		printJob = new PrintJob (driver);
		
		printJob.startNewJobSection();
		printJob.uploadFileSection();
		printJob.jobDetailSection();
		printJob.deliveryDetailSection();
		printJob.submitJobSection();
		printJob.printJobNew(username, password);
		printJob.queryJob();
		//printJob.jobSurvey();
		loginPage.signout();
	
		
	}
	
	@AfterTest
	public void tearDown() 
	{
		GlobalVariables.setStrEndTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		HtmlReport htmlReport = new HtmlReport();
		htmlReport.generateReport();
		if (null != driver) 
		{
			driver.quit();
			Log.info("Browser closed");
			Log.info("================TEST PASSED====================");
		}

	}

	   
}
