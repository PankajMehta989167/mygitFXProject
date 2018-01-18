package pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class QuickJob extends TestBase {

	WebDriver driver;
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By action = By.xpath("//a[@data-activates='actionMenu']/h3");
	By adminemail = By.xpath("//*[@id='username']");
	By jobdetail = By.xpath("//*[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
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
	By impression = By.xpath("//*[@id='impressions']");
	By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By message = By.xpath("//*[@id='message']");
	By startbutton = By.xpath("//*[@id='continuebtn']");
	By finalapproval = By.xpath("//*[@id='maincontent']/div[14]/div[6]/div/a[3]");	
	// --------------quickprintjob------------------------------------------------
	By quickjob = By.xpath("//a[contains(.,'Quick print job request')]");
	By quickquoterequired = By.xpath("//input[@id='quoteRequired']/following-sibling::label");
	By quickpaperbutton = By.xpath("//*[@id='paperbtn']");
	By quickfinishbutton = By.xpath("//*[@id='finishbtn']");	
	By quickjobnumber = By.xpath("//*[@id='maincontent']/div[1]/div/div/strong/a");
	By adminfirstname = By.xpath("//*[@id='firstname']");
	By admin = By.xpath("//a[contains(.,'Admin')]");
	By addbuttonimpressioncategory = By.xpath("//*[@id='catalogueItemForm']/div/div/div[15]/div/div[1]/div[2]/div[5]/input");
	By copies = By.xpath("//*[@id='copies']");
	By printtypequote = By.xpath("//*[@id='optionPrintType']");
	By papersizequote=By.xpath("//*[@id='optionPaperSize']");
	By service = By.xpath("//*[@name='unitsService']");
	By servicebutton = By.xpath("//*[@id='servicebtn']");
	By quicksubmitbutton = By.xpath("//a[contains(.,'Submit print job')]");
	By expense = By.xpath("//*[@name='unitsExpense']");
	By expensebutton = By.xpath("//*[@id='expensebtn']");
	By labour = By.xpath("//*[@name='unitsMailroom']");
	By labouradd = By.xpath("(//a[contains(text(),'Add')])[5]");
	By additionalexpense = By.xpath("//*[@name='unitsMail']");
	By additionalexpensebutton = By.xpath("(//a[contains(text(),'Add')])[6]");
	By managerclient = By.xpath("//*[@id='clientcontract']/div/div[1]");
	By manageclientuser = By.xpath("//a[contains(.,'Manage client users')]");
	By search = By.xpath("//a[contains(.,'Search')]");
	By clientlogin = By.xpath("//a[contains(.,'Login')]");
	By switchback = By.xpath("//a[contains(.,'Switch back')]");
	By fujilogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By sizequote=By.xpath("//*[@name='optionImpressionSize']");
	By paperweightquote=By.xpath("//*[@id='optionPaperWeight']");
	By noofsheet=By.xpath("//*[@id='unitsPaper']");
	By finishingtypeprintactual=By.xpath("//*[@id='optionFinishingType']");
	By finishsizequick=By.xpath("//*[@name='optionImpressionSize']");
	By expensequote=By.xpath("//*[@id='optionExpense']");
	By additionallabourquote=By.xpath("//*[@id='optionMailroom']");
	
	/**
	 * @param driver
	 */
	public QuickJob(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @throws InterruptedException
	 */
	public void quickPrintJob() throws InterruptedException {

		// ---------------User Action - PrintJobNumber Created------------------
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
		}
		else {
			Log.info("Not a Print Manager!Fail!!");
		}
		ActionExecutor.clickElement(action);
		ActionExecutor.clickElement(quickjob);
		ActionExecutor.enterValue(adminfirstname, "Client");
		ActionExecutor.clickElement(search);
		ActionExecutor.enterValue(jobdetail, Repository.getProperty("jobdetail"));
		ActionExecutor.enterValue(jobreference, Repository.getProperty("jobreference"));
		ActionExecutor.enterValue(projectcode, Repository.getProperty("projectcode"));
		ActionExecutor.clickElement(quickquoterequired);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(sizequote));
		ActionExecutor.selectValueFromOption(sizequote, Repository.getProperty("sizequote"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(printtypequote));
		ActionExecutor.selectValueFromOption(printtypequote, "Colour");
		//new Select(driver.findElement(printtypequote)).selectByVisibleText("Colour");
		ActionExecutor.enterValue(copies, Repository.getProperty("copies"));
		ActionExecutor.enterValue(impression, Repository.getProperty("impression"));
		ActionExecutor.selectValueFromOption(papersizequote, Repository.getProperty("papersizequote"));
		ActionExecutor.selectValueFromOption(paperweightquote, Repository.getProperty("paperweightquote"));
		driver.findElement(noofsheet).sendKeys("10");
		ActionExecutor.clickElement(quickpaperbutton);
		ActionExecutor.selectValueFromOption(finishingtypeprintactual, Repository.getProperty("finishingtypeprintactual"));
		
		ActionExecutor.selectValueFromOption(finishsizequick, Repository.getProperty("finishsizequick"));

		ActionExecutor.clickElement(quickfinishbutton);	
		ActionExecutor.enterValue(service,Repository.getProperty("service"));
		driver.findElement(servicebutton).click();
		ActionExecutor.selectValueFromOption(expensequote, Repository.getProperty("expensequote"));
		ActionExecutor.enterValue(expense, Repository.getProperty("expense"));
		ActionExecutor.clickElement(expensebutton);
		ActionExecutor.selectValueFromOption(additionallabourquote, Repository.getProperty("additionallabourquote"));
		ActionExecutor.enterValue(labour, Repository.getProperty("labour"));
		ActionExecutor.clickElement(labouradd);
		ActionExecutor.enterValue(additionalexpense, Repository.getProperty("additionalexpense"));
		ActionExecutor.clickElement(additionalexpensebutton);
		ActionExecutor.clickElement(quicksubmitbutton);
		ActionExecutor.storeValue(quickjobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(admin);
		ActionExecutor.clickElement(managerclient);
		ActionExecutor.clickElement(manageclientuser);
		ActionExecutor.enterValue(adminemail, "client@_selenium.test.com");
		ActionExecutor.clickElement(search);
		ActionExecutor.clickElement(clientlogin);
		String JobStatusQuote = driver.findElement(delegationstatus).getText();
		Log.info("client side job message =" + JobStatusQuote);

		if (JobStatusQuote.contains("Quote Pending Approval"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);

		ActionExecutor.clickElement(button1);
		waitFor(1);
		Log.info("Quote Approval Sucess Message =" + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(switchback);
		ActionExecutor.clickElement(fujilogo);
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
		waitFor(1);
		if (driver.findElement(delegationstatus).getText().contains("Pending Approval"))
			Log.info("Pending Approval Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}

}
