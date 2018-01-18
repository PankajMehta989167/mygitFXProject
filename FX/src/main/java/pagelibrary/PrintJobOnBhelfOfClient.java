package pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class PrintJobOnBhelfOfClient extends TestBase {

	WebDriver driver;
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By action = By.xpath("//a[@data-activates='actionMenu']/h3");
	By printjob = By.xpath(".//*[@id='actionMenu']/li[2]/a");
	By searchclient = By.xpath("//*[@id='userForm']/div[3]/div[2]/a");
	By jobdetail = By.xpath("//*[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By due_time_xpath = By.xpath("//input[@id='dueDate_Time']");
	By due_time_options_xpath = By.xpath("//li[@class='ui-menu-item']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By quoterequired = By.xpath("//input[@id='quoteRequiredId']/following-sibling::label");
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
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By message = By.xpath("//*[@id='message']");
	By proofapprovaldate = By.xpath("//*[@id='approval_Date']");
	By proofapprovaldateselect = By.xpath("//*[@id='approval_Date_table']/tbody/tr[3]/td[5]/div");
	//By sendforquoteapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By startbutton = By.xpath("//*[@id='continuebtn']");
	By finalapproval = By.xpath("//a[contains(.,'send for approval')]");
	By adminfirstname = By.xpath("//*[@id='firstname']");
	By addbuttonimpressioncategory = By.xpath("//*[@id='catalogueItemForm']/div/div/div[15]/div/div[1]/div[2]/div[5]/input");
	By fujilogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	/**
	 * @param driver
	 */
	public PrintJobOnBhelfOfClient(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @throws InterruptedException
	 */
	public void printManagerPrintJob() throws InterruptedException {

		// ---------------User Action - PrintJobNumber Created------------------
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
		ActionExecutor.clickElement(action);
		ActionExecutor.clickElement(printjob);
		ActionExecutor.enterValue(adminfirstname, "Client");
		ActionExecutor.clickElement(searchclient);
		ActionExecutor.enterValue(jobdetail, Repository.getProperty("jobdetail"));
		ActionExecutor.enterValue(jobreference, Repository.getProperty("jobreference"));
		ActionExecutor.enterValue(projectcode, Repository.getProperty("projectcode"));
		ActionExecutor.clickElement(duedate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(duedateselect);
		waitFor(1);
		WebElement dropdown = driver.findElement(due_time_xpath);
		waitFor(1);
		dropdown.click();
		List<WebElement> options = dropdown.findElements(due_time_options_xpath);
		waitFor(1);
		options.get(2).click();
		ActionExecutor.setReportVariables("Click", "Passed", "Value has been clicked" + options.get(2));
		ActionExecutor.clickElement(highpriority);
		ActionExecutor.clickElement(quoterequired);

	}

	/**
	 * @throws InterruptedException
	 */
	public void printJobSubmission() throws InterruptedException {
		// ---------------User Action - PrintJobNumber Created------------------
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(fujilogo);
		// ---------------User Action - Login With Print Manager------------------
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Pending review "))
			Log.info("Job Review Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		waitFor(2);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proceedtoquotebutton);
		WebElement webElement = driver.findElement(impression);//You can use xpath, ID or name whatever you like
		webElement.sendKeys(Keys.TAB); 
	//	driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
	//	driver.findElement(impression).sendKeys("10");
		//ActionExecutor.clickElement(impression);
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
		waitFor(2);
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
			//ActionExecutor.clickElement(titlecompass);
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
		if (driver.findElement(delegationstatus).getText().contains("Proof Pending Approval"))
			Log.info("Proof Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
		ActionExecutor.clickElement(button1);
		Log.info("proof approval sucess message =" + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Production in Progress"))
			Log.info("Production in Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(finalapproval);
		Log.info("proof saved message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		if (driver.findElement(delegationstatus).getText().contains("Pending Approval"))
			Log.info("Pending Approval Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}
}
