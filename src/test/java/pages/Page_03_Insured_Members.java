package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	private WebElement pinCode;

//	Actions
	public void verifyinsuredMemberPageTitle() {

		VerifyText(insuredMembersPageTitle, "Insured Member", "Insured Members");

	}

	public void selectCoverType(String coverType) {

//		objSelect = selectOptonsFromDropDown(covertypeDropDown);
//		objSelect.selectByIndex(1);
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

//		objSelect = selectOptonsFromDropDown(covertypeDropDown);
//		objSelect.selectByVisibleText(policyName);

//		Click(policyType, "portabilityOption");
//
		for (int i = 0; i < policyTypes.size(); i++) {
			String webPolicyName = policyTypes.get(i).getText();
//			System.out.println(webPolicyName);
			if (webPolicyName.contains(policyName)) {
				policyTypes.get(i).click();
				break;
			}
		}

//		Select sel = new Select(policyType);
////		sel.selectByVisibleText("essential");
//		sel.selectByIndex(1);

//		objSelect.selectByIndex(1);

	}

	public void selectDateOfBirth() {
		proparty = new Properties();
		String day = proparty.getProperty("day");
		String moth = proparty.getProperty("moth");
		String year = proparty.getProperty("year");

		dobDay.sendKeys("18");
		dobMonth.sendKeys("08");
		dobYear.sendKeys("1995");

	}

	public void selectgenderType() {
		objSelect = selectOptonsFromDropDown(genderDropDown);
		objSelect.selectByVisibleText("FEMALE");

	}

	public void selectpolicyType() {

		Click(SelectPolicyType, "click on policy dropdown");
		for (int i = 0; i < SelectPolicyTypeOptions.size(); i++) {
			String policyType = SelectPolicyTypeOptions.get(i).getText();
			if (policyType.contains("FAMILY FLOATER")) {
				SelectPolicyTypeOptions.get(i).click();
				break;
			}

		}

	}

	public void selectSelectSumInsuredForFamily() {
		Select sel = new Select(insuredAmount);
		sel.selectByVisibleText("500000");

	}

	public void enterPinCode() {
		EnterText(pinCode, "Enter Pin code", "508217");

	}

}
