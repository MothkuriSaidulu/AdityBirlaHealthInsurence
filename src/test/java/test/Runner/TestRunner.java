package test.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
//		".\featureFiles\TC01_Verify_Agent_Login_Function.feature", 
		".\\featureFiles\\TC02_Purchas_Product.feature" }, glue = { "step.Defination" }, plugin = { "pretty",
				"html:target\\report.html" }, dryRun = false, monochrome = true, tags = "@ENHANCED_New_Business")

public class TestRunner {

}