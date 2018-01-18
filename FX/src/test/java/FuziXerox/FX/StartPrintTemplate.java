package FuziXerox.FX;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.testng.annotations.AfterTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import globalvariable.GlobalVariables;
import pagelibrary.PrintJob;
import pagelibrary.PrintTemplate;
	import report.HtmlReport;
	import testBase.TestBase;

	public class StartPrintTemplate extends TestBase {
		
		private PrintTemplate PrintTemplate;
		private PrintJob printJob;
		
		@DataProvider(name = "loginData")
		public String[][] getTestData() {
			GlobalVariables.setStrStartTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
			GlobalVariables.setTestCaseName("StartPrintTemplate");

			String[][] testRecords = getData("exceldata.xlsx", "login");
			return testRecords;
		}

		@Test(dataProvider = "loginData")
		public void test1(String username, String password) throws Exception

		{
			init();
			PrintTemplate = new PrintTemplate (driver);
			printJob = new PrintJob(driver);
			
			//Print Template creation
			PrintTemplate.PrintTemplatecreation();
			
			
			//Print job having print template creation
			PrintTemplate.Printjobtemplatecreation();
			PrintTemplate.quoteApproval();
			printJob.queryJob();
			//printJob.jobSurvey();
			
		}

		@AfterTest
		public void tearDown() {
			GlobalVariables.setStrEndTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
			HtmlReport htmlReport = new HtmlReport();
			htmlReport.generateReport();
			if (null != driver)
				driver.quit();
		}
	}





