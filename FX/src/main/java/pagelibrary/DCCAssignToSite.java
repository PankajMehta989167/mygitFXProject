package pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class DCCAssignToSite extends TestBase {

	WebDriver driver;
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By action = By.xpath("//a[@data-activates='actionMenu']/h3");
	By hubcenter = By.xpath("//*[@name='hubSiteId']");
	By printjobrequest = By.xpath("//a[contains(.,'Print Job Request')]");
	By adminemail = By.xpath("//*[@id='username']");
	By searchclient = By.xpath("//a[contains(.,'Search')]");
	By startanewjob = By.cssSelector(
			"div[class='section secStyle']>div:nth-child(2)>ul>li:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)");
	By jobdetail = By.xpath("//*[@id='printJobDetailsForm']/div[1]/div/input");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By quoterequired = By.xpath("//input[@id='quoteRequiredId']/following-sibling::label");
	By jobdetailsection = By.xpath("//*[@id='jobDetails']");
	By quantity = By.xpath("//*[@id='quantity']");
	By proofcheckbox = By.xpath("//input[@id='proofReq']/following-sibling::label");
	By noofproof = By.xpath("//*[@id='numberofproofcopies']");
	By deliverydetails = By.xpath("//*[@id='deliveryDetails']");
	By deliveryoptionone = By.xpath("//input[@value='Deliver to me']/following-sibling::label");
	By submitbutton = By.xpath("//*[@id='submitJob']");
	By submitprintjob = By.xpath("//*[@class='btn bttn02 right align']");
	By hamburgermenu = By.xpath("//form[@name='jobsearchform']/a");
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
	By paper = By.xpath("//*[@id='units']");
	By addbuttonpaper = By.xpath("//*[@id='printCostForm']/div[3]/div[2]/div/div[1]/div[8]/a");
	By addbuttonimpression = By.xpath(".//*[@id='printCostForm']/div[1]/div[2]/div[9]/a");
	By approverdate = By.xpath("//*[@id='approvalDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By dateselect = By.xpath("//*[@id='approvalDate_Date_table']/tbody/tr[4]/td[5]/div");
	By sendforapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By successmessage = By.xpath("//div[@class='msg success']"); // IE
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By fullspecification = By.xpath("//a[contains(.,'Full specifications..')]");
	By approvebutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By declinebutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By cancelbutton = By.xpath("//*[@id='detailedSummary0']/div[1]/div[2]/a");
	By message = By.xpath("//*[@id='message']");
	By proofapprovaldate = By.xpath("//input[@id='approval_Date']");
	By proofapprovaldateselect = By.xpath("//*[@id='approval_Date_table']/tbody/tr[3]/td[5]/div");
	By sendforquoteapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By startbutton = By.xpath("//*[@id='continuebtn']");
	By finalapproval = By.xpath("//a[contains(.,'send for approval')]");
	By submitsurveyresponse = By.xpath("//*[@id='declinebutton']");
	By quickjobsearch = By.xpath("//*[@id='searchJobno']");
	By quicksearchhit = By.xpath("//form[@name='jobsearchform']/i");
	By jobcompletestatus = By.xpath("//*[@id='jobSummaryForm']/div/div[1]/div[1]");
	By querycategory = By.xpath("//*[@id='detailedSummary0rejectionType']");
	By querycomment = By.xpath("//*[@id='detailedSummary0rejectionComments']");
	By finalisejobbutton = By.xpath("//a[contains(.,'Finalise job')]");
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By assigntosite = By.xpath("//*[@name='btnSubmit']");
	By assigntohubcenter = By.linkText("ASSIGN TO HUB CENTRE");
	By button2 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By declinequote = By.xpath("//*[@id='detailedSummary0declinebtn']/a[1]");
	By canceljobbutton = By.xpath("//*[@class='btn bttn02']");
	By description = By.xpath("//*[@id='detailedSummary0Modal1terminationComments']");
	By hardcopy = By.xpath("//*[@id='mediaSource']");
	By supplymethod = By.xpath("//*[@id='supplyMethod']");
	By website = By.xpath("//*[@id='webref2']");
	By addlocation = By.xpath("//*[@id='addlocation']");
	/**
	 * @param driver
	 */
	public DCCAssignToSite(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @throws InterruptedException
	 */

	public void jobCreationdeClineProof() throws InterruptedException {
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(titlecompass);
		ActionExecutor.clickElement(action);
		ActionExecutor.clickElement(printjobrequest);
		ActionExecutor.enterValue(adminemail, "client@_selenium.test.com");
		ActionExecutor.clickElement(searchclient);
		Log.info("printjobname" + driver.findElement(startanewjob).getText());
		ActionExecutor.enterValue(jobdetail, Repository.getProperty("jobdetail"));
		ActionExecutor.enterValue(jobreference, Repository.getProperty("jobreference"));
		ActionExecutor.enterValue(projectcode, Repository.getProperty("projectcode"));
		Select dropdown = new Select(driver.findElement(hubcenter));
		dropdown.selectByVisibleText("DCC Melb UAT2");
		driver.switchTo().alert().accept();

		ActionExecutor.clickElement(duedate); // 1
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(duedateselect);
		ActionExecutor.clickElement(highpriority);
		ActionExecutor.clickElement(jobdetailsection);
		ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
		ActionExecutor.clickElement(proofcheckbox);
		ActionExecutor.enterValue(noofproof, Repository.getProperty("noofproof"));
		Select hardCopyDropDown = new Select(driver.findElement(hardcopy));
		hardCopyDropDown.selectByVisibleText("CD");
		Select supplymethoddropdown = new Select(driver.findElement(supplymethod));
		supplymethoddropdown.selectByVisibleText("Internal mail");
		ActionExecutor.enterValue(website, "test.com");
		ActionExecutor.clickElement(addlocation);
		ActionExecutor.clickElement(deliverydetails);
		ActionExecutor.clickElement(deliveryoptionone);
		ActionExecutor.clickElement(submitbutton);
		ActionExecutor.clickElement(submitprintjob);
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printer@_dccmelbdemo.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);

		if (driver.findElement(titlecompass).getText().contains("MELB DCC Print Manager")) {
			Log.info("DCC Print Manager logged in successfully!");

		} else {
			Log.info("Not a Print Manager!Fail!!");
		}
		ActionExecutor.clickElement(titlecompass);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);

	}
}