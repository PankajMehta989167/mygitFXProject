package FuziXerox.FX;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.JobWithoutQuote;
import pagelibrary.JobWithoutQuoteWithoutProof;
import pagelibrary.LoginPage;
import pagelibrary.PrintJob;
import report.HtmlReport;
import testBase.TestBase;

public class PrintJobWithoutQuoteFunction extends TestBase {

	private PrintJob printJob;
	private LoginPage loginPage;
	private JobWithoutQuoteWithoutProof withoutQuoteWithoutProof;
	private JobWithoutQuote jobwithoutquote;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("PrintJobWithoutQuoteFunction");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}

	@Test(dataProvider = "loginData")
	public void test1(String username, String password) throws Exception

	{
		init();
		loginPage = new LoginPage(driver);
		withoutQuoteWithoutProof = new JobWithoutQuoteWithoutProof(driver);
		printJob = new PrintJob(driver);
		jobwithoutquote = new JobWithoutQuote(driver);
		
		loginPage.signIn(username, password);
		withoutQuoteWithoutProof.startNewJobSection();
		printJob.uploadFileSection();
		jobwithoutquote.jobDetailSection();
		printJob.deliveryDetailSection();
		withoutQuoteWithoutProof.submitJobSection();
		jobwithoutquote.jobWithNoQuote(username, password);
		// PrintJob.QueryJob();
		printJob.jobSurvey();
		loginPage.signout();
	}

	@AfterTest
	public void tearDown() {
		GlobalVariables.setStrEndTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		HtmlReport htmlReport = new HtmlReport();
		htmlReport.generateReport();
		if (null != driver) {
			driver.quit();
			Log.info("Browser closed");
			Log.info("================TEST PASSED====================");
		}
	}
}
