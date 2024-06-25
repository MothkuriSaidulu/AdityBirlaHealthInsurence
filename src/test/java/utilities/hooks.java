package utilities;

public class hooks extends TestBase {

	public void closeBroser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
