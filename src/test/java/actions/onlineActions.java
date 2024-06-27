package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestBase;

public class onlineActions extends TestBase {

	public static String rootPath = System.getProperty("user.dir");
	public static Properties proparty;

//	public static WebDriver driver;

	public static final Logger logger = Logger.getLogger(onlineActions.class);

	public onlineActions(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	Apply Wait mechanism
	public static WebDriverWait ApplyWebDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.ignoring(Exception.class);
		return wait;
	}

	public static void WaitForWebElementToVisable(WebElement element, String elementDesc) {
		try {
			logger.info(elementDesc);
			WebDriverWait wait = ApplyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING WAIT FOR SPECIFIED WEB ELEMENT  : " + e.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO VISABLE ON THE SPECIFIED WEB ELEMENT"
					+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());

		}
	}

	public static void waitForElementToInvisable(WebElement element, String elementDesc) {
		try {
			logger.info(element);
			WebDriverWait wait = ApplyWebDriverWait();
			wait.until(ExpectedConditions.invisibilityOf(element));

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING TO INVISABILITY OF THE SPECIFIED WEB ELEMENT : " + e.getMessage());
			Assert.fail(
					"WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO INVISABLE ON THE SPECIFIED WEB ELEMENT"
							+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- "
							+ e.getMessage());
		}

	}

	public static void waitForElementToClickable(WebElement element, String elementDesc) {

		try {
			logger.info(elementDesc);
			WebDriverWait wait = ApplyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING CLICKING ON SPECIFIED WEB ELEMENT : " + e.getMessage());
			Assert.fail(
					"WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO CLICKABLE ON THE SPECIFIED WEB ELEMENT"
							+ "<b>" + elementDesc + "</b>" + " is not clickable_due_to_the_Exception:- "
							+ e.getMessage());
		}

	}

//	Validate The Test
	public static void VerifyText(WebElement element, String elementDesc, String expectedText) {
		logger.info(
				"--------	VerifyText wrapper method inside FalconActions class is invoked successfully	--------");

		try {
			WaitForWebElementToVisable(element, elementDesc);
			String actualTxt = element.getText().trim().toLowerCase();
			String expectedTxt = expectedText.trim().toLowerCase();
			Assert.assertEquals(expectedTxt, actualTxt);
			logger.info("Actual and Expected texts are equal: Actual is: " + "<b>" + actualTxt + "</b>"
					+ " and Expected is: " + "<b>" + expectedTxt + "</b>");

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : " + e.getMessage());
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());
		}
	}

//	Send keys
	public static void EnterText(WebElement element, String elementDesc, String sendText) {
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");

		try {
			waitForElementToClickable(element, elementDesc);
			element.click();
			element.clear();
			element.sendKeys(sendText);
			logger.info(
					"--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING TO VERIFY THE TEXT FOR SPECIFIED WEB ELEMENT : " + e.getMessage());
			Assert.fail("Exception : WHILE TRYING TO SEND THE TEXT INSIDE A WEB ELEMENT : " + "<b>" + elementDesc
					+ "</b>" + " due to the Exception: " + e.getMessage());
		}

	}

//	Click 
	public static void Click(WebElement element, String elementdesc) {
		logger.info("--------	click wrapper method inside MyAction class is invoked successfully	--------");

		try {
			waitForElementToClickable(element, elementdesc);
			element.click();
			logger.info("--------	click wrapper method inside MyAction class is invoked successfully	--------");

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + e.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"
					+ "User_unable_to_click_on_the_" + "<b>" + e + "</b>" + "_due_to_the_Exception:-" + e.getMessage());
		}

	}

	// Take Screenshots
	public static void TakeScreenShot() // C:\Users\SAIDACHARY\eclipse-workspace\Test_11_Luma_Ecommerce_Project\Screenshots
	{
		try {
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File filePath = new File(rootPath + "\\Screenshots\\pic.png");
			FileUtils.copyDirectory(scr, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseOverActionAndClick(WebElement element, WebDriver driver) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build();
			act.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Properties readPropartyFile() throws IOException {

		try {
			proparty = new Properties();
			filePath = new FileInputStream("config.properties");
			proparty.load(filePath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return proparty;
	}

	public Select selectOptonsFromDropDown(WebElement element) {
		objSelect = new Select(element);
		return objSelect;

	}

}
