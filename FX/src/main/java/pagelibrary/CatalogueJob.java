package pagelibrary;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class CatalogueJob extends TestBase {

	WebDriver driver;
	//public String addvaluecategorydata = "test data";
	String randomFirstName = ActionExecutor.randomFirstName();
	
	By fxUserName = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By submitbutton = By.xpath("//*[@id='loginbtn']");
	By startanewjob = By.xpath("//*[@id='startJob']/div/div[1]");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By due_time_xpath = By.xpath("//input[@id='dueDate_Time']");
	By due_time_options_xpath = By.xpath("//li[@class='ui-menu-item']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By others_xpath = By.xpath("//div[@id='jobOption1']/div[3]/a/i");
	By catalogue_xpath = By.xpath("//div[@id='jobOption0']/div[2]/a/i");
	By jobdetail = By.xpath("//input[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By catalogue_quote_required_xpath = By.xpath("//label[@for='quoteRequired']");
	By category_selection_options_xpath = By
			.xpath("//ul[@id='select-options-6788b685-03d9-baf8-ef1c-fae2f0321834']/li/span");
	By item_selection_options_xpath = By
			.xpath("//ul[@id='select-options-64246de7-e077-30ca-ed7c-f6b215a5dc3d']/li/span");
	By deliver_to_me_xpath = By.xpath("//form[@id='printDeliveryDetailsForm']/div/div[1]/div/label");
	By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
	By signinbutton = By.xpath("//*[@id='loginbtn']");
    By categorydropdown = By.xpath("//*[@id='catalogueJobDetailsForm']/div[10]/div/div/input");
	By categoryhelomoto = By.xpath("//*[@id='catalogueJobDetailsForm']/div[10]/div/div/ul");
	By itemdropdown = By.xpath("//*[@id='catalogueJobDetailsForm']/div[11]/div[1]/div/input");
	By itemdropdownitem = By.xpath("//*[@id='catalogueJobDetailsForm']/div[11]/div[1]/div/ul");
	By quoterequired = By.xpath("//input[@id='quoteRequired']/following-sibling::label");
//	By categoryquantity = By.xpath("//*[@name='quantity']");
	By quantity = By.xpath("//*[@name='quantity']");
	By estimate = By.xpath("//*[@id='total']");
	By submitcataloguejob = By.xpath("//a[contains(.,'Submit Catalogue job')]");
	By jobnumber = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By titlecompass = By.xpath("//ul[@id='userMenu']/li[1]/a");
	By searchboxicon = By.xpath("//*[@id='filterIcon']/i");
	By searchjobno = By.xpath("//*[@id='jobNo']");
	By filterbutton = By.xpath("//*[@id='continuebtn']");
	By clickonjobnoie = By.xpath("//*[@id='taskItem']/tbody/tr[1]/td[1]/a");
	By savestatus = By.xpath("//*[@id='taskItem']/tbody/tr/td[6]");
	By proceedtoquotebutton = By.xpath("//*[@id='printJobSummaryForm']/div[25]/div/div/a");
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
	By startbutton = By.xpath("//*[@id='continuebtn']");
	//By finalapproval = By.xpath("//a[contains(.,'send for approval')]");
	By submit = By.xpath("//*[@id='submitJob']");
	By fujilogo=By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By fxUsername = By.xpath("//*[@id='j_username']");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	
	/**
	 * @param driver
	 */
	public CatalogueJob(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @throws Exception 
	 */
	public void catalogueJobCreation() throws Exception {
	
		ActionExecutor.clickElement(startanewjob);
		ActionExecutor.clickElement(others_xpath);
		driver.findElement(catalogue_xpath).click();
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
		/**
		 * @options.get(2): This value will select the respective time value from dropdown!! 
		 */
		options.get(2).click();
		ActionExecutor.setReportVariables("Click", "Passed", "Value has been clicked" + options.get(2));
		ActionExecutor.clickElement(highpriority);
		ActionExecutor.clickElement(quoterequired);
		ActionExecutor.clickElement(categorydropdown);
		waitFor(2);
		ActionExecutor.selectFromSpanDropDown(categoryhelomoto, "helo moto1");
		waitFor(2);
		ActionExecutor.clickElement(itemdropdown);
		waitFor(2);
		ActionExecutor.selectFromSpanDropDown(itemdropdownitem, "new category 12");
		waitFor(2);
		//driver.findElement(categoryquantity).sendKeys("10");
		ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
		//ActionExecutor.enterValue(categoryquantity, "10");
		waitFor(1);
		String est = driver.findElement(estimate).getText();
		System.out.print(est);
	//	ActionExecutor.storeValue(estimate, "#estimate");
		//waitFor(2);
	}

	/**
	 * @throws InterruptedException
	 */
	public void submitCatalogueJobSection() throws InterruptedException {
		ActionExecutor.clickElement(submit);
		ActionExecutor.clickElement(submitcataloguejob);
	}

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void sendForQuote() throws IOException, InterruptedException {
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		// ---------------User Action - Login With Print Manager------------------
		ActionExecutor.enterValue(fxUserName, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
		//String PrintTitle = driver.findElement(titlecompass).getText();
	//	System.out.println("title is" +PrintTitle);
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
		//driver.findElement(fujilogo).click();
		//waitFor(2);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		String Pendingstatus = driver.findElement(savestatus).getText();
		if (Pendingstatus.contains("Pending review "))
			Log.info("Job Review Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		waitFor(2);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proceedtoquotebutton);
		//webElement.sendKeys(Keys.TAB);
		WebElement webElement = driver.findElement(impression);//You can use xpath, ID or name whatever you like
		webElement.sendKeys(Keys.TAB);
		//webElement.sendKeys(Keys.ENTER);
	//	driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//driver.findElement(impression).sendKeys("10");
	//	ActionExecutor.enterValue(impression, "10");
		ActionExecutor.clickElement(addbuttonimpression);
		ActionExecutor.clickElement(approverdate);
		ActionExecutor.clickElement(nextmonth);
		ActionExecutor.clickElement(dateselect);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Print Manager Side Message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUserName, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		String jobStatusQuote = driver.findElement(delegationstatus).getText();
		Log.info("client side job message =" + jobStatusQuote);
		if (jobStatusQuote.contains("Quote Pending Approval"))
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
		ActionExecutor.enterValue(fxUserName, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
		String printTitle = driver.findElement(titlecompass).getText();
		if (printTitle.contains("Print Manager")) {
			Log.info("Print Manager logged in successfully!");
			ActionExecutor.clickElement(titlecompass);
		} else {
			Log.info("Not a Print Manager!Fail!!");
		}
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		if (driver.findElement(savestatus).getText().contains("Production in Progress"))
			Log.info("Production in Progress Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		waitFor(2);
		ActionExecutor.clickElement(clickonjobnoie);
		waitFor(2);
		ActionExecutor.clickElement(startbutton);
		waitFor(2);
		ActionExecutor.clickElement(startbutton);
		waitFor(2);
		ActionExecutor.clickElement(startbutton);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("proof saved message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUserName, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		if (driver.findElement(delegationstatus).getText().contains("Pending Approval"))
			Log.info("Pending Approval Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}
	
	public void ctlgQuoteCancel() throws IOException, InterruptedException {
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		// ---------------User Action - Login With Print Manager------------------
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
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
		driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//driver.findElement(impression).sendKeys("10");
	//	ActionExecutor.enterValue(impression, "10");
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
		String jobStatusQuote = driver.findElement(delegationstatus).getText();
		Log.info("client side job message =" + jobStatusQuote);
		if (jobStatusQuote.contains("Quote Pending Approval"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);

	}
}
}
