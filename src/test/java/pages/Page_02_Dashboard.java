package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.onlineActions;
import utilities.TestBase;

public class Page_02_Dashboard extends onlineActions {

	public Page_02_Dashboard(WebDriver driver) {
		super(driver);
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='red-callback-pos']")
	private WebElement plusButton;

	@FindBy(xpath = "//button[@class='btn get-quote-btn']")
	private WebElement getQuote;

	@FindBy(xpath = "//a[contains(text(),'Buy Standalone Product')]")
	private WebElement BuyStandaloneProduct;

	@FindBy(xpath = "//div[contains(@class,'panel-body')]/descendant::button")
	private List<WebElement> listOfProductTypes;

	@FindBy(xpath = "//a[contains(text(),'Buy Combi Product')]")
	private WebElement BuyCombiProduct;

	//

	public void clickOnButton() {
		Click(plusButton, "Click On Plus button");
		Click(getQuote, "Get quote");
		Click(BuyStandaloneProduct, "Standalon Product");

		for (int i = 0; i < listOfProductTypes.size(); i++) {
			String productName = listOfProductTypes.get(i).getText();
			if (productName.equalsIgnoreCase("Activ Health")) {
				listOfProductTypes.get(i).click();

			}

		}
	}

}