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

//
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

//	Proposar details web elements
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

	@FindBy(xpath = "//input[@name='insuredPincodeHealth']")
	private WebElement areaPinCode;

//	Actions
	public void verifyinsuredMemberPageTitle() {

		VerifyText(insuredMembersPageTitle, "Insured Member", "Insured Members");

	}

	public void selectCoverType(String coverType) {

//		objSelect = selectOptonsFromDropDown(covertypeDropDown);
//		objSelect.selectByVisibleText(coverType);

//		Select sel = new Select(covertypeDropDown);
//		sel.selectByIndex(1); // 

//      ENHANCED
//		ESSENTIAL
//		PREMIER
//
//		Click(covertypeDropDown, "Cover Type");
		try {
//			Thread.sleep(3000);
			for (int i = 0; i < coverTypes.size(); i++) {
				String webCoverType = coverTypes.get(i).getText();
				System.out.println(webCoverType);
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

//		Click(policyType, "portabilityOption");
//
//		for (int i = 0; i < policyTypes.size(); i++) {
//			String webPolicyName = policyTypes.get(i).getText();
////			System.out.println(webPolicyName);
//			if (webPolicyName.contains(policyName)) {
//				policyTypes.get(i).click();
//				break;
//			}
//		}

	}

	public void enterDateOfBirth() throws IOException {

//		dobDay.sendKeys("18");
//		dobMonth.sendKeys("08");
//		dobYear.sendKeys("1995");

		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("day");
		EnterText(dobDay, "Day", getPropartyValue);

		getPropartyValue = proparty.getProperty("month");
		EnterText(dobMonth, "Month", getPropartyValue);

		getPropartyValue = proparty.getProperty("year");
		EnterText(dobYear, "Year", getPropartyValue);

//		String day = proparty.getProperty("day");
//		String moth = proparty.getProperty("moth");
//		String year = proparty.getProperty("year");

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

//		objSelect = selectOptonsFromDropDown(genderDropDown);
//		objSelect.selectByVisibleText(getPropartyValue);

//		Click(SelectPolicyType, "click on policy dropdown");
//		for (int i = 0; i < SelectPolicyTypeOptions.size(); i++) {
//			String policyType = SelectPolicyTypeOptions.get(i).getText();
//			System.out.println(policyType);
//			if (policyType.contains("MULTI INDIVIDUAL")) {
//				SelectPolicyTypeOptions.get(i).click();
//				break;
//			}
//
//		}

	}

	public void selectSelectSumInsuredForFamily() throws IOException {
//		proparty = readPropartyFile();
//		getPropartyValue = proparty.getProperty("insuredAmount");
//
//		Select sel = new Select(insuredAmount);
//		sel.selectByVisibleText(getPropartyValue);

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
		
		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("day");
		EnterText(dobDay, "Day", getPropartyValue);

		getPropartyValue = proparty.getProperty("month");
		EnterText(dobMonth, "Month", getPropartyValue);

		getPropartyValue = proparty.getProperty("year");
		EnterText(dobYear, "Year", getPropartyValue);
		
		
		getPropartyValue = proparty.getProperty("gender");
		objSelect = selectOptonsFromDropDown(genderDropDown);
		objSelect.selectByVisibleText(getPropartyValue);
		
		getPropartyValue = proparty.getProperty("selectPolicyType");
		objSelect = selectOptonsFromDropDown(SelectPolicyType);
		objSelect.selectByVisibleText(getPropartyValue);

//		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("insuredAmount");
		objSelect = selectOptonsFromDropDown(insuredAmount);
		objSelect.selectByVisibleText(getPropartyValue);

//		proparty = readPropartyFile();
		getPropartyValue = proparty.getProperty("pinCode");
		objSelect = selectOptonsFromDropDown(areaPinCode);
		objSelect.selectByVisibleText(getPropartyValue);

		getPropartyValue = proparty.getProperty("pinCode");
		EnterText(areaPinCode, "Enter Pin code", getPropartyValue);
		
	}

}
