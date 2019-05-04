package com.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getBrowserLaunch(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\pavithra\\eclipse-workspace\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"E:\\Selenium\\Workspace\\Selenium7amBatch\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Not a valid BrowserName");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Invalid url format");
		}
	}

	public static void waitforVisibilityOfWebelement(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static boolean isDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean isEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void elementInputFeildClear(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void inputValuestoWebPage(WebElement element, String value) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			boolean displayed = isDisplayed(element);
			boolean enabled = isEnabled(element);
			if (displayed && enabled) {
				elementInputFeildClear(element);
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void elementClick(WebElement element) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			if (isDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getText(WebElement element) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getAttribute(WebElement element, String attributeName) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			String attribute = element.getAttribute(attributeName);
			return attribute;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void browserNavigation(String options) {
		try {
			if (options.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (options.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (options.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (options.contains("to")) {
				// String[] split = options.split("=");
				String substring = options.substring(3);
				driver.navigate().to(substring);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectValuesFromDD(WebElement element, String options, String value) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			Select sc = new Select(element);
			if (options.equalsIgnoreCase("visibleText")) {
				sc.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (options.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mouseHovertoElement(WebElement element) {
		try {
			waitforVisibilityOfWebelement(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendKeysUsingActions(WebElement element, String value) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollUpandDownUsingElement(WebElement element) {
		try {
			waitforVisibilityOfWebelement(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollUsingCoOrdinates(String width, String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrolltoBottomOfThePage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void takeScreenShot(String fileName) throws IOException {
		try {
			File f = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+fileName+".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, f);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static void dragAndDrop(WebElement element, WebElement target) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(element, target).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void elementRightClick(WebElement element) {
		try {
			waitforVisibilityOfWebelement(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doubleClick(WebElement element) throws Exception {
		try {
			waitforVisibilityOfWebelement(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitforAlertIsPresent() {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void switchtoAlert(String options) throws Exception {
		try {
			waitforAlertIsPresent();
			Alert alert = driver.switchTo().alert();

			if (options.equalsIgnoreCase("accept")) {
				alert.accept();
			}else if (options.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}else if (options.contains(("prompt"))) {
				String[] split = options.split("=");
				alert.sendKeys(split[1]);
				alert.accept();
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void switchtoWindows(String value) {
		try {
			String cid = driver.getWindowHandle();
			Set<String> pid = driver.getWindowHandles();
			for (String x : pid) {
				driver.switchTo().window(x);
				String title = driver.getTitle();
				if (title.contains(value)) {
					driver.switchTo().window(x);
					break;
				}else {
					continue;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void switchToFrame(String element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void driverQuit() {
		driver.quit();
	}
}




