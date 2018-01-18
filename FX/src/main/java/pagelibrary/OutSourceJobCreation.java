package pagelibrary;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import executor.ActionExecutor;
import org.openqa.selenium.support.ui.Select;
import log.Log;
import testBase.TestBase;

public class OutSourceJobCreation extends TestBase {

	WebDriver driver;
	String OJob="SAT000051423-1";
	By others_xpath = By.xpath("//div[@id='jobOption1']/div[3]/a/i");
	By outsource_xpath = By.xpath("//div[@id='jobOption0']/div[1]/a/i");
	By jobdetail = By.xpath("//input[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
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
	By quantity = By.xpath("//*[@name='quantity']");
	//By quantity_xpath = By.xpath("//input[@id='quantity']");
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
	By green_tick_image_xpath=By.xpath("//input[@type='image']");     
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
	
			
	public OutSourceJobCreation(WebDriver driver) 
	{
		this.driver = driver;
		driver.manage().window().maximize();
		ActionExecutor.setDriver(driver);

	}

	public void outsourceJobCreation() throws IOException, InterruptedException
	{
		
		ActionExecutor.clickElement(startanewjob);  
		ActionExecutor.clickElement(others_xpath); 
	    ActionExecutor.clickElement(outsource_xpath); 
		ActionExecutor.enterValue(jobdetail, Repository.getProperty("jobdetail"));
		ActionExecutor.enterValue(jobreference, Repository.getProperty("jobreference"));
		ActionExecutor.enterValue(projectcode, Repository.getProperty("projectcode"));
		ActionExecutor.enterValue(job_description_xpath, "outsource job description");
		ActionExecutor.enterValue(campaign_xpath, "outsource campaign");
		ActionExecutor.enterValue(product_code_xpath, "outsource projectcode");
		ActionExecutor.clickElement(high_priprity_pleasenote_xpath);
		ActionExecutor.clickElement(fsc_coc_xpath);
		ActionExecutor.enterValue(quantityone_xpath, "1238");
		ActionExecutor.enterValue(quantitytwo_xpath, "1235");
		ActionExecutor.enterValue(quantitythree_xpath, "12356");
		ActionExecutor.enterValue(quantityfour_xpath, "1458");
		ActionExecutor.enterValue(quantityfive_xpath, "12");
		ActionExecutor.enterValue(quantityfive_xpath, "78");
		ActionExecutor.enterValue(quantitysix_xpath, "78");
		ActionExecutor.clickElement(flexispec_xpath);
	    Select jobtype = new Select(driver.findElement(job_type_selection_xpath));
	    jobtype.selectByVisibleText("Brochures");
	  	ActionExecutor.enterValue(pagination_no_ofpanels_xpath, "78");
	  	ActionExecutor.clickElement(other_xpath);
	    ActionExecutor.enterValue(other_box_xpath, "otherdata");
	    ActionExecutor.clickElement(black_inks_xpath);
	    ActionExecutor.clickElement(delivery_details_xpath);
	    ActionExecutor.enterValue(customer_name_xpath, "customer name test");
	    ActionExecutor.enterValue(contact_name_xpath, "contactnametest");
	    ActionExecutor.enterValue(phone_xpath, "1254");	
	    ActionExecutor.enterValue(address_one_xpath, "test addess one"); 
	    ActionExecutor.enterValue(address_two_xpath, "textaddresstwo");
	    ActionExecutor.enterValue(city_xpath, "sydney");
	    ActionExecutor.enterValue(postcode_xpath, "3000");
	    ActionExecutor.enterValue(note_xpath, "test note");
        Select deliverymethod = new Select(driver.findElement(delivery_method_xpath));
	    deliverymethod.selectByVisibleText("Courier");
		ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
		waitFor(2);
	    ActionExecutor.clickElement(addbutton_delivery_xpath);
	    ActionExecutor.highLightElement(delete_button_xpath);	       
	    ActionExecutor.clickElement(submitbutton_xpath);
	    ActionExecutor.clickElement(submit_job_xpath);
	    ActionExecutor.highLightElement(job_number_submit_job_xpath);
	    ActionExecutor.storeValue(jobnumber, "jobno");
	    ActionExecutor.clickElement(hamburgermenu);
	    ActionExecutor.clickElement(logout);	         
	    ActionExecutor.enterValue(FXusername, "dao@_selenium.test.com");
	    ActionExecutor.enterValue(FXpassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
        ActionExecutor.clickElement(searchboxicon_xpath);
	     ActionExecutor.enterValue(jobno_xpath, ActionExecutor.getValue("jobno"));
	     ActionExecutor.clickElement(filter_xpath);
	     String Pendingstatus = driver.findElement(status_xpath).getText();

			if (Pendingstatus.contains("Pending review "))
				Log.info("Job Review Status matched!Proceed Further!!");
			else {
				Log.info("Status matching failed!!");
			}
	     ActionExecutor.clickElement(first_job_number_xpath);
	     ActionExecutor.clickElement(i_am_done_proceed_xpath);
	     ActionExecutor.clickElement(request_quote_from_p3_xpath);
	     ActionExecutor.clickElement(fujilogo);
	     ActionExecutor.clickElement(searchboxicon_xpath);
	     Thread.sleep(5000);
	     driver.navigate().refresh();
	     ActionExecutor.clickElement(searchboxicon_xpath);
	    ActionExecutor.enterValue(jobno_xpath, ActionExecutor.getValue("jobno"));      
	     ActionExecutor.clickElement(filter_xpath);
	     WebElement image1 = driver.findElement(green_tick_image_xpath);
	 //    Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image1);
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
	
	
}
