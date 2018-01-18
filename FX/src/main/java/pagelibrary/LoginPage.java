package pagelibrary;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import executor.ActionExecutor;
import log.Log;
import testBase.TestBase;

public class LoginPage extends TestBase {
	WebDriver driver;
	String str = "";
	Alert alert=null;
	//String email = "test1@est.com";
	String email = ActionExecutor.email();
	
	By fxUsername = By.xpath("//*[@id='j_username']");
	By fxPassword = By.xpath("//*[@id='j_password']");
	By rememberme = By.xpath("//label[@for='rememberMe']");
	By submitbutton = By.xpath("//*[@id='loginbtn']");
	By titlecompass = By.xpath("//*[@id='userMenu']/li[1]/a");
	By hamburgermenu = By.cssSelector("div[class='container headerStyle']>div>div:nth-child(2)>form>a");
	By logout = By.xpath("//a[contains(.,'Log out')]");
	By startJob = By.xpath("//*[@id='startJob']/div/div[1]");
	By signInlbl = By.xpath("//*[@id='maincontent']/div/div/div/div[2]/div[3]/h5/b");
	//By signInlbl = By.xpath("//img[contains(@src,'/compass/images/fx-logo.jpg')]");
	By imageLogo = By.xpath("//*[@id='outer']/div[1]/div/div[1]/a/img");
	By logindate=By.xpath("//*[@id='userMsg1']");
	By admin_xpath = By.xpath("//a[contains(.,'Admin')]");
	By manage_client_contract_xpath = By.xpath("//div[@id='clientcontract']/div/div[1]");
	By manage_client_user = By.xpath("//a[contains(.,'Manage client users')]");
	By adminemail=By.xpath("//*[@id='username']");
	By Search =By.xpath("//a[contains(.,'Search')]");
	By Login =By.xpath("//a[contains(.,'Login')]");
	By modify=By.xpath("//a[contains(.,'Modify')]");
	By disable =By.xpath("//a[contains(.,'Disable')]");
	By enable =By.xpath("//a[contains(.,'Enable')]");
	By switchback =By.xpath("//a[contains(.,'Switch back')]");
	By Validationmesg =By.xpath("//form[@id='loginForm']");
	By unsuccessfulylogindate=By.xpath("//*[@id='userMsg2']");
	By forgotpassword=By.xpath("//*[@id='forgottonpasswordlink']");
	By forgotemail=By.xpath("//*[@id='username']");
	By requestpassword=By.xpath("//*[@id='requestpasswordbtn']");
	By messagereqpwd=By.xpath("//*[@id='loginForm']");	
	By report =By.xpath("//a[contains(.,'Reports')]");
	//By report1=By.xpath("//*[@id='Outsource Client Reports']");
	By report1=By.xpath("//*[@id='Outsource Client Reports']/div/div[1]");
	//By report2=By.xpath("//*[@id='Client Cost Recovery and Invoice Support Reports']");
	By report2=By.xpath("//*[@id='Client Cost Recovery and Invoice Support Reports']/div/div[1]");
	
	By report3=By.xpath("//*[@id='Client Analytical Reports']");
	By report4=By.xpath("//*[@id='Internal Analytical Reports']");
	By report5=By.xpath("//*[@id='Internal/External Cost Recovery and Invoice Support Reports']");
	By report6=By.xpath("//*[@id='Internal/External Invoice Support Reports']");
	By addnewuser=By.xpath("//a[contains(.,'Add new user')]");
	By contract_xpath = By.xpath("//*[@name='contract']");
	By firstadduser=By.xpath("//*[@name='firstName']");
	By lastadduser=By.xpath("//*[@name='lastName']");
	By emailadduser=By.xpath("//*[@name='username']");
	By newpwd=By.xpath("//*[@id='newPassword']");
	By confirmpwd=By.xpath("//*[@id='confirmPassword']");
	By modifybtn=By.xpath("//*[@id='users']/tbody/tr[1]/td[4]/button[1]");
	By disablebtn=By.xpath("//*[@id='users']/tbody/tr[1]/td[4]/button[2]");
	By savechanges=By.xpath("//a[contains(.,'Save changes')]");
	By addnewusermessage=By.xpath("//form[@id='userFormAdmin']/div/div/div[2]");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ActionExecutor.setDriver(driver);

	}

	/**
	 * @param username
	 * @param password
	 * @throws AWTException 
	 * @throws InterruptedException 
	 */
	public void signIn(String username, String password) throws AWTException, InterruptedException {
		ActionExecutor.enterValue(fxUsername, username);
		ActionExecutor.enterValue(fxPassword, password);
		ActionExecutor.clickElement(submitbutton);
		ActionExecutor.clickElement(hamburgermenu);
		waitFor(1);
		
		if (driver.findElement(titlecompass).getText().contains("Client")){
			Log.info("Client Manager logged in successfully!");
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
			Log.info("Not a Client Manager!Fail!!");
		}

	}
	

	public void signInPrintManager() throws Exception {

		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(submitbutton);
		ActionExecutor.clickElement(hamburgermenu);
		waitFor(1);
		if (driver.findElement(titlecompass).getText().contains("Print Manager")){
			Log.info("Print Manager logged in successfully!");
			WebElement elem = driver.findElement(imageLogo);
			Thread.sleep(1000);
			if(Repository.getProperty("browser").equalsIgnoreCase("ie"))
			{
				elem.click();
				ActionExecutor.clickElement(hamburgermenu);
				driver.findElement(admin_xpath).click();
			}
			else
			{
				driver.findElement(admin_xpath).click();
		}
		}
		else {
			Log.info("Not a Print Manager!Fail!!");
		}
		
		ActionExecutor.clickElement(manage_client_contract_xpath);
		ActionExecutor.clickElement(manage_client_user);
		driver.findElement(adminemail).sendKeys("client@_selenium.test.com");
		driver.findElement(Search).click();
		driver.findElement(Login).click();
		
		ActionExecutor.clickElement(hamburgermenu);
		waitFor(1);
		if (driver.findElement(titlecompass).getText().contains("emulating")){
			Log.info("Print Manager as a Client logged in!");
			WebElement elem = driver.findElement(imageLogo);
			Thread.sleep(1000);
			if(Repository.getProperty("browser").equalsIgnoreCase("ie"))
			{
				elem.click();
			}
			else
			{
				driver.findElement(switchback).click();
		}
		}
		else {
			Log.info("Not a Print Manager!Fail!!");
		}
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		
		
	}

	public void invalidPassword()
	{
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, "P@ssword");
		ActionExecutor.clickElement(submitbutton);
		String validationmessage=driver.findElement(Validationmesg).getText();
		System.out.println(validationmessage);
		
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(submitbutton);
		String Unsuccessfullogindatew = driver.findElement(unsuccessfulylogindate).getText();
		System.out.println(Unsuccessfullogindatew);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		
	}
	
	public void invalidUserName()
	{
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.comm");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(submitbutton);
		String validationmessage=driver.findElement(Validationmesg).getText();
		System.out.println(validationmessage);
		
		ActionExecutor.enterValue(fxUsername, "client@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(submitbutton);
		String Unsuccessfullogindatew = driver.findElement(unsuccessfulylogindate).getText();
		System.out.println(Unsuccessfullogindatew);
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
	}
	
	public void verifyForgotPassword()
	{
	driver.findElement(forgotpassword).click();
	driver.findElement(forgotemail).sendKeys("swati.sharma@espire.com");
	driver.findElement(requestpassword).click();
	ActionExecutor.highLightElement(Validationmesg);
	String validationmessage=driver.findElement(Validationmesg).getText();
	System.out.println(validationmessage);
	
	driver.findElement(forgotpassword).click();
	driver.findElement(forgotemail).sendKeys("swati.sharma@espire.c");
	driver.findElement(requestpassword).click();
	ActionExecutor.highLightElement(Validationmesg);
	
	//driver.findElement(forgotpassword).click();
	//driver.findElement(forgotemail).sendKeys("  ");
	//driver.findElement(requestpassword).click();
	//alert = driver.switchTo().alert();
	//String alertmsg = alert.getText();
	//System.out.println(alertmsg);
	//alert.accept();
	
	}
	
	public void verifyReportSection() throws InterruptedException
	{
		ActionExecutor.enterValue(fxUsername, "printmgr@_selenium.test.com");
		ActionExecutor.enterValue(fxPassword, Repository.getProperty("fxPassword"));
		ActionExecutor.clickElement(submitbutton);
		ActionExecutor.clickElement(hamburgermenu);
		waitFor(2);
		driver.findElement(report).click();
		ActionExecutor.highLightElement(report1);
		ActionExecutor.highLightElement(report2);
		ActionExecutor.highLightElement(report3);
		ActionExecutor.highLightElement(report4);
		ActionExecutor.highLightElement(report5);
		ActionExecutor.highLightElement(report6);
		
		
		
	}
	
	public void verifyAddNewUser() throws InterruptedException
	{
		ActionExecutor.clickElement(hamburgermenu);
		waitFor(2);
		driver.findElement(admin_xpath).click();
		ActionExecutor.clickElement(manage_client_contract_xpath);
		ActionExecutor.clickElement(manage_client_user);
	driver.findElement(addnewuser).click();
	Select contractnumber = new Select(driver.findElement(contract_xpath));
	contractnumber.selectByVisibleText("Selenium Auto Test - D210");
	waitFor(2);
	driver.findElement(firstadduser).sendKeys("test first name");
	driver.findElement(lastadduser).sendKeys("test last name");
	
	driver.findElement(emailadduser).sendKeys(email);
	driver.findElement(newpwd).sendKeys("Test@123");
	driver.findElement(confirmpwd).sendKeys("Test@123");
	driver.findElement(savechanges).click();
	String message1=driver.findElement(addnewusermessage).getText();
	System.out.println(message1);
	
	driver.findElement(adminemail).sendKeys(email);
	driver.findElement(Search).click();
	driver.findElement(modify).click();
	driver.findElement(savechanges).click();
	String message2=driver.findElement(addnewusermessage).getText();
	System.out.println(message2);
	driver.findElement(adminemail).sendKeys(email);
	driver.findElement(Search).click();
	driver.findElement(disable).click();
	alert = driver.switchTo().alert();
	alert.accept();
	waitFor(2);
	driver.findElement(adminemail).sendKeys(email);
	driver.findElement(Search).click();
	driver.findElement(enable).click();
	waitFor(4);
	driver.findElement(adminemail).sendKeys(email);
	driver.findElement(Search).click();
	String str = driver.findElement(disable).getText();
	if (str.equals("Disable"))
	Log.info("User is enabled");
		else	{
		System.out.println("User is not enabled");
	}
	
	
	}
	public void signout() throws Exception {
		ActionExecutor.clickElement(hamburgermenu);
		ActionExecutor.clickElement(logout);
		String signout = driver.findElement(signInlbl).getText();
		if (signout.equals("Sign in"))
			Log.info("User Successfully Logged Out");
		else {
			System.out.println("User Login Failed");
		}
	}

}
