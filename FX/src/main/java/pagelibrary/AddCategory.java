package pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import executor.ActionExecutor;
import testBase.TestBase;

public class AddCategory extends TestBase {

	WebDriver driver;
	String randomFirstName = ActionExecutor.randomFirstName();
	
	By fxUserName = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By submitbutton = By.xpath("//*[@id='loginbtn']");
    By hamburgermenu_xpath = By.xpath("//input[@id='searchJobno']/following-sibling::a");
	By admin_xpath = By.xpath("//a[contains(.,'Admin')]");
	By manage_client_contract_xpath = By.xpath("//div[@id='clientcontract']/div/div[1]");
	By manage_catalogue_items_xpath = By.xpath("//a[contains(.,'Manage catalogue items')]");
	By contract_xpath = By.xpath("//*[@id='contractId']");
	By add_new_category_xpath = By.xpath("//a[contains(.,'Add new category')]");
	By add_catalogue_category_xpath = By.xpath("//*[@id='name']");
	By save_change_xpath = By.xpath("//a[contains(.,'Save changes')]");
	By table_admin_xpath = By.xpath("//table[@id='item']");
	By thumbnail_xpath = By.xpath("//input[@id='file3']");
	By template_name_xpath = By.xpath("//*[@id='name']");
	By template_description_xpath = By.xpath("//*[@id='description']");
	//By number_of_impression_xpath = By.xpath("//*[@id='impressions']");
	By impression = By.xpath("//*[@id='impressions']");
	By add_impression_xpath = By.xpath("//*[@id='catalogueItemForm']/div/div/div[15]/div/div[1]/div[2]/div[5]/input");
	By save_changes_xpath = By.xpath("//a[contains(.,'Save changes')]");
	By category_selection_xpath = By.xpath("//form[@id='catalogueJobDetailsForm']/div[10]/div/div/input");
	By item_selection_xpath = By.xpath("//form[@id='catalogueJobDetailsForm']/div[11]/div[1]/div/input");
	By jobdetail = By.xpath("//input[@name='name']");
	By jobreference = By.xpath("//*[@name='clientJobId']");
	By projectcode = By.xpath("//*[@name='projectCode']");
	By catalogue_quote_required_xpath = By.xpath("//label[@for='quoteRequired']");
	By category_selection_options_xpath = By
			.xpath("//ul[@id='select-options-6788b685-03d9-baf8-ef1c-fae2f0321834']/li/span");
	By item_selection_options_xpath = By
			.xpath("//ul[@id='select-options-64246de7-e077-30ca-ed7c-f6b215a5dc3d']/li/span");
	By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
	By signinbutton = By.xpath("//*[@id='loginbtn']");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By startanewjob = By.xpath("//*[@id='startJob']/div/div[1]");
	By duedate = By.xpath("//*[@id='dueDate_Date']");
	By due_time_xpath = By.xpath("//input[@id='dueDate_Time']");
	By due_time_options_xpath = By.xpath("//li[@class='ui-menu-item']");
	By duedateselect = By.xpath("//*[@id='dueDate_Date_table']/tbody/tr[3]/td[4]/div");
	By highpriority = By.cssSelector("div[class='col s12']>label");
	By others_xpath = By.xpath("//div[@id='jobOption1']/div[3]/a/i");
	By catalogue_xpath = By.xpath("//div[@id='jobOption0']/div[2]/a/i");
	By nextmonth = By.xpath("//div[@title='Next month']");
	 By categorydropdown = By.xpath("//*[@id='catalogueJobDetailsForm']/div[10]/div/div/input");
		By categoryhelomoto = By.xpath("//*[@id='catalogueJobDetailsForm']/div[10]/div/div/ul");
		By itemdropdown = By.xpath("//*[@id='catalogueJobDetailsForm']/div[11]/div[1]/div/input");
		By itemdropdownitem = By.xpath("//*[@id='catalogueJobDetailsForm']/div[11]/div[1]/div/ul");
		By quoterequired = By.xpath("//input[@id='quoteRequired']/following-sibling::label");
		By quantity = By.xpath("//*[@name='quantity']");
		By estimate = By.xpath("//*[@id='total']");
	/**
	 * @param driver
	 */
	public AddCategory(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);
	}

	/**
	 * @throws InterruptedException
	 */
	public void addcat() throws InterruptedException {
		ActionExecutor.enterValue(fxUserName, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(admin_xpath);
		ActionExecutor.clickElement(manage_client_contract_xpath);
		ActionExecutor.clickElement(manage_catalogue_items_xpath);
		Select contractnumber = new Select(driver.findElement(contract_xpath));
		contractnumber.selectByVisibleText("Selenium Auto Test - D210");
		Thread.sleep(3000);
		ActionExecutor.clickElement(add_new_category_xpath);
		/**
		 * @randomeFirstName : To generate random value while adding a new category !!
		 * 		 
		 * 
		 */
		ActionExecutor.enterValue(add_catalogue_category_xpath, randomFirstName);
		System.out.println(randomFirstName);

		ActionExecutor.clickElement(save_change_xpath);
		waitFor(1);
		ActionExecutor.clickOnTableElement(table_admin_xpath, randomFirstName, 1, 4);
		ActionExecutor.clickElement(add_new_category_xpath);
		ActionExecutor.enterValue(template_name_xpath, "Test Template");
		ActionExecutor.enterValue(template_description_xpath, "Test Template description");
		waitFor(3);
		driver.findElement(thumbnail_xpath).click();
		waitFor(2);
		ActionExecutor.uploadFile("Doc1.docx");
		waitFor(3);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(impression));
		waitFor(2);
		driver.findElement(impression).sendKeys(Repository.getProperty("impression"));
	//	driver.findElement(impression).sendKeys("1000");
	//	ActionExecutor.enterValue(number_of_impression_xpath, "1000");
		//waitFor(1);
		ActionExecutor.clickElement(add_impression_xpath);
		ActionExecutor.clickElement(save_changes_xpath);
		ActionExecutor.clickElement(hamburgermenu_xpath);
		ActionExecutor.clickElement(logout);
		ActionExecutor.enterValue(fxUserName, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(signinbutton);
		ActionExecutor.clickElement(startanewjob);
		ActionExecutor.clickElement(others_xpath);
		driver.findElement(catalogue_xpath).click();
		//ActionExecutor.clickElement(catalogue_xpath);
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
		ActionExecutor.clickElement(categorydropdown);
		waitFor(2);
		ActionExecutor.selectFromSpanDropDown(categoryhelomoto, randomFirstName);
		System.out.println("same category has been selected");
		ActionExecutor.clickElement(itemdropdown);
		waitFor(2);
		ActionExecutor.selectFromSpanDropDown(itemdropdownitem, "Test Template");
		waitFor(1);
		ActionExecutor.enterValue(quantity, Repository.getProperty("quantity"));
		//ActionExecutor.enterValue(categoryquantity, "10");
		waitFor(1);
		String est = driver.findElement(estimate).getText();
		System.out.print(est);

	}

}
