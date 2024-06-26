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

	@FindBy(xpath = "//select[@id='portabilityOption']")
	private List<WebElement> policyTypes;

//	Proposar details web elements
	@FindBy(css = "input#dobDay")
	private WebElement dobDay;

	@FindBy(xpath = "input[name='dobMonth']")
	private WebElement dobMonth;

	@FindBy(xpath = "input[name='dobYear']")
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

		objSelect = selectOptonsFromDropDown(covertypeDropDown);
//		objSelect.deselectByVisibleText("ESSENTIAL");
		objSelect.selectByIndex(1);

//		Select sel = new Select(covertypeDropDown);
//		sel.selectByIndex(1); // 

//      ENHANCED
//		ESSENTIAL
//		PREMIER

//		Click(covertypeDropDown, "Cover Type");
//		try {
////			Thread.sleep(3000);
//			for (int i = 0; i < coverTypes.size(); i++) {
//				String webCoverType = coverTypes.get(i).getText();
//				System.out.println(webCoverType);
//				if (webCoverType.contains(coverType)) {
//					coverTypes.get(i).click();
//					break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	public void selectPolicyType(String policyName) {

//		Click(policyType, "portabilityOption");
//
//		for (int i = 0; i < policyTypes.size(); i++) {
//			String webPolicyName = policyTypes.get(i).getText();
//			System.out.println(webPolicyName);
//			if (webPolicyName.contains(policyName)) {
//				policyTypes.get(i).click();
//				break;
//			}
//		}

//		Select sel = new Select(policyType);
////		sel.selectByVisibleText("essential");
//		sel.selectByIndex(1);

		objSelect = selectOptonsFromDropDown(covertypeDropDown);
//		objSelect.selectByVisibleText("Portability");
		objSelect.selectByIndex(1);

	}

	public void selectDateOfBirth() {
		proparty = new Properties();
		String day = proparty.getProperty("day");
		String moth = proparty.getProperty("moth");
		String year = proparty.getProperty("year");
		System.out.println(day);
		EnterText(dobDay, "Day text", day);
		System.out.println(day);
		EnterText(dobMonth, "Day text", moth);
		EnterText(dobYear, "Day text", year);

		objSelect = selectOptonsFromDropDown(genderDropDown);
		objSelect.selectByVisibleText("MALE");
		
		
		
	}

}
