package pagelibrary;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class PrintQuote extends TestBase {

	WebDriver driver;
	Alert alert = null;
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By jobnumber = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");
	By fxUsername = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By signinbutton = By.xpath("//*[@id='loginbtn']");
	By searchboxicon = By.xpath("//*[@id='filterIcon']");
	By searchjobno = By.xpath("//*[@id='jobNo']");
	By filterbutton = By.xpath("//*[@id='continuebtn']");
	By clickonjobnoie = By.xpath("//*[@id='taskItem']/tbody/tr[1]/td[1]/a");
	By savestatus = By.xpath("//*[@id='taskItem']/tbody/tr/td[6]");
	By proceedtoquotebutton = By.xpath("//a[contains(.,'proceed to quote')]");
	By impression = By.xpath("//*[@id='impressions']");
	By addbuttonimpression = By.xpath("//*[@id='printCostForm']/div[1]/div[2]/div[9]/a");
	By approverdate = By.xpath("//*[@id='approvalDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By dateselect = By.xpath("//*[@id='approvalDate_Date_table']/tbody/tr[4]/td[5]/div");
	By sendforapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By fullspecification = By.xpath("//a[contains(.,'Full specifications..')]");
	By button2 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By cancelbutton = By.xpath("//*[@id='detailedSummary0']/div[1]/div[2]/a");
	By message = By.xpath("//*[@id='message']");
	By quickjobsearch = By.xpath("//*[@id='searchJobno']");
	By quicksearchhit = By.xpath("//form[@name='jobsearchform']/i");
	By jobcompletestatus = By.xpath("//*[@id='jobSummaryForm']/div/div[1]/div[1]");
	By querycategory = By.xpath("//*[@id='detailedSummary0rejectionType']");
	By querycomment = By.xpath("//*[@id='detailedSummary0rejectionComments']");
	By queryjob = By.xpath("//*[@id='detailedSummary0querybtn']/a[1]");
	By cancelcomment = By.xpath("//*[@id='detailedSummary0Modal1terminationComments']");
	By cancelproof = By.xpath("//*[@id='terminateJobForm']/div[5]/div/a[1]");
	By cancelcategory = By.xpath("//*[@id='detailedSummary0Modal1terminationType']");
	By cancelmessage = By.xpath("//*[@id='maincontent']/div/div[1]/div[1]");
	By declinequote = By.xpath("//*[@id='detailedSummary0declinebtn']/a[1]");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	/**
	 * @param driver
	 */
	public PrintQuote(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	public void sendForQuote(String username, String password) throws InterruptedException {

		// ---------------User Action - PrintJobNumber Created------------------
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);

		// ---------------User Action - Login With Print Manager------------------
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
		/*if (driver.findElement(titlecompass).getText().contains("Print Manager")) {
			Log.info("Print Manager logged in successfully!");
			WebElement elem = driver.findElement(imageLogo);
			Thread.sleep(1000);
			elem.click();
		//	ActionExecutor.clickElement(titlecompass);
		} else {
			Log.info("Not a Print Manager!Fail!!");
		}*/
		if (driver.findElement(titlecompass).getText().contains("Print Manager")){
			Log.info("Print Manager logged in successfully!");
			WebElement elem = driver.findElement(imageLogo);
			Thread.sleep(1000);
			if(Repository.getProperty("browser").equalsIgnoreCase("ie"))
			{
				elem.click();
			}
			else
			{
				ActionExecutor.clickElement(hamburgermenu);
		}
		}
		else {
			Log.info("Not a Print Manager!Fail!!");
		}
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Pending review"))
			Log.info("Job Review Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proceedtoquotebutton);
		driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//driver.findElement(impression).sendKeys("10");
	//	ActionExecutor.enterValue(impression, "10");
		//driver.findElement(impression).sendKeys("10");
		ActionExecutor.clickElement(addbuttonimpression);
		ActionExecutor.clickElement(approverdate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(dateselect);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Manager Side Message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		if (driver.findElement(delegationstatus).getText().contains("Quote Pending Approval"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}

	/**
	 * @throws InterruptedException
	 */
	public void quoteCancelPrintJob() throws InterruptedException

	{

		// ---------------------Quote Cancel------------------------------------------------------------
		ActionExecutor.clickElement(fullspecification);
		ActionExecutor.clickElement(cancelbutton);
		waitFor(1);
		alert = driver.switchTo().alert();
		alert.accept();
		waitFor(2);
		ActionExecutor.enterValue(cancelcomment, "Cancel Proof for Testin");
		ActionExecutor.clickElement(cancelproof);
		waitFor(2);
		alert = driver.switchTo().alert();
		alert.accept();
		Log.info("query job sucess message = " + driver.findElement(cancelmessage).getText());
		waitFor(2);

	}

	/**
	 * @throws InterruptedException
	 */
	public void quoteDeclinePrintJob() throws InterruptedException {

		// ---------------------Quote Decline------------------------------------------------------------
		ActionExecutor.clickElement(button2);
		ActionExecutor.selectValueFromOption(querycategory, "Manager decision");
		ActionExecutor.enterValue(querycomment, "for testing purpose");
		ActionExecutor.clickElement(declinequote);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);

		// -------------Quick Search the Job for Job Complete Status---------------------------

		ActionExecutor.enterValue(quickjobsearch, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(quicksearchhit);
		if (driver.findElement(jobcompletestatus).getText().contains("Job Completed")) {
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		} else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}
	}
}
