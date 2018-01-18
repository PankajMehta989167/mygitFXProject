package pagelibrary;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class PrintProof extends TestBase {

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
	By addbuttonimpression = By.xpath(".//*[@id='printCostForm']/div[1]/div[2]/div[9]/a");
	By approverdate = By.xpath("//*[@id='approvalDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By dateselect = By.xpath("//*[@id='approvalDate_Date_table']/tbody/tr[4]/td[5]/div");
	By sendforapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By fullspecification = By.xpath("//a[contains(.,'Full specifications..')]");
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By cancelbutton = By.xpath("//*[@id='detailedSummary0']/div[1]/div[2]/a");
	By message = By.xpath("//*[@id='message']");
	By proofapprovaldate = By.xpath("//*[@id='approval_Date']");
	By proofapprovaldateselect = By.xpath("//*[@id='approval_Date_table']/tbody/tr[3]/td[5]/div");
	//By sendforquoteapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By quickjobsearch = By.xpath("//*[@id='searchJobno']");
	By quicksearchhit = By.xpath("//form[@name='jobsearchform']/i");
	By jobcompletestatus = By.xpath("//*[@id='jobSummaryForm']/div/div[1]/div[1]");
	By finalisejobbutton = By.xpath("//a[contains(.,'Finalise job')]");	
	By cancelcomment = By.xpath("//*[@id='detailedSummary0Modal1terminationComments']");
	By cancelproof = By.xpath("//*[@id='terminateJobForm']/div[5]/div/a[1]");
	By cancelcategory = By.xpath("//*[@id='detailedSummary0Modal1terminationType']");
	By cancelmessage = By.xpath("//*[@id='maincontent']/div/div[1]/div[1]");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By startbutton = By.xpath("//*[@id='continuebtn']");
	By button2 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By querycategory = By.xpath("//*[@id='detailedSummary0rejectionType']");
	By querycomment = By.xpath("//*[@id='detailedSummary0rejectionComments']");
	By declinequote = By.xpath("//*[@id='detailedSummary0declinebtn']/a[1]");
	
	/**
	 * @param driver
	 */
	public PrintProof(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);

	}

	/**
	 * @throws InterruptedException
	 */
	
	public void sendForProof(String username, String password) throws InterruptedException {

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
	//	ActionExecutor.enterValue(impression, "10");
		driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//driver.findElement(impression).sendKeys("10");
		ActionExecutor.clickElement(addbuttonimpression);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(approverdate));
		ActionExecutor.clickElement(approverdate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(dateselect);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(sendforapprovalbutton));
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
		ActionExecutor.clickElement(button1);
		waitFor(1);
		Log.info("Quote Approval Sucess Message =" + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
	/*	if (driver.findElement(titlecompass).getText().contains("Print Manager")) {
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
		waitFor(2);
		// ------------------------------Proof creation process-------------------------------------
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Proof in Progress"))
			Log.info("Proof In Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		waitFor(2);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proofapprovaldate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(proofapprovaldateselect);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Proof sent message = =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		if (driver.findElement(delegationstatus).getText().contains("Proof Pending Approval"))
			Log.info("Proof Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
		// ------------------------------------Proof decline-----------------------------
		ActionExecutor.clickElement(button2);
		new Select(driver.findElement(querycategory)).selectByVisibleText("Manager decision");
		driver.findElement(querycomment).sendKeys("for testing purpose");
		ActionExecutor.clickElement(declinequote);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		waitFor(1);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		// ------------------------------------Job goes back to PROOF CREATION PROCESS----------------
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Proof in Progress"))
			Log.info("Proof In Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Proof sent message = =" + driver.findElement(successmessage).getText());

		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		if (driver.findElement(delegationstatus).getText().contains("Proof Pending Approval"))
			Log.info("Proof Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		// ---------------------------------------------Proof Approval Process-------------------
		ActionExecutor.clickElement(delegationstatus);
		ActionExecutor.clickElement(button1);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		if (driver.findElement(savestatus).getText().contains("Production in Progress"))
			Log.info("Production in Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		driver.findElement(clickonjobnoie).click();
		waitFor(1);
		// -----------------------------------------Production in progress-----------------------------
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("proof saved message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		Log.info("print manager is logged out successfully");
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		if (driver.findElement(delegationstatus).getText().contains("Pending Approval"))
			Log.info("Pending Approval Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}
	
	
	public void proofCancel() throws InterruptedException {

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
		//ActionExecutor.enterValue(impression, "10");
		ActionExecutor.clickElement(addbuttonimpression);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(approverdate));
		ActionExecutor.clickElement(approverdate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(dateselect);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(sendforapprovalbutton));
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Manager Side Message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		Log.info("client side job message =" + driver.findElement(delegationstatus).getText());
		if (driver.findElement(delegationstatus).getText().contains("Quote Pending Approval"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
		ActionExecutor.clickElement(button1);
		waitFor(1);
		Log.info("Quote Approval Sucess Message =" + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
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

		// -----------------------------Proof has been sent for approved-------------------------------------

		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		if (driver.findElement(savestatus).getText().contains("Proof in Progress"))
			Log.info("Proof In Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proofapprovaldate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(proofapprovaldateselect);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Proof sent message = =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		if (driver.findElement(delegationstatus).getText().contains("Proof Pending Approval"))
			Log.info("Proof Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);

		// ------------------------------------Proof Cancel-----------------------------
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
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		if (driver.findElement(savestatus).getText().contains("Cancel Pending Approval"))
			Log.info("Proof is cancelled status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(finalisejobbutton);
		Log.info("finalise message is = " + driver.findElement(successmessage).getText());

		// -------------Quick Search the Job for Job Complete Status---------------------------
		ActionExecutor.enterValue(quickjobsearch, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(quicksearchhit);

		if (driver.findElement(jobcompletestatus).getText().contains("Job Cancelled"))
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}
	}
}
