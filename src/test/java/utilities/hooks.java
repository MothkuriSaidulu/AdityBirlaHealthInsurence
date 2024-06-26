package utilities;

import io.cucumber.java.After;

public class hooks extends TestBase {

	@After
	public void closeBroser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
