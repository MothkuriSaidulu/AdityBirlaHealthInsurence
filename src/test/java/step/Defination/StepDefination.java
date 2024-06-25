package step.Defination;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.page_01_loginPage;
import utilities.TestBase;

public class StepDefination extends TestBase {

	@Given("user launched the brower and entered url.")
	public void user_launched_the_brower_and_entered_url() {
		launchBrowserAndEnterURL();

	}

	@When("agent enterd userid As {string} password as this {string}.")
	public void agent_enterd_userid_as_password_as_this(String username, String password) {

		objLoginPage = new page_01_loginPage(driver);
		objLoginPage.enterUserIdAndPassword(username, password);

	}

	@When("agent click on login button.")
	public void agent_click_on_login_button() {
		objLoginPage = new page_01_loginPage(driver);
		objLoginPage.clickOnLoginBtn();

	}

	@Then("verify agent landed on dashboard.")
	public void verify_agent_landed_on_dashboard() {
		String expectedPageTitle = "Aditya Birla Health Insurance";

		try {
			String actualPageTitle = driver.getTitle();
			Assert.assertEquals(expectedPageTitle, actualPageTitle);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(" >>>>>>> User Landed on Dash Board <<<<<<< ");
		}

	}

}
