package FuziXerox.FX;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.JobWithoutQuoteWithoutProof;
import pagelibrary.LoginPage;
import pagelibrary.PrintJob;
import report.HtmlReport;
import testBase.TestBase;


public class WithoutQuoteWithoutProof extends TestBase{
	
	private PrintJob printJob;
	private LoginPage loginPage;
	private JobWithoutQuoteWithoutProof withoutquotewithoutproof;
	
	
	/**
	 * @return
	 */
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("WithoutQuoteWithoutProof");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}
		
	/**
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Test(dataProvider="loginData")
	public void test1(String username, String password) throws Exception
	
	{
		init();
		loginPage = new LoginPage(driver);
		withoutquotewithoutproof = new JobWithoutQuoteWithoutProof(driver);
		printJob = new PrintJob (driver);
	
		
		loginPage.signIn(username, password);
		withoutquotewithoutproof.startNewJobSection();
		printJob.uploadFileSection();
		withoutquotewithoutproof.jobDetailSection();
		printJob.deliveryDetailSection();
		withoutquotewithoutproof.submitJobSection();
		withoutquotewithoutproof.jobNotQuoteNoProof(password, password);
		printJob.queryJob();
		//printJob.jobSurvey();
		
		
	}
	/**
	 * 
	 */
	@AfterTest
	public void tearDown(){
		GlobalVariables.setStrEndTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		HtmlReport htmlReport = new HtmlReport();
		htmlReport.generateReport();
		if(null != driver){
			driver.quit();
			Log.info("Browser closed");
	    	Log.info("================TEST PASSED====================");
		}
}
}
