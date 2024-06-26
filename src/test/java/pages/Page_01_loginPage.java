package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.onlineActions;
import utilities.TestBase;

public class Page_01_loginPage extends onlineActions {

	public Page_01_loginPage(WebDriver driver) {
		super(driver);
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement username_txt;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_txt;

	@FindBy(xpath = "//button[@id='userlogin']")
	private WebElement login_btn;

	@FindBy(xpath = "//div[@id='alert-div']")
	private WebElement incorrentCredentials;

	@FindBy(xpath = "//div[@class='overlay']")
	private WebElement overlay;

//	Actions

	public void enterUserIdAndPassword(String userID, String password) {
		proparty = new Properties();
//		String userID = proparty.getProperty("userid");
//		String password = proparty.getProperty("password");
		EnterText(username_txt, "username", userID);
		EnterText(password_txt, "username", password);

	}

	public void clickOnLoginBtn() {

		Click(login_btn, "login button");

//		String dashBoardTitle = "Aditya Birla Health Insurance";
//		String  = driver.getTitle();

		try {

//			boolean flag = false;
//			waitForElementToInvisable(overlay, "Overlay");
			Thread.sleep(10000);
//			WaitForWebElementToVisable(incorrentCredentials, getPropartyValue);

			if (incorrentCredentials.isDisplayed()) {
				System.err.println(incorrentCredentials.getText());
			} else {
				System.out.println(driver.getTitle());
				System.out.println("Agent Logged in Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void invalidLoginDetails() {

		try {
			if (incorrentCredentials.isDisplayed()) {
				System.out.println(incorrentCredentials.getText());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
