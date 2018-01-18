package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import excelreader.ExcelReader;
import globalvariable.GlobalVariables;
import log.Log;





public class TestBase {
	
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream fi;
	public static WebDriver driver;
	public String startTime;
	public static int indexSI = 1;
	ExcelReader excel;
	//GlobalVariables localVar = new GlobalVariables();
	/*public void init1()
	{
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}*/
	
	public void init() throws IOException {
			    
		    /*String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);*/
			Log.info("=========== Start Script " + new Date() + "=======================");
			loadPropertiesFile();
			selectBrowser(Repository.getProperty("browser"));
			driver.get(Repository.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		   } 
	public void waitFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 3000);
 }

	public void loadPropertiesFile() throws IOException {
		PropertyConfigurator.configure(new FileInputStream(System.getProperty("user.dir") + "//src//logger.property"));
		f = new File(System.getProperty("user.dir") + "//src//main//java//config//config.properties");
		fi = new FileInputStream(f);
		Repository.load(fi);
		
		f = new File(System.getProperty("user.dir") + "//src//main//java//testData//exceldata.xlsx");
		fi = new FileInputStream(f);
		Repository.load(fi);


		}
	
	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "//src//main//java//testData//" + excelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}


	@Parameters ({"browser"})
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("ie"))
		{
			GlobalVariables.setBrowserName("Internet Explorer");
			System.out.println(System.getProperty("user.dir"));
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capability.setCapability("ignoreProtectedModeSettings", true);
			//capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			//capability.setCapability(InternetExplorerDriver.
			
			driver = new InternetExplorerDriver(capability);
			//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}	
		else if(browser.equalsIgnoreCase("chrome"))
		{
			GlobalVariables.setBrowserName("Chrome");
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
			{
			GlobalVariables.setBrowserName("Firefox");
			  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	    		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    		capabilities.setCapability("marionette", true);
	    		driver=new FirefoxDriver();
	    					
			}
			
		
		}
	
	
	}

	
	

	
	
	


