package pagelibrary;

import java.util.List;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.support.ui.Select;
import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class PrintJob extends TestBase {

	WebDriver driver;
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By action = By.xpath("//a[@data-activates='actionMenu']/h3");
	By printjob = By.xpath("//*[@id='jobOption1']/div[1]/a/i");
	By adminemail = By.xpath("//*[@id='username']");
	By searchclient = By.xpath("//a[contains(.,'Search')]");
	By startanewjob = By.cssSelector("div[id='startJob']>div>div:nth-child(1)");
	By jobdetail = By.xpath("//input[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By due_time_xpath = By.xpath("//input[@id='dueDate_Time']");
	By due_time_options_xpath = By.xpath("//li[@class='ui-menu-item']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By duetime = By.xpath("//*[@id='dueDate_Time']");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By quoterequired = By.xpath("//input[@id='quoteRequiredId']/following-sibling::label");
	By uploadfile = By.xpath("//div[@id='uploadFile']/div/div");
	By uploadframe = By.xpath("//iframe[@id='uploadframe']");
	By uploadaddbutton = By.xpath("//span[@class='btn02 addFilesLink fileinput-button']");
	By uploadandsavefile = By.xpath("//*[@id='startupload2']/span");
	By jobdetailsection = By.xpath("//*[@id='jobDetails']");
	//By quantity = By.xpath("//*[@id='quantity']");
	By quantity = By.xpath("//*[@name='quantity']");
	By proofcheckbox = By.xpath("//input[@id='proofReq']/following-sibling::label");
	By noofproof = By.xpath("//*[@id='numberofproofcopies']");
	By deliverydetails = By.xpath("//*[@id='deliveryDetails']");
	By deliveryoptionone = By.xpath("//input[@value='Deliver to me']/following-sibling::label");
	By submitbutton = By.xpath("//*[@id='submitJob']");
	By submitprintjob = By.xpath("//a[contains(.,'Submit print job')]");
	By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By jobnumber = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");
	By fxUsername = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By signinbutton = By.xpath("//*[@id='loginbtn']");
	By searchboxicon = By.xpath("//*[@id='filterIcon']/i");
	By searchjobno = By.xpath("//*[@id='jobNo']");
	By filterbutton = By.xpath("//*[@id='continuebtn']");
	By clickonjobnoie = By.xpath("//*[@id='taskItem']/tbody/tr[1]/td[1]/a");
	By completejob=By.xpath("//*[@id='jobItem']/tbody/tr[20]/td[1]/a");	
	By savestatus = By.xpath("//*[@id='taskItem']/tbody/tr/td[6]");
	By proceedtoquotebutton = By.xpath("//a[contains(.,'proceed to quote')]");
	By impression = By.xpath("//*[@id='impressions']");
	By addbuttonimpression = By.xpath("//*[@id='printCostForm']/div[1]/div[2]/div[9]/a");
	
	By addbuttonpaper=By.xpath("//*[@id='printCostForm']/div[3]/div[2]/div/div[1]/div[8]/a");
	By addbuttonfinish=By.xpath("//*[@id='printCostForm']/div[6]/div[2]/div[8]/a");
	By addbuttonfinishactual=By.xpath("//*[@id='printCostForm']/div[5]/div[2]/div[8]/a");
	By addbuttonservice=By.xpath("//*[@id='maincontent']/div[4]/div[2]/div[6]/a");
	By addbuttonserviceactual=By.xpath("//*[@id='taskandtime']/div[1]/div[2]/div[6]/a");
	By addbuttonexpense=By.xpath("//*[@id='maincontent']/div[6]/div[2]/div[5]/a");
	By addbuttonexpenseactual=By.xpath("//*[@id='taskandtime']/div[3]/div[2]/div[5]/a");

	By addbuttonadditionallabour=By.xpath("//*[@id='outer']/div[7]/div[2]/div[6]/a");
	By addbuttonadditionallabouractual=By.xpath("//*[@id='maincontent']/div[6]/div[2]/div[6]/a");
	By addbuttonaddexpense=By.xpath("//*[@id='outer']/div[9]/div[2]/div[5]/a");
	By addbuttonaddexpenseactual=By.xpath("//*[@id='maincontent']/div[8]/div[2]/div[5]/a");

	
	By approverdate = By.xpath("//*[@id='approvalDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By dateselect = By.xpath("//*[@id='approvalDate_Date_table']/tbody/tr[4]/td[5]/div");
	By sendforapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By jobsurveybutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By declinebutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By cancelbutton = By.xpath("//*[@id='detailedSummary0']/div[1]/div[2]/a");
	By message = By.xpath("//*[@id='message']");
	By proofapprovaldate = By.xpath("//*[@id='approval_Date']");
	By proofapprovaldateselect = By.xpath("//*[@id='approval_Date_table']/tbody/tr[3]/td[5]/div");
	By startbutton = By.xpath("//*[@id='continuebtn']");
	By submitsurveyresponse = By.xpath("//*[@id='declinebutton']");
	By quickjobsearch = By.xpath("//*[@id='searchJobno']");
	By quicksearchhit = By.xpath("//form[@name='jobsearchform']/i");
	By jobcompletestatus = By.xpath("//*[@id='jobSummaryForm']/div/div[1]/div[1]");
	By querycategory = By.xpath("//*[@id='detailedSummary0rejectionType']");
	By querycomment = By.xpath("//*[@id='detailedSummary0rejectionComments']");
	By queryjob = By.xpath("//*[@id='detailedSummary0querybtn']/a[1]");
	By finalisejobbutton = By.xpath("//a[contains(.,'Finalise job')]");
	By printtype = By.xpath("//*[@id='optionPrintType']");
	By finishtype = By.xpath("//*[@id='finishedSize']");
	By paperweight=By.xpath("//*[@id='optionPaperWeight']");
	
	By copyandmodify = By.xpath("//a[contains(.,'Copy and modify previous job')]");
	By searchbutton = By.xpath("//*[@id='continuebtn']");
	By copyandmodifyjob = By.xpath("//a[contains(.,' Copy and modify job')]");
	By jobstatus=By.xpath("//*[@id='jobStatus']");
	By jobwastage=By.xpath("//*[@id='usageTypeId']");
	By savewastage=By.xpath("//a[contains(.,'Save wastage')]");
	By clearwastage=By.xpath("//a[contains(.,'Clear wastage')]");
	
	By sizequote=By.xpath("//*[@name='optionImpressionSize']");
	By printtypequote=By.xpath("//*[@id='optionPrintType']");
	By sidequote=By.xpath("//*[@id='optionDuplexing']");
	By papersizequote=By.xpath("//*[@id='optionPaperSize']");
	By paperweightquote=By.xpath("//*[@id='optionPaperWeight']");
	By finishingtypequote=By.xpath("//*[@id='optionFinishingType']");
	By servicequote=By.xpath("//*[@id='optionService']");
	By noofunitservice=By.xpath("//*[@name='unitsService']");
	
	By expensequote=By.xpath("//*[@id='optionExpense']");
	By costexpense=By.xpath("//*[@name='unitsExpense']");
	By costaddexpense=By.xpath("//*[@name='unitsMail']");
	
	By additionallabourquote=By.xpath("//*[@id='optionMailroom']");
	By noofounitaddlabour=By.xpath("//*[@name='unitsMailroom']");
	
	By additionalexpensequote=By.xpath("//*[@id='optionMail']");
	
	
	By sizeprintactual=By.xpath("//*[@name='optionImpressionSize']");
	By printtypeprintactual=By.xpath("//*[@id='optionPrintType']");
	By sideprintactual=By.xpath("//*[@id='optionDuplexing']");
	By papersizeprintactual=By.xpath("//*[@id='optionPaperSize']");
	By paperweightprintactual=By.xpath("//*[@id='optionPaperWeight']");
	By finishingtypeprintactual=By.xpath("//*[@id='optionFinishingType']");
	By serviceprintactual=By.xpath("//*[@id='optionService']");
	By noofunitserviceprintactual=By.xpath("//*[@name='unitsService']");
	
	By expenseprintactual=By.xpath("//*[@id='optionExpense']");
	By costexpenseprintactual=By.xpath("//*[@name='unitsExpense']");
	By costaddexpenseprintactual=By.xpath("//*[@name='unitsMail']");
	
	By additionallabourprintactual=By.xpath("//*[@id='optionMailroom']");
	By noofounitaddlabourprintactual=By.xpath("//*[@name='unitsMailroom']");
	
	By additionalexpenseprintactual=By.xpath("//*[@id='optionMail']");
	
	By deliverytospecificaddress = By.xpath("//label[@for='deliveryMethodAddr']");

	By deliverycontactname=By.xpath("//*[@name='deliveryAddress.contactName']");
	By deliveryadd1=By.xpath("//*[@name='deliveryAddress.addressLine1']");
	By deliveryadd2=By.xpath("//*[@name='deliveryAddress.addressLine2']");
	By deliverycity=By.xpath("//*[@name='deliveryAddress.suburb']");
	By deliverycountry=By.xpath("//*[@name='deliveryAddress.country']");
	By deliverypostcode=By.xpath("//*[@name='deliveryAddress.postcode']");
	//By deliveryaddrequirement=By.xpath("//*[@id='additionalrequirements']");
	
	By totalnoofpagesestimate=By.xpath("//*[@id='totalPageNumber']");
	By updateestimate=By.xpath("//*[@name='btnUpdateEstimate']");
	By closebutton=By.xpath("//*[@id='continuebtn']");
	
	 
	

	
	
	
	public PrintJob(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	public void startNewJobSection() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(startanewjob));
		ActionExecutor.clickElement(startanewjob);
		ActionExecutor.clickElement(printjob);
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
		options.get(10).click();
		ActionExecutor.setReportVariables("Click", "Passed", "Value has been clicked" + options.get(10));
		waitFor(2);
		ActionExecutor.clickElement(highpriority);
		waitFor(2);
		ActionExecutor.clickElement(quoterequired);

	}

	public void uploadFileSection() throws InterruptedException {
		ActionExecutor.clickElement(uploadfile);
		ActionExecutor.getFrame(uploadframe);
		ActionExecutor.clickElement(uploadaddbutton);
		ActionExecutor.uploadFile("Doc1.docx,textdoc1.txt");
		ActionExecutor.clickElement(uploadandsavefile);
		
	}

	public void jobDetailSection() throws InterruptedException {
		ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
		ActionExecutor.selectValueFromOption(printtype, Repository.getProperty("printtype"));
		ActionExecutor.selectValueFromOption(finishtype, Repository.getProperty("finishtype"));
		ActionExecutor.selectValueFromOption(paperweight, Repository.getProperty("paperweight"));
		ActionExecutor.clickElement(proofcheckbox);
		ActionExecutor.enterValue(noofproof, Repository.getProperty("noofproof"));
		
		driver.findElement(totalnoofpagesestimate).sendKeys("12");
		driver.findElement(updateestimate).click();
	}

	public void deliveryDetailSection() throws InterruptedException {
		ActionExecutor.clickElement(deliverydetails);
		ActionExecutor.clickElement(deliveryoptionone);
		driver.findElement(deliverytospecificaddress).click();
		driver.findElement(deliverycontactname).sendKeys("testing contact name");
		driver.findElement(deliveryadd1).sendKeys("testing contact address one");
		
		driver.findElement(deliveryadd2).sendKeys("testing contact address two");
		driver.findElement(deliverycity).sendKeys("sydney");
		driver.findElement(deliverypostcode).sendKeys("3000");
		//driver.findElement(deliveryaddrequirement).sendKeys("testing contact additional requirement");
		
		
	}

	public void submitJobSection() throws InterruptedException {
		ActionExecutor.clickElement(submitbutton);
		ActionExecutor.clickElement(submitprintjob);
	}

	public void printJobNew(String username, String password) throws InterruptedException {

		// ---------------User Action - PrintJobNumber Created------------------
		ActionExecutor.storeValue(jobnumber, "jobno");
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);

		// ---------------User Action - Login With Print Manager------------------
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);

	/*	if (driver.findElement(titlecompass).getText().contains("Print Manager")) {
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

		if (driver.findElement(savestatus).getText().contains("Pending review"))
			Log.info("Job Review Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}

		waitFor(2);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(proceedtoquotebutton);		
		ActionExecutor.selectValueFromOption(sizequote, Repository.getProperty("sizequote"));
		//ActionExecutor.selectValueFromOption(sidequote, Repository.getProperty("sidequote"));
		new Select(driver.findElement(sidequote)).selectByVisibleText("Single sided");
		new Select(driver.findElement(printtypequote)).selectByVisibleText("Colour");
		

	//	ActionExecutor.selectValueFromOption(printtypequote, Repository.getProperty("printtypequote"));
		driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//ActionExecutor.enterValue(impression, "10");
		ActionExecutor.clickElement(addbuttonimpression);
		
		ActionExecutor.selectValueFromOption(papersizequote, Repository.getProperty("papersizequote"));
		ActionExecutor.selectValueFromOption(paperweightquote, Repository.getProperty("paperweightquote"));
		ActionExecutor.clickElement(addbuttonpaper);
		ActionExecutor.selectValueFromOption(finishingtypequote, Repository.getProperty("finishingtypequote"));	
		driver.findElement(addbuttonfinish).click();
		
	//	ActionExecutor.selectValueFromOption(servicequote, Repository.getProperty("servicequote"));
		driver.findElement(noofunitservice).sendKeys("10");
		driver.findElement(addbuttonservice).click();
		ActionExecutor.selectValueFromOption(expensequote, Repository.getProperty("expensequote"));
		driver.findElement(costexpense).sendKeys("10");
		driver.findElement(addbuttonexpense).click();
		ActionExecutor.selectValueFromOption(additionallabourquote, Repository.getProperty("additionallabourquote"));
		driver.findElement(noofounitaddlabour).sendKeys("10");
		driver.findElement(addbuttonadditionallabour).click();
		//ActionExecutor.selectValueFromOption(additionalexpensequote, Repository.getProperty("additionalexpensequote"));
		driver.findElement(costaddexpense).sendKeys("10");
		driver.findElement(addbuttonaddexpense).click();
		
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
		String proofInProgressStatus = driver.findElement(savestatus).getText();
		waitFor(1);
		if (proofInProgressStatus.contains("Proof in Progress"))
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
		String printProofSentMessage = driver.findElement(successmessage).getText();
		Log.info("Print Proof sent message = =" + printProofSentMessage);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);

		String proofPendingStatus = driver.findElement(delegationstatus).getText();
		waitFor(1);
		if (proofPendingStatus.contains("Proof Pending Approval"))
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
		
		ActionExecutor.selectValueFromOption(sizeprintactual, Repository.getProperty("sizeprintactual"));
		//ActionExecutor.selectValueFromOption(sideprintactual, Repository.getProperty("sideprintactual"));
		ActionExecutor.selectValueFromOption(printtypeprintactual, Repository.getProperty("printtypeprintactual"));
		driver.findElement(impression).click();
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
		//ActionExecutor.enterValue(impression, "10");
		ActionExecutor.clickElement(addbuttonimpression);
		
				
		ActionExecutor.selectValueFromOption(papersizeprintactual, Repository.getProperty("papersizeprintactual"));
		ActionExecutor.selectValueFromOption(paperweightprintactual, Repository.getProperty("paperweightprintactual"));
		ActionExecutor.clickElement(addbuttonpaper);
		ActionExecutor.selectValueFromOption(finishingtypeprintactual, Repository.getProperty("finishingtypeprintactual"));	
		driver.findElement(addbuttonfinishactual).click();
		
		//ActionExecutor.selectValueFromOption(serviceprintactual, Repository.getProperty("serviceprintactual"));
		driver.findElement(noofunitservice).sendKeys("10");
		driver.findElement(addbuttonserviceactual).click();
		ActionExecutor.selectValueFromOption(expenseprintactual, Repository.getProperty("expenseprintactual"));
		driver.findElement(costexpense).sendKeys("10");
		driver.findElement(addbuttonexpenseactual).click();
		ActionExecutor.selectValueFromOption(additionallabourquote, Repository.getProperty("additionallabourquote"));
		driver.findElement(noofounitaddlabour).sendKeys("10");
		driver.findElement(addbuttonadditionallabouractual).click();
		//ActionExecutor.selectValueFromOption(additionalexpenseprintactual, Repository.getProperty("additionalexpenseprintactual"));
		driver.findElement(costaddexpense).sendKeys("10");
		driver.findElement(addbuttonaddexpenseactual).click();
		
		
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("proof saved message =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);

		String pendingApprovalStatus = driver.findElement(delegationstatus).getText();
		waitFor(1);

		if (pendingApprovalStatus.contains("Pending Approval"))
			Log.info("Pending Approval Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(delegationstatus);
	}

	public void queryJob() throws InterruptedException {

		// -----------------------------Query Job--------------------------------------------------
		ActionExecutor.clickElement(button1);
		ActionExecutor.selectValueFromOption(querycategory, "Manager decision");
		ActionExecutor.enterValue(querycomment, "for testing purpose");
		ActionExecutor.clickElement(queryjob);
		waitFor(2);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		//waitFor(1);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		if (driver.findElement(savestatus).getText().contains("Job Declined"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}

		// -------------------Job Wastage---------------------------------------------------
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.selectValueFromOption(jobwastage, "Client Rejected - Quality");		
		ActionExecutor.clickElement(finalisejobbutton);
		Log.info("finalise message is = " + driver.findElement(successmessage).getText());

		// -------------Quick Search the Job for Job Complete Status---------------------------

		ActionExecutor.enterValue(quickjobsearch, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(quicksearchhit);
		if (driver.findElement(jobcompletestatus).getText().contains("Job Completed"))
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}

	}

	public void jobSurvey() throws InterruptedException {
		// ---------------------------Job Survey---------------------------------------------
		ActionExecutor.clickElement(jobsurveybutton);
		ActionExecutor.clickElement(submitsurveyresponse);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);

		// -------------------------Quick Search the Job for Job Complete Status----------------
		ActionExecutor.enterValue(quickjobsearch, ActionExecutor.getValue("jobno"));
		ActionExecutor.clickElement(quicksearchhit);

		if (driver.findElement(jobcompletestatus).getText().contains("Job Completed")) {
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		} else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}

		Log.info("============================================");

	}

	public void copyAndModifyJob() throws InterruptedException {
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(2);
		driver.findElement(action).click();
		waitFor(1);
		driver.findElement(copyandmodify).click();
		driver.findElement(filterbutton).click();
		waitFor(2);
		String abjob= driver.findElement(completejob).getText();
		System.out.println(abjob);
		driver.findElement(completejob).click();
		driver.findElement(copyandmodifyjob).click();
		driver.findElement(submitprintjob).click();
		ActionExecutor.storeValue(jobnumber, "jobnonew");

	}
	
	public void jobWastage()
	{
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.selectValueFromOption(jobstatus, "Job Declined");		
		ActionExecutor.clickElement(filterbutton);
		String ajob= driver.findElement(clickonjobnoie).getText();
		System.out.println(ajob);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.selectValueFromOption(jobwastage, "Client Rejected - Quality");		
		ActionExecutor.clickElement(clearwastage);
		ActionExecutor.clickElement(savewastage);
		String JobWastageSaveMessage = driver.findElement(successmessage).getText();
		Log.info("Job Wastage Save Message is =" + JobWastageSaveMessage);
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(finalisejobbutton);
		String FinalisejobMessage = driver.findElement(successmessage).getText();
		Log.info("Finalise job Message is =" + FinalisejobMessage);
		ActionExecutor.enterValue(quickjobsearch, ajob);
		ActionExecutor.clickElement(quicksearchhit);
		if (driver.findElement(jobcompletestatus).getText().contains("Job Completed"))
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}
		

	}

}
