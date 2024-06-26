package step.Defination;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.Page_02_Dashboard;
import pages.Page_03_Insured_Members;
import utilities.TestBase;

public class TC02_Purchas_Product extends TestBase {

	@Then("click on plus button and get quote.")
	public void click_on_plus_button_and_get_quote() throws IOException {
		objDashboard = new Page_02_Dashboard(driver);
		objDashboard.clickOnPlusButton();

	}

	@Then("select standalone product type.")
	public void select_standalone_product_type() throws IOException {
		objDashboard = new Page_02_Dashboard(driver);
		objDashboard.selectStandAloneProduct();

	}

	@Then("verify agent landed on Insured Members page.")
	public void verify_agent_landed_on_insured_members_page() {
		objInsuredMember = new Page_03_Insured_Members(driver);
		objInsuredMember.verifyinsuredMemberPageTitle();

	}

	@Then("choose active health platinum type as {string}.")
	public void choose_active_health_platinum_type(String coverType) {
		objInsuredMember = new Page_03_Insured_Members(driver);
		objInsuredMember.selectCoverType(coverType);

	}

	@Then("select policy type as {string}.")
	public void select_policy_type(String policyType) {
		objInsuredMember = new Page_03_Insured_Members(driver);
		objInsuredMember.selectPolicyType(policyType);
	}

	@Then("enter proposer details.")
	public void enter_proposer_details() {
		objInsuredMember = new Page_03_Insured_Members(driver);
		objInsuredMember.selectDateOfBirth();
	}

}