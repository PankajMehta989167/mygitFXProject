package executor;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalvariable.GlobalVariables;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import log.Log;
import report.ReportBean;
import testBase.TestBase;

/**
 * @author mohammad.makki
 *
 */
public class ActionExecutor {
	private static WebDriver driver = null;
	private static WebElement webElem = null;
	private static ReportBean reportBean = new ReportBean();

	//Getters and setters
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		ActionExecutor.driver = driver;
	}


	/**
	 * @param locator
	 * @return
	 * @throws Exception
	 * 
	 * Method is used for finding the web element on the page of given locator
	 */
	public static WebElement findelement(By locator) throws Exception {
		try {
			Thread.sleep(300);
			//driver will wait for the specific given time if locator is not present on the page
			WebDriverWait wait = new WebDriverWait(driver, 60);
			webElem = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (null != webElem) {
				/*if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'", webElem);
				}*/
				//if (!webElem.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);
					/*((JavascriptExecutor)driver)
					.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,"
							+ "document.body.scrollHeight,document.documentElement.clientHeight));");*/
					//new Actions(driver).moveToElement(webElem).perform();
				//}
			}
			return webElem;
		} catch (Exception ex2) {
			return null;
		}
	}
	
	/**
	 * @param locator
	 * @param value
	 * Method for entering Value into the given textbox
	 */
	public static void enterValue(By locator, String value) {
		try {
			findelement(locator);
			if (null != webElem) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);
				webElem.click();
				webElem.clear();
				if (!value.isEmpty()) {
					webElem.sendKeys(value);
					setReportVariables("Enter", "Passed", value + " has been entered");
					Log.info(value + " has been entered");
				} else {
					setReportVariables("Enter", "Failed", value + " has not been entered");
					Log.error(value + " has not been entered");
				}

			} else {
				setReportVariables("Enter", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {
			setReportVariables("Enter", "Failed", "Exception in entering value");
			Log.error("Exception in entering value: " + e.getMessage());
		}
	}

	/**
	 * @param locator
	 * 
	 * Clicking the given locator
	 */
	public static void clickElement(By locator) {
		try {
			String strEvent = "";
			findelement(locator);
			if (null != webElem) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);
				strEvent = webElem.getText();
				/*Actions xAct = new Actions(driver);
				xAct.moveToElement(webElem);
				xAct.click().build().perform();*/
				//xAct.build().perform();
				Thread.sleep(500);
				if(TestBase.Repository.getProperty("browser").equalsIgnoreCase("ie"))
					webElem.click();
				else
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElem);
				if (strEvent.isEmpty()) {
					setReportVariables("Click", "Passed", "event has been clicked");
					Log.info("event has been clicked");
				} else {
					setReportVariables("Click", "Passed", strEvent + " has been clicked");
					Log.info(strEvent + " has been clicked");
				}
			} else {
				setReportVariables("Click", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {
			setReportVariables("Click", "Failed", "event has not been clicked" + e.getMessage());
			Log.info("event has been clicked" + e.getMessage());
		}

	}


	/**
	 * @param locator
	 * @param strValue
	 * Method is used for selecting the value from the dropdown if there is option tag is present
	 */
	public static void selectValueFromOption(By locator, String strValue) {
		try {
			boolean bflag = true;
			findelement(locator);
			if (null != webElem) {
				List<WebElement> listboxitems = webElem.findElements(By.tagName("option"));
				for (WebElement opt : listboxitems) {
					if (opt.getText().contains(strValue)) {
						opt.click();
						bflag = false;
						setReportVariables("Select", "Passed", "Value has been select from dropdown" + strValue);
						Log.info("Value has been select from dropdown" + strValue);
						break;
					}
				}
				if (bflag) {
					setReportVariables("Select", "Failed", "Value has not selected from dropdown" + strValue);
					Log.info("Value has not selected from dropdown" + strValue);
				}
			} else {
				setReportVariables("Select", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {
			setReportVariables("Select", "Failed",
					strValue + " has not been selected from dropdown due to exception" + e.getMessage());
			Log.info(strValue + " has not been selected from dropdown due to exception" + e.getMessage());
		}
	}

	/**
	 * @param locator
	 * @param strListValues
	 * 
	 * Method is for selecting multiple values from the list
	 */
	public static void selectFromList(By locator, String strListValues) {
		try {
			findelement(locator);
			if (null != webElem) {
				final String[] strValues = strListValues.split(",");
				List<WebElement> listboxitems = webElem.findElements(By.tagName("option"));
				final Select chooseoptn = new Select(webElem);
				chooseoptn.deselectAll();
				listboxitems.stream().forEachOrdered(opt -> {
					for (String strValue : strValues) {
						if (opt.getText().equalsIgnoreCase(strValue)) {
							chooseoptn.selectByVisibleText(opt.getText());
						}
					}
				});
				setReportVariables("Select", "Passed", strListValues + " Values has been selected from list");
				Log.info("Values has been selected from list");
			} else {
				setReportVariables("Select", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @param locator
	 * @param strValue
	 * 
	 * Method is used for selecting from span drop down
	 */
	public static void selectFromSpanDropDown(By locator, String strValue) {
        try {
               findelement(locator);
               if (null != webElem) {
                     List<WebElement> elements = webElem.findElements(By.tagName("li"));
                     elements.stream().forEach(element -> {
                            String strElemt = "";
                            try {
                                   Thread.sleep(100);
                                   if(null != element.getText() && !element.getText().isEmpty()) {
                                          strElemt = element.getText();
                                   }else if(null != element.getAttribute("innerText") && !element.getAttribute("innerText").isEmpty()) {
                                          strElemt = element.getAttribute("innerText");
                                   }
                                   if (!strElemt.isEmpty() && strElemt.equalsIgnoreCase(strValue)) {
                                          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                                          ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
                                          setReportVariables("Select", "Passed", "Value has been select from dropdown" + strValue);
                                          Log.info("Value has been select from dropdown" + strValue);
                                   }
                            } catch (StaleElementReferenceException stateElemExp) {
                                   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                                   ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
                                   setReportVariables("Select", "Passed", "Value has been select from dropdown" + strValue);
                                   Log.info("Value has been select from dropdown" + strValue);
                            } catch (InterruptedException e) {
                                   e.printStackTrace();
                            }
                     });
               } else {
                     setReportVariables("Select", "Failed", "Element is missing");
                     Log.info("Element is missing");
               }
        } 
        catch (Exception e) 
        {
             //  setReportVariables("Select", "Failed",
               //             strValue + " has not been selected from dropdown due to exception" + e.getMessage());
               //Log.info(strValue + " has not been selected from dropdown due to exception" + e.getMessage());
        }
 }


	
	/**
	 * @param locator
	 * 
	 * Method is for identifying the frame on the page
	 */
	public static void getFrame(By locator) {
		try {
			findelement(locator);
			if (null != webElem) {
				driver.switchTo().frame(webElem);
				setReportVariables("Frame", "Passed", "Frame identified");
				Log.info("Frame identified");
			} else {
				setReportVariables("Frame", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {
			setReportVariables("Frame", "Failed", "Frame has not identified");
			Log.info("Frame has not identified");
		}
	}

	/**
	 * @param strKey
	 * @param strValue
	 * 
	 * Method is for storing the text value into given key
	 * Use if want to store known value and want to use it
	 * @throws InterruptedException 
	 */
	public static void storeValue(String strKey, String strValue) throws InterruptedException {
		Thread.sleep(1000);
		if (!strKey.isEmpty() && !strValue.isEmpty()) {
			GlobalVariables.getMap().put(strKey, strValue);
			setReportVariables("Store", "Passed", strValue + " has been stored into " + strKey);
			Log.info(strValue + " has been stored into " + strKey);
		}
	}

	/**
	 * @param locator
	 * @param strKey
	 * 
	 * Method is for storing the web element value into given key
	 */
	public static void storeValue(By locator, String strKey) {
		try {
			findelement(locator);
			if (null != webElem && !strKey.isEmpty()) {
				GlobalVariables.getMap().put(strKey, webElem.getText());
				Thread.sleep(500);
				setReportVariables("Store", "Passed", webElem.getText() + " has been stored into " + strKey);
				Log.info(webElem.getText() + " has been stored into " + strKey);
			}
		} catch (Exception e) {
			setReportVariables("Store", "Failed", webElem.getText() + " has been stored into " + strKey);
			Log.error(webElem.getText() + " has been stored into " + strKey);
		}
	}

	/**
	 * @param strKey
	 * @return
	 * 
	 * Method is for get the store value by the given key
	 * @throws InterruptedException 
	 */
	public static String getValue(String strKey) throws InterruptedException {
		Thread.sleep(1000);
		String strGetvalue = "";
		if (!strKey.isEmpty()) {
			strGetvalue = GlobalVariables.getMap().get(strKey);
			Log.info(strGetvalue + " has been retrieve of key: " + strKey);
		}
		return strGetvalue;
	}

	/**
	 * @param files
	 * 
	 * Method is used for uploading the files.
	 * If multiple files is required to upload
	 * pass the files name with comma separated ("abc.docs,zyx.docs")
	 */
	public static void uploadFile(String files) {
		try {
			Robot robot = new Robot();
			String uploadFile = "";
			String fileUpload = new File("UploadFiles").getAbsolutePath();
			String[] strFiles = files.split(",");
			if (strFiles.length > 1) {
				for (String strFile : strFiles) {
					if (uploadFile.isEmpty()) {
						uploadFile = " \"" + fileUpload + "\\" + strFile + "\"";
					} else {
						uploadFile = uploadFile + " \"" + fileUpload + "\\" + strFile + "\"";
					}
				}
			} else {
				uploadFile = fileUpload + "\\" + strFiles[0];
			}
			uploadFile = uploadFile.replace("\\", File.separator);
			//if (new File(uploadFile).exists()) {
				Thread.sleep(1000);
				StringSelection strSelection = new StringSelection(uploadFile);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				setReportVariables("Upload", "Passed", uploadFile + " File/Files uploaded successfully!");
				Log.info(uploadFile + " File/Files uploaded successfully!");
			//} else {
				//robot.keyPress(KeyEvent.VK_ESCAPE);
				//robot.keyRelease(KeyEvent.VK_ESCAPE);
				//setReportVariables("Upload", "Failed", "File path is not correct");
				//Log.info("File path is not correct");
			//}
		} catch (Exception e) {
			setReportVariables("Upload", "Failed", "Uploading files are failed");
			Log.info("Uploading files are failed");
		}
	}

	/**
	 * @param tableLocator
	 * @param cellData
	 * @param clickIndex
	 * @param clickColumnNo
	 * 
	 * Method is for clicking a button on table with the reference of given row text
	 */
	public static void clickOnTableElement(By tableLocator, String cellData, int clickIndex, int clickColumnNo) {
        try {
               String elementText = "";
               boolean bflag = true;
               List<WebElement> colelements;
               findelement(tableLocator);
               if (null != webElem) {
                     List<WebElement> rows = webElem.findElements(By.tagName("tr"));
                     for (int i = 0; i < rows.size(); i++) {
                            if(!bflag) {
                                   break;
                            }
                            if (rows.get(i).isDisplayed()) {
                                   colelements = rows.get(i).findElements(By.tagName("td"));
                                   if (colelements.size() > (clickColumnNo - 2) && colelements.size() > 0) {
                                          for (int columns = 0; columns < colelements.size(); columns++) {
                                                 if(!bflag) {
                                                        break;
                                                 }
                                                 elementText = colelements.get(columns).getText();
                                                 if (!elementText.isEmpty() && elementText.equalsIgnoreCase(cellData)) {
                                                        if (clickIndex > 0)
                                                               colelements.get(clickColumnNo - 1).findElements(By.xpath(".//*"))
                                                                            .get(clickIndex-1).click();
                                                        else
                                                               colelements.get(clickColumnNo - 1).click();
                                                        setReportVariables("Click", "Passed", "Element is clicked on table");
                                                        Log.info("Element is clicked");
                                                        bflag = false;
                                                        //break;
                                                 }
                                          }
                                   }
                            }
                     }
               } else {
                     setReportVariables("Click", "Failed", "Element is missing");
                     Log.info("Element is missing");
               }
        } catch (Exception ex) {
               setReportVariables("Click", "Failed", "Exception occure in clicking in table " + ex.getMessage());
               Log.info("Exception occure in clicking in table " + ex.getMessage());
        }
 }


	
	/**
	 * @param locator
	 * @param strValue
	 * 
	 * Method is used for checking the visibility of the given web element for expected result
	 */
	public static void getDisplay(By locator, String strValue) {
		try {
			findelement(locator);
			if (null != webElem) {
				if (strValue.equalsIgnoreCase(webElem.getText())) {
					setReportVariables("Visible", "Passed", strValue + " is Displaying");
					Log.info(strValue + " is Displaying");
				} else {
					setReportVariables("Visible", "Failed", strValue + " is not Displaying");
					Log.info(strValue + " is not Displaying");
				}
			} else {
				setReportVariables("Visible", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception ex) {
			setReportVariables("Visible", "Failed", "Exception occure in displaying element " + ex.getMessage());
			Log.info("Exception occure in displaying element " + ex.getMessage());
		}
	}
	/**
	 * @param status
	 * @param result
	 * 
	 * Values storing into the report variable
	 */
	public static void setReportVariables(String action, String status, String result) {
		reportBean.setResult(result);
		reportBean.setStatus(status);
		reportBean.setStrAction(action);
		GlobalVariables.getReportList().add(new ReportBean(reportBean));
	}
	public static void doubleClickElement(By locator) {
		try {
			String strEvent = "";
			findelement(locator);
			if (null != webElem) {
				strEvent = webElem.getText();
				Thread.sleep(500);
				Actions xAct = new Actions(driver);
				xAct.moveToElement(webElem);
				xAct.doubleClick().build().perform();
				//xAct.build().perform();
				Thread.sleep(1000);
				//webElem.;
				if (strEvent.isEmpty()) {
					setReportVariables("Click", "Passed", "event has been clicked");
					Log.info("event has been clicked");
				} else {
					setReportVariables("Click", "Passed", strEvent + " has been clicked");
					Log.info(strEvent + " has been clicked");
				}
			} else {
				setReportVariables("Click", "Failed", "Element is missing");
				Log.info("Element is missing");
			}
		} catch (Exception e) {
			setReportVariables("Click", "Failed", "event has not been clicked" + e.getMessage());
			Log.info("event has been clicked" + e.getMessage());
		}

	}
	public static void highLightElement(By locator) {
		try {
			String strHighlight = "";
			findelement(locator);
			if (null != webElem) {
				strHighlight = webElem.getText();
				if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'",
							webElem);
					setReportVariables("Visible", "Passed", strHighlight + " is Displaying");
					Log.info(strHighlight + " is Displaying");
				}
			} else {
				setReportVariables("Visible", "Failed", "Element is missing");
				Log.info("Element is missing");
			}

		} catch (Exception ex) {
			setReportVariables("Visible", "Failed", "Element is missing" + ex.getMessage());
			Log.info("Element is missing" + ex.getMessage());
		}
	}
	public static String randomFirstName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		return person.firstName();
	}
	public static String randomName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		return person.fullName();
	}
	public static String email() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		return person.email();
	}
	
}
