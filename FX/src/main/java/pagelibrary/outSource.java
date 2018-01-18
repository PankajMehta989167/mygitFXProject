package pagelibrary;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class outSource extends TestBase {

	WebDriver driver;
	Alert alert = null;
	String OJob="SAT000050896-1";

	By others_xpath = By.xpath("//div[@id='jobOption1']/div[3]/a/i");
	By outsource_xpath = By.xpath("//div[@id='jobOption0']/div[1]/a/i");
	By job_name_xpath = By.xpath("//input[@id='name']");
	By job_reference_xpath = By.xpath("//*[@name='clientJobId']");
	By project_code_xpath = By.xpath("//*[@name='projectCode']");
	By job_description_xpath = By.xpath("//*[@name='description']");
	By campaign_xpath = By.xpath("//*[@name='campaign']");
	By product_code_xpath = By.xpath("//*[@name='productCode']");
	By high_priprity_pleasenote_xpath = By.xpath("//input[@id='priority']/following-sibling::label");
	By fsc_coc_xpath = By.xpath("//input[@id='fsc']/following-sibling::label");
	By quantityone_xpath = By.xpath("//*[@name='quantity']");
	By quantitytwo_xpath = By.xpath("//*[@name='quantity2']");
	By quantitythree_xpath = By.xpath("//*[@name='quantity3']");
	By quantityfour_xpath = By.xpath("//*[@name='quantity4']");
	By quantityfive_xpath = By.xpath("//*[@name='quantity5']");
	By quantitysix_xpath = By.xpath("//*[@name='quantity6']");
	By flexispec_xpath = By.xpath("//div[@id='flexiSpec']/div/div[1]");
	By job_type_selection_xpath = By.xpath("//select[@id='groupId']");
	By pagination_no_ofpanels_xpath = By.xpath("//*[@id='flexiSpecForm']/div[1]/div/div[2]/div/textarea");
	By other_xpath = By.xpath("//label[@for='246']");
	By other_box_xpath = By.xpath("//*[@name='propertyMapped(246)']");
	By black_inks_xpath = By.xpath("//label[@for='259']");
	By delivery_details_xpath = By.xpath("//*[@id='deliveryDetails']");
	By customer_name_xpath = By.xpath("//*[@id='customerName']");
	By contact_name_xpath = By.xpath("//*[@id='contactName']");
	By phone_xpath = By.xpath("//*[@id='phone']");
	By address_one_xpath = By.xpath("//*[@id='addressLine1']");
	By address_two_xpath = By.xpath("//*[@id='addressLine2']");
	By city_xpath = By.xpath("//*[@id='suburb']");
	By postcode_xpath = By.xpath("//*[@id='postcode']");
	By note_xpath = By.xpath("//*[@id='notes']");
	By delivery_method_xpath = By.xpath("//*[@id='deliveryMethod']");
	By quantity_xpath = By.xpath("//input[@id='quantity']");
	By addbutton_delivery_xpath = By.xpath("//*[@id='outDeliveryDetailsForm']/div[15]/div/a");
	By delete_button_xpath = By.xpath("//a[@class='btn bttn02']");
	By submitbutton_xpath = By.xpath("//*[@id='submitJob']");
	By submit_job_xpath = By.xpath("//a[@class='btn bttn02 right align']");
	By job_number_submit_job_xpath = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");
	By jobnumber = By.xpath("//*[@id='confirmation']/div/div/p[2]/strong/a");
	By hamburgermenu = By.xpath("//input[@id='searchJobno']/following-sibling::a");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By searchboxicon_xpath = By.xpath("//*[@id='filterIcon']");
	By jobno_xpath = By.xpath("//*[@id='jobNo']");
	By filter_xpath = By.xpath("//form[@id='jobFilterForm']/div[3]/div/a[1]");
	By status_xpath = By.xpath("//td[contains(.,'Pending review')]");
	By first_job_number_xpath = By.xpath("//*[@id='taskItem']/tbody/tr[1]/td[1]/a");
	By i_am_done_proceed_xpath = By.xpath("//a[@name='btnSubmit']");
	By request_quote_from_p3_xpath = By.xpath("//a[@id='continuebtn']");
	By fujilogo=By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By startanewjob = By.cssSelector("div[id='startJob']>div>div:nth-child(1)");
	By FXusername = By.xpath("//*[@id='j_username']");
	By FXpassword = By.xpath("//*[@id='j_password']");
	By signinbutton=By.xpath("//*[@id='loginbtn']");
	By green_tick_image_xpath = By.xpath("//input[@type='image']"); 
	//By green_tick_image_xpath =By.xpath("//input[contains(@type,'image')]");
	By sendthequote=By.xpath("//a[contains(.,'send the quote')]");
	By daomessage=By.xpath("//*[@id='staffFilter']/div[1]");
	By selectlabel=By.xpath("//*[@id='quotePreapprovalForm']/div[5]/div[2]/table/tbody/tr/td[1]/label");
	By selecttermandcondition=By.xpath("//*[@id='detailedSummary0Modal4tncId']");
	By savequoteselectionbutton= By.xpath("//a[contains(.,'Save Quote Selection')]");
	By successmessage = By.xpath("//*[@id='maincontent']/div[1]/div/div[1]");
	By message = By.xpath("//*[@id='message']");
	By savestatus = By.xpath("//*[@id='taskItem']/tbody/tr/td[7]");
	By sendforapprovalbutton = By.xpath("//a[contains(.,'send for approval')]");
	By fxUsername = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By delegationstatus = By.xpath("//*[@id='jobReqAttBody']/ul/li[1]/div[1]/div/div[4]");
	By button1 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[1]");
	By searchboxicon = By.xpath("//*[@id='filterIcon']/i");
	By searchjobno = By.xpath("//*[@id='jobNo']");
	By filterbutton = By.xpath("//*[@id='continuebtn']");
	By clickonjobnoie = By.xpath("//*[@id='taskItem']/tbody/tr[1]/td[1]/a");
	By querycategory = By.xpath("//*[@id='detailedSummary0rejectionType']");
	By querycomment = By.xpath("//*[@id='detailedSummary0rejectionComments']");
	By queryjob = By.xpath("//*[@id='detailedSummary0querybtn']/a[1]");
	By finalisejobbutton = By.xpath("//a[contains(.,'Finalise job')]");
	By jobwastage=By.xpath("//*[@id='usageTypeId']");
	By quickjobsearch = By.xpath("//*[@id='searchJobno']");
	By quicksearchhit = By.xpath("//form[@name='jobsearchform']/i");
	By jobcompletestatus = By.xpath("//*[@id='jobSummaryForm']/div/div[1]/div[1]");
	By jobsurveybutton = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By submitsurveyresponse = By.xpath("//*[@id='declinebutton']");
	By fullspecification = By.xpath("//a[contains(.,'Full specifications..')]");
	By cancelbutton = By.xpath("//*[@id='detailedSummary0']/div[1]/div[2]/a");
	By cancelcomment = By.xpath("//*[@id='detailedSummary0Modal1terminationComments']");
	By cancelproof = By.xpath("//*[@id='terminateJobForm']/div[5]/div/a[1]");
	By cancelcategory = By.xpath("//*[@id='detailedSummary0Modal1terminationType']");
	By cancelmessage = By.xpath("//*[@id='maincontent']/div/div[1]/div[1]");
	By button2 = By.xpath("//*[@id='jobSummaryForm']/div[1]/div[3]/a[2]");
	By declinequote = By.xpath("//*[@id='detailedSummary0declinebtn']/a[1]");
	By imagenew =By.xpath("//input[contains(@type,'image')]");
	By markupnotes=By.xpath("//*[@name='markupReason']");
			
	public outSource(WebDriver driver) 
	{
		this.driver = driver;
		driver.manage().window().maximize();
		ActionExecutor.setDriver(driver);

	}

	public void sendForQuoteP3() throws IOException, InterruptedException
	{
		ActionExecutor.enterValue(FXusername, "dao@_selenium.test.com");
	    ActionExecutor.enterValue(FXpassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
	     ActionExecutor.clickElement(searchboxicon_xpath);
	     ActionExecutor.enterValue(jobno_xpath, OJob);
	      
	     ActionExecutor.clickElement(filter_xpath);
	     waitFor(3);
	     WebElement image1 = driver.findElement(green_tick_image_xpath);	 
	    
	     if (image1.isDisplayed())
	    {
	       ActionExecutor.highLightElement(green_tick_image_xpath);	   
	       System.out.println("green tick is present");
	    }
	    else
	    {
	        System.out.println("No green tick");
	    }

	}
    public void outSourceQuery() throws IOException, InterruptedException
{
	if (driver.findElement(savestatus).getText().contains("Preparing Quote"))
		Log.info("Preparing Quote Status matched!Proceed Further!!");
	else {
		Log.info("Status matching failed!!");
	}
	ActionExecutor.clickElement(clickonjobnoie);
	driver.findElement(markupnotes).sendKeys("test");
	ActionExecutor.clickElement(sendthequote);
	Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
	driver.findElement(selectlabel).click();
	waitFor(2);
	driver.findElement(selecttermandcondition).click();
	driver.findElement(savequoteselectionbutton).click();
	Log.info("Quote Message from client side =" + driver.findElement(successmessage).getText());
	ActionExecutor.clickElement(delegationstatus);
	ActionExecutor.clickElement(button1);
	waitFor(2);
	Log.info("query job sucess message = " + driver.findElement(message).getText());
	ActionExecutor.clickElement(hamburgermenu);
	ActionExecutor.clickElement(logout);
	ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
	ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
	ActionExecutor.clickElement(signinbutton);
	ActionExecutor.clickElement(searchboxicon);
	ActionExecutor.enterValue(searchjobno, OJob);
	ActionExecutor.clickElement(filterbutton);
	waitFor(1);
	
	if (driver.findElement(savestatus).getText().contains("Job Declined"))
		Log.info("Quote Pending Status matched!Proceed Further!!");
	else {
		Log.info("Status matching failed!!");
	}
	ActionExecutor.clickElement(clickonjobnoie);
	ActionExecutor.clickElement(sendforapprovalbutton);
	Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
	
	ActionExecutor.clickElement(button1);
	ActionExecutor.selectValueFromOption(querycategory, "Manager decision");
	ActionExecutor.enterValue(querycomment, "for testing purpose");
	ActionExecutor.clickElement(queryjob);
	waitFor(2);
	Log.info("query job sucess message = " + driver.findElement(message).getText());
	ActionExecutor.clickElement(hamburgermenu);
	ActionExecutor.clickElement(logout);
	ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
	ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
	ActionExecutor.clickElement(signinbutton);
	waitFor(1);
	ActionExecutor.clickElement(searchboxicon);
	ActionExecutor.enterValue(searchjobno, OJob);
	ActionExecutor.clickElement(filterbutton);
	waitFor(1);
	if (driver.findElement(savestatus).getText().contains("Job Declined"))
		Log.info("Quote Pending Status matched!Proceed Further!!");
	else {
		Log.info("Status matching failed!!");
	}

	// -------------------Job Wastage---------------------------------------------------
	ActionExecutor.clickElement(clickonjobnoie);	
	ActionExecutor.clickElement(finalisejobbutton);
	Log.info("finalise message is = " + driver.findElement(daomessage).getText());

	// -------------Quick Search the Job for Job Complete Status---------------------------
	ActionExecutor.enterValue(quickjobsearch, OJob);
	ActionExecutor.clickElement(quicksearchhit);
	if (driver.findElement(jobcompletestatus).getText().contains("Job Completed"))
		Log.info("Job Has Been Completed!!TEST PASSED!!");
	else {
		Log.info("Job Is Still Not Complete!!TEST FAILED!!");
	}
	
	
}
    public void outsourceJobSurvey() throws InterruptedException
 {
		if (driver.findElement(savestatus).getText().contains("Preparing Quote"))
			Log.info("Preparing Quote Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		driver.findElement(markupnotes).sendKeys("test");
		ActionExecutor.clickElement(sendthequote);
		Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
		driver.findElement(selectlabel).click();
		waitFor(2);
		driver.findElement(selecttermandcondition).click();
		driver.findElement(savequoteselectionbutton).click();
		Log.info("Quote Message from client side =" + driver.findElement(successmessage).getText());
		ActionExecutor.clickElement(delegationstatus);
		ActionExecutor.clickElement(button1);
		waitFor(2);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, OJob);
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		
		if (driver.findElement(savestatus).getText().contains("Job Declined"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		ActionExecutor.clickElement(sendforapprovalbutton);
		Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
	 
			// ---------------------------Job Survey---------------------------------------------
			ActionExecutor.clickElement(jobsurveybutton);
			ActionExecutor.clickElement(submitsurveyresponse);
			ActionExecutor.clickElement(hamburgermenu);
			ActionExecutor.clickElement(logout);
			ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
			ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
			ActionExecutor.clickElement(signinbutton);

			// -------------------------Quick Search the Job for Job Complete Status----------------
			  ActionExecutor.enterValue(quickjobsearch, OJob);
			ActionExecutor.clickElement(quicksearchhit);

			if (driver.findElement(jobcompletestatus).getText().contains("Job Completed")) {
				Log.info("Job Has Been Completed!!TEST PASSED!!");
			} else {
				Log.info("Job Is Still Not Complete!!TEST FAILED!!");
			}

			Log.info("============================================");

		
 }
	public void outsourceQuoteCancel() throws InterruptedException
	{
		if (driver.findElement(savestatus).getText().contains("Preparing Quote"))
			Log.info("Preparing Quote Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		driver.findElement(markupnotes).sendKeys("test");
		ActionExecutor.clickElement(sendthequote);
		Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
		ActionExecutor.clickElement(fullspecification);
		ActionExecutor.clickElement(cancelbutton);
		//waitFor(1);
		alert = driver.switchTo().alert();
		alert.accept();
		//waitFor(2);
		ActionExecutor.enterValue(cancelcomment, "Cancel Proof for Testin");
		ActionExecutor.clickElement(cancelproof);
	//	waitFor(2);
		alert = driver.switchTo().alert();
		alert.accept();
		waitFor(2);
		Log.info("query job sucess message = " + driver.findElement(cancelmessage).getText());
		waitFor(2);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		waitFor(1);
		ActionExecutor.clickElement(searchboxicon);
		ActionExecutor.enterValue(searchjobno, OJob);
		ActionExecutor.clickElement(filterbutton);
		waitFor(1);
		if (driver.findElement(savestatus).getText().contains("Cancel Pending Approval"))
			Log.info("Quote Pending Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
	
		ActionExecutor.enterValue(quickjobsearch, OJob);
		ActionExecutor.clickElement(quicksearchhit);
		if (driver.findElement(jobcompletestatus).getText().contains("Cancel Pending Approval"))
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}
		
	}
	public void outsourceQuoteDecline()
	{
		if (driver.findElement(savestatus).getText().contains("Preparing Quote  "))
			Log.info("Preparing Quote Status matched!Proceed Further!!");
		else {
			Log.info("Status matching failed!!");
		}
		ActionExecutor.clickElement(clickonjobnoie);
		driver.findElement(markupnotes).sendKeys("test");
		ActionExecutor.clickElement(sendthequote);
		Log.info("Quote Sent Message =" + driver.findElement(daomessage).getText());
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
		ActionExecutor.clickElement(button2);
		ActionExecutor.selectValueFromOption(querycategory, "Manager decision");
		ActionExecutor.enterValue(querycomment, "for testing purpose");
		ActionExecutor.clickElement(declinequote);
		Log.info("query job sucess message = " + driver.findElement(message).getText());
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUsername, "dao@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);

		// -------------Quick Search the Job for Job Complete Status---------------------------
		ActionExecutor.enterValue(quickjobsearch, OJob);
		ActionExecutor.clickElement(quicksearchhit);
		if (driver.findElement(jobcompletestatus).getText().contains("Preparing Quote")) {
			System.out.println(jobcompletestatus);
			Log.info("Job Has Been Completed!!TEST PASSED!!");
		} else {
			Log.info("Job Is Still Not Complete!!TEST FAILED!!");
		}
		
	}


}
