package pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actions.onlineActions;
import utilities.TestBase;

public class Page_03_Insured_Members extends onlineActions {

	public Page_03_Insured_Members(WebDriver driver) {
		super(driver);
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-tab='aaq-insured-members']")
	private WebElement insuredMembersPageTitle;

	@FindBy(xpath = "//select[@id='coverType']")
	private WebElement covertypeDropDown;

	@FindBy(xpath = "//select[@id='coverType']//option") // "//select[@id='coverType']")
	private List<WebElement> coverTypes;

	@FindBy(xpath = "//select[@name='portabilityOption']")
	private WebElement policyType;

	@FindBy(xpath = "//select[@id='portabilityOption']/option")
	private List<WebElement> policyTypes;

	@FindBy(css = "input#dobDay")
	private WebElement dobDay;

	@FindBy(css = "input[name='dobMonth']")
	private WebElement dobMonth;

	@FindBy(css = "input[name='dobYear']")
	private WebElement dobYear;

	@FindBy(xpath = "//select[@name='gender']")
	private WebElement genderDropDown;

	@FindBy(xpath = "//select[@name='gender']//option")
	private List<WebElement> genderOptions;

	@FindBy(xpath = "//select[@id='selectType']")
	private WebElement SelectPolicyType;

	@FindBy(xpath = "//select[@id='selectType']//option")
	private List<WebElement> SelectPolicyTypeOptions;

	@FindBy(xpath = "//select[@id='insuredSiHealth']")
	private WebElement insuredAmount;

	@FindBy(css = "input[name='insuredPincodeHealth']")
	private WebElement areaPinCode;

//	Actions
	public void verifyinsuredMemberPageTitle() {
		VerifyText(insuredMembersPageTitle, "Insured Member", "Insured Members");
	}

	public void selectCoverType(String coverType) {
		try {
			for (int i = 0; i < coverTypes.size(); i++) {
				String webCoverType = coverTypes.get(i).getText();
				if (webCoverType.contains(coverType)) {
					coverTypes.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PolicyType(String policyName) {
		try {
			objSelect = selectOptonsFromDropDown(policyType);
			objSelect.selectByVisibleText(policyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDateOfBirth() throws IOException {
		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("day");
		EnterText(dobDay, "Day", getPropartyValue);

		getPropartyValue = proparty.getProperty("month");
		EnterText(dobMonth, "Month", getPropartyValue);

		getPropartyValue = proparty.getProperty("year");
		EnterText(dobYear, "Year", getPropartyValue);
	}

	public void selectgenderType() throws IOException {

		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("gender");
		objSelect = selectOptonsFromDropDown(genderDropDown);
		objSelect.selectByVisibleText(getPropartyValue);

	}

	public void selectpolicyType() throws IOException {

		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("selectPolicyType");
		objSelect = selectOptonsFromDropDown(SelectPolicyType);
		objSelect.selectByVisibleText(getPropartyValue);
	}

	public void selectSumInsuredForFamily() throws IOException {
		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("insuredAmount");
		objSelect = selectOptonsFromDropDown(insuredAmount);
		objSelect.selectByVisibleText(getPropartyValue);

	}

	public void enterPinCode() throws IOException {
		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("pinCode");
		EnterText(areaPinCode, "Enter Pin code", getPropartyValue);
	}

	public void enterProposerDetails(String policyType, String sumInsureAmount, String pinCode) throws IOException {

//		Date of Birth
		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("day");
		EnterText(dobDay, "Day", getPropartyValue);

		getPropartyValue = proparty.getProperty("month");
		EnterText(dobMonth, "Month", getPropartyValue);

		getPropartyValue = proparty.getProperty("year");
		EnterText(dobYear, "Year", getPropartyValue);

//		Gender selection
		getPropartyValue = proparty.getProperty("gender");
		objSelect = selectOptonsFromDropDown(genderDropDown);
		objSelect.selectByVisibleText(getPropartyValue);

//		Policy selection
		objSelect = selectOptonsFromDropDown(SelectPolicyType);
		objSelect.selectByVisibleText(policyType);

//		Sum Insured Amount
		objSelect = selectOptonsFromDropDown(insuredAmount);
		objSelect.selectByVisibleText(sumInsureAmount);

//		Enter Pin code
		EnterText(areaPinCode, "Enter Pin code", pinCode);

	}

}
