package test.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { ".\\featureFiles\\TC02_Purchas_Product.feature" }, 
		glue = { "step.Defination" },
//		plugin = { "pretty","html:target\\report.html" }, 
		dryRun = false, monochrome = true, 
//		tags = "@ENHANCED_New_Business", 
		plugin = { "json:target/cucumberJson.json",
				"html:target/cucumberhtml.html" }

)

public class TestRunner {

	

}