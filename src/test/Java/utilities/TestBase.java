package utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Page_01_loginPage;
import pages.Page_02_Dashboard;
import pages.Page_03_Insured_Members;

public class TestBase {

	public static WebDriver driver;
	public static Properties proparty;
	public static Select objSelect;
	public static String getPropartyValue;
	public Page_01_loginPage objLoginPage;
	public Page_02_Dashboard objDashboard;
	public Page_03_Insured_Members objInsuredMember;

	public static FileInputStream filePath;
	public static String rootPath = System.getProperty("user.dir");

	public void launchBrowserAndEnterURL() {

		try {
			proparty = new Properties();
			filePath = new FileInputStream("config.properties");
			proparty.load(filePath);
			getPropartyValue = proparty.getProperty("browser");
			System.out.println(getPropartyValue);
			if (getPropartyValue.contains("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver = new ChromeDriver(options);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		System.out.println(" ********** Browser Launched Sucessfully **********  ");
		driver.get(proparty.getProperty("url"));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
