
package FuziXerox.FX;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.DCCAssignToSite;

import pagelibrary.DCCProof;

import report.HtmlReport;
import testBase.TestBase;


public class StartAssignToSite extends TestBase {
	private DCCAssignToSite DCCAssigntosite;
	private DCCProof dCCProof;
	
	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("StartAssignToSite");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}

	@Test(dataProvider = "loginData")
	public void test1(String username, String password) throws Exception

	{
		init();
		 DCCAssigntosite = new DCCAssignToSite(driver);
		 dCCProof = new DCCProof (driver);
		
		DCCAssigntosite.jobCreationdeClineProof();
		dCCProof.quoteApproval();
		dCCProof.proofCancel();
	
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