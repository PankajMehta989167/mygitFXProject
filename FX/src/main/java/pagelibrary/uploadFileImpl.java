package pagelibrary;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import executor.ActionExecutor;
import testBase.TestBase;

public class uploadFileImpl extends TestBase {

	WebDriver driver;
	By printjob = By.xpath("//*[@id='jobOption1']/div[1]/a/i");
	By startanewjob = By.cssSelector("div[id='startJob']>div>div:nth-child(1)");
	By jobdetail = By.xpath("//*[@id='printJobDetailsForm']/div[1]/div/input");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By nextmonth = By.xpath("//div[@title='Next month']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By quoterequired = By.xpath("//input[@id='quoteRequiredId']/following-sibling::label");
	By uploadfile = By.xpath("//div[@id='uploadFile']/div/div");
	By uploadframe = By.xpath("//iframe[@id='uploadframe']");
	By uploadaddbutton = By.xpath("//span[@class='btn02 addFilesLink fileinput-button']");
	
	By uploadandsavefile = By.xpath("//*[@id='startupload2']/span");
	By jobdetailsection = By.xpath("//*[@id='jobDetails']");
	By cancel_xpath=By.xpath("//*[@id='fileupload']/div[1]/div[1]/span[2]/a[2]");
	By remove_xpath=By.xpath("//script[@id='template-upload']/following-sibling::form[1]/div/div/a");
	By status_xpath=By.xpath("//td[contains(.,'Pending review')]");
	By wrong_upload_file_text_xpath=By.xpath("//*[@id='fileupload']/table/tbody/div[1]/div[4]");

	

	public uploadFileImpl(WebDriver driver) 
	{
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}
	   
	
	public void StartnewJobSection() throws InterruptedException {
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
		ActionExecutor.clickElement(highpriority);
		ActionExecutor.clickElement(quoterequired);

	}

	public void UploadFileSection() throws InterruptedException {

		
		
		driver.findElement(uploadfile).click();
		
		ActionExecutor.getFrame(uploadframe);
		
		driver.findElement(uploadaddbutton).click();
		ActionExecutor.uploadFile("assignment._PP_Assignment_15__01");
	    ActionExecutor.highLightElement(wrong_upload_file_text_xpath);
	    driver.findElement(uploadaddbutton).click();
	
	    ActionExecutor.uploadFile("Doc1.docx");	 
	    ActionExecutor.highLightElement(cancel_xpath);
		driver.findElement(cancel_xpath).click();

		driver.findElement(uploadaddbutton).click();

		ActionExecutor.uploadFile("Doc1.docx");
		driver.findElement(uploadandsavefile).click();

		driver.findElement(uploadfile).click();
     
		ActionExecutor.getFrame(uploadframe);
		waitFor(3);
		ActionExecutor.highLightElement(remove_xpath);

		ActionExecutor.clickElement(remove_xpath);
		driver.findElement(uploadaddbutton).click();
		
		ActionExecutor.uploadFile("Doc1.docx");
		driver.findElement(uploadandsavefile).click();
	
	
	       


	}

	}


