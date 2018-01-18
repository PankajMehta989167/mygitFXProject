package FuziXerox.FX;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.CatalogueJob;
import pagelibrary.LoginPage;
import pagelibrary.PrintJob;
import pagelibrary.PrintQuote;
import report.HtmlReport;
import testBase.TestBase;

public class CatalogueQuoteDeclineFunction extends TestBase {

	private PrintJob printJob;
	private LoginPage loginPage;
	private CatalogueJob catejob;
	private PrintQuote printquote;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("CatalogueQuoteDeclineFunction");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}

	@Test(dataProvider = "loginData")
	public void test1(String username, String password) throws Exception

	{
		init();
		loginPage = new LoginPage(driver);
		printJob = new PrintJob(driver);
		catejob = new CatalogueJob(driver);
		printquote = new PrintQuote(driver);
		
		loginPage.signIn(username, password);
		catejob.catalogueJobCreation();
		printJob.deliveryDetailSection();
		catejob.submitCatalogueJobSection();
		catejob.ctlgQuoteCancel();
		printquote.quoteDeclinePrintJob();
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
