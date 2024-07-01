package step.Defination;

import io.cucumber.java.After;
import utilities.TestBase;

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
