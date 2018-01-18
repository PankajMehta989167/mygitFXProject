package pagelibrary;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.Select;

	import executor.ActionExecutor;
	import log.Log;
	import testBase.TestBase;

	public class PrintTemplate extends TestBase {

		WebDriver driver;
		String randomFirstName = ActionExecutor.randomFirstName();
		
		By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
		By action = By.xpath("//a[@data-activates='actionMenu']/h3");
		By hubcenter = By.xpath("//*[@name='hubSiteId']");
		By printjobrequest = By.xpath("//*[@id='actionMenu']/li[2]/a");
		By adminemail = By.xpath("//*[@id='username']");
		By searchclient = By.xpath("//a[contains(.,'Search')]");
		By timer = By.linkText("8:00 AM");
		By startanewjob = By.xpath("//*[@id='startJob']/div/div[1]");
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
		By submitprintjob = By.xpath("//a[contains(.,'Submit print job')]");
		By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
		By logout = By.xpath("//a[contains(.,'Log out')]");
		By startJob = By.xpath("//*[@id='startJob']/div/div[1]");
		By signInlbl = By.xpath("//*[@id='maincontent']/div/div/div/div[2]/div[3]/h5/b");
		By jobnumber = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");

		By fxUsername = By.xpath("//*[@id='j_username']");
		By fxPassword = By.xpath("//*[@id='j_password']");
		By signinbutton = By.xpath("//*[@id='loginbtn']");
		By searchboxicon = By.xpath("//*[@id='filterIcon']/i");
		By searchjobno = By.xpath("//*[@id='jobNo']");
		By filterbutton = By.xpath("//*[@id='continuebtn']");
		By clickonjobnoie = By.xpath("//*[@id='taskItem']/tbody/tr/td[1]/a");
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
		By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
		By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
		By approvebutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
		By message = By.xpath("//*[@id='message']");
		By proofapprovaldate = By.xpath("//input[@id='approval_Date']");
		By proofapprovaldateselect = By.xpath("//*[@id='approval_Date_table']/tbody/tr[3]/td[5]/div");
		By sendforquoteapprovalbutton = By.xpath("//*[@id='maincontent']/div[3]/div[7]/div/a[1]");
		By startbutton = By.xpath("//*[@id='continuebtn']");
		By finalapproval = By.xpath("//*[@id='maincontent']/div[14]/div[6]/div/a[3]");
		By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
		By adminbutton= By.xpath("//a[contains(.,'Admin')]");
		By manageclientcontract= By.xpath("//*[@id='clientcontract']/div/div[1]");
		By manageprinttemplate= By.xpath("//a[contains(.,'Manage print templates')]");
		By contractno= By.xpath("//*[@id='contractId']");
		By addnewtemplate= By.xpath("//a[contains(.,'Add new template')]");
		By templatename= By.xpath("//*[@id='name']");
		By shortcutkey= By.xpath("//*[@id='printTemplateForm']/div/div/div[7]/div/input");
		By templatedescription =By.xpath("//*[@id='description']");
		By proofrequiredcheck= By.xpath("//*[@id='printTemplateForm']/div/div/div[12]/div[1]/label");
      //  By noofproofs= By.xpath("//*[@id='numberofproofcopies']");
       // By noofproof = By.xpath("//*[@id='numberofproofcopies']");
        By reviewoption= By.xpath("//*[@id='printTemplateForm']/div/div/div[44]/div/a[2]");
        By addnewtemplate2= By.xpath("//*[@id='printTemplateStep2Form']/div/div/div[22]/div/a[2]");
        By terminatereason = By.xpath("//*[@class='select-dropdown']");
    	By hardcopy = By.xpath("//*[@id='mediaSource']");
    	By supplymethod = By.xpath("//*[@id='supplyMethod']");
    	By website = By.xpath("//*[@id='webref2']");
    	By addlocation = By.xpath("//*[@id='addlocation']");
    	By printicon= By.xpath("//*[@id='jobOption1']/div[1]/a/i");
    	By optiontemplate= By.xpath("//*[@id='optionTemplate']");
    	By applybutton= By.xpath("//*[@id='savePrintDetailsForm']/div/div[2]/div[3]/button");
    	By manageclientusers= By.xpath("//*[@id='clientcontractBody']/table/tbody/tr/td/ul/li[1]/a");
    	By loginclient= By.xpath("//*[@id='users']/tbody/tr/td[4]/a[3]");
    	By switchback= By.xpath("//*[@id='userMenu']/li[11]/a");
    	By fujixeroxlogo= By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
    
     
		/**
		 * @param driver
		 */
		public PrintTemplate(WebDriver driver) {
			this.driver = driver;
			ActionExecutor.setDriver(driver);
		}

		/**
		 * @throws InterruptedException
		 */
		public void PrintTemplatecreation() throws InterruptedException {
			ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(adminbutton);
			ActionExecutor.clickElement(manageclientcontract);
			ActionExecutor.clickElement(manageprinttemplate);
			Select contractdropdown = new Select(driver.findElement(contractno));
			contractdropdown.selectByVisibleText("Selenium Auto Test - D210");
			waitFor(2);
			driver.findElement(addnewtemplate).click();
			ActionExecutor.enterValue(templatename, randomFirstName);
			ActionExecutor.enterValue(shortcutkey, "automation shortcut key");
			ActionExecutor.enterValue(templatedescription, "automation shortcut key");
			ActionExecutor.clickElement(proofrequiredcheck);
			//ActionExecutor.enterValue(noofproof, "12");
			ActionExecutor.enterValue(noofproof, Repository.getProperty("noofproof"));
			ActionExecutor.clickElement(reviewoption);
			ActionExecutor.clickElement(addnewtemplate2);
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(logout);
		}
		
		public void Printjobtemplatecreation() throws InterruptedException {
			ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(startanewjob);
			ActionExecutor.clickElement(printicon);
			ActionExecutor.enterValue(jobdetail, Repository.getProperty("jobdetail"));
			ActionExecutor.enterValue(jobreference, Repository.getProperty("jobreference"));
			ActionExecutor.enterValue(projectcode, Repository.getProperty("projectcode"));
			ActionExecutor.clickElement(duedate); // 1
			ActionExecutor.clickElement(nextmonth);
			ActionExecutor.clickElement(duedateselect);
			ActionExecutor.clickElement(highpriority);
			ActionExecutor.clickElement(quoterequired);
			ActionExecutor.clickElement(jobdetailsection);
			
			Select optiontemp = new Select(driver.findElement(optiontemplate));
			optiontemp.selectByVisibleText(randomFirstName);
			ActionExecutor.clickElement(applybutton);
			ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
			Select hardcopydropdown = new Select(driver.findElement(hardcopy));
			hardcopydropdown.selectByVisibleText("CD");
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
			ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(searchboxicon);
			ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
			ActionExecutor.clickElement(filterbutton);
			
		}
		/**
		 * @throws InterruptedException
		 */
		public void quoteApproval() throws InterruptedException {
			ActionExecutor.clickElement(clickonjobnoie);
			ActionExecutor.clickElement(proceedtoquotebutton);
			driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
			//driver.findElement(impression).sendKeys("10");
			ActionExecutor.clickElement(addbuttonimpression);
			
			ActionExecutor.clickElement(addbuttonpaper);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(approverdate));
			ActionExecutor.clickElement(approverdate);
			ActionExecutor.clickElement(nextmonth);
			ActionExecutor.clickElement(dateselect);
			waitFor(2);
			ActionExecutor.clickElement(sendforapprovalbutton);
			
			Log.info("Print Manager Side Message =" + driver.findElement(successmessage).getText());
			
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(adminbutton);
			ActionExecutor.clickElement(manageclientcontract);
			ActionExecutor.clickElement(manageclientusers);
			ActionExecutor.enterValue(adminemail, "client@_selenium.test.com");
			ActionExecutor.clickElement(searchclient);
			ActionExecutor.clickElement(loginclient);
			ActionExecutor.clickElement(delegationstatus);
			ActionExecutor.clickElement(approvebutton);
			Log.info("job approval sucess message " + driver.findElement(message).getText());

			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(switchback);
			ActionExecutor.clickElement(fujixeroxlogo);
			ActionExecutor.clickElement(searchboxicon);
			ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
			ActionExecutor.clickElement(filterbutton);
			Log.info("job status is" + driver.findElement(savestatus).getText());
			ActionExecutor.clickElement(clickonjobnoie);
			ActionExecutor.clickElement(proofapprovaldate); // 3
			ActionExecutor.clickElement(nextmonth);
			ActionExecutor.clickElement(proofapprovaldateselect);
			ActionExecutor.clickElement(sendforquoteapprovalbutton);
			Log.info("success message after send for approval" + driver.findElement(successmessage).getText());
			
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(logout);
			ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(hamburgermenu);

			if (driver.findElement(titlecompass).getText().equals("Client Selenium Test"))
				Log.info("Login contains client");
			else {
				Log.info("Not logged in with client");
			}
			ActionExecutor.clickElement(titlecompass);
			Log.info("client side job message" + driver.findElement(delegationstatus).getText());
			ActionExecutor.clickElement(delegationstatus);
			ActionExecutor.clickElement(approvebutton);
			Log.info("job approval sucess message" + driver.findElement(message).getText());

			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(logout);
			ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(titlecompass);
			ActionExecutor.clickElement(searchboxicon);
			ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
			ActionExecutor.clickElement(filterbutton);
			Log.info("job status is" + driver.findElement(savestatus).getText());

			ActionExecutor.clickElement(clickonjobnoie);
			ActionExecutor.clickElement(startbutton);
			ActionExecutor.clickElement(startbutton);
			ActionExecutor.clickElement(startbutton);
			ActionExecutor.clickElement(finalapproval);

			Log.info("success message after send for approval" + driver.findElement(successmessage).getText());

			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(logout);
			ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);
			ActionExecutor.clickElement(delegationstatus);
		}

		
	}