package FuziXerox.FX;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalvariable.GlobalVariables;
import log.Log;
import pagelibrary.LoginPage;
import report.HtmlReport;
import testBase.TestBase;


public class Login extends TestBase{
	
	static Logger log = Logger.getLogger(LoginPage.class.getName());
	private LoginPage LoginPage;
	
	
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		GlobalVariables.setTestCaseName("Login");

		String[][] testRecords = getData("exceldata.xlsx", "login");
		return testRecords;
	}
	
	@Test(dataProvider="loginData")
	public void test1(String username, String password) throws Exception
	
	{
		init();
		LoginPage = new LoginPage(driver);
		LoginPage.signIn(username, password);
		LoginPage.signout();
		 
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
