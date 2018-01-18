package FuziXerox.FX;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.LoginPage;
import pagelibrary.outSource;
import report.HtmlReport;
import testBase.TestBase;


public class outSourceQuoteCancel extends TestBase{

	private LoginPage loginPage;
	private outSource outsource;
	

	
	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("outSourceQuoteCancel");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}
		
	@Test(dataProvider="loginData")
	public void test1(String username, String password) throws Exception
	
	{
		init();
		loginPage = new LoginPage(driver);
		outsource = new outSource(driver);
		

	//	loginPage.signIn(username, password);
	//	outsource.outsourceJobCreation();
		outsource.sendForQuoteP3();
		outsource.outsourceQuoteCancel();
		
		
	
		
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
