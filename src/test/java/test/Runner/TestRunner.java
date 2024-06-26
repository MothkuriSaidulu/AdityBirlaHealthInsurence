package test.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
//		"C:\Users\Monocept\eclipse-workspace\AdityaBirlaHealthInsurence\featureFiles\TC01_Verify_Agent_Login_Function.feature", 
		"C:\\Users\\Monocept\\eclipse-workspace\\AdityaBirlaHealthInsurence\\featureFiles\\TC02_Purchas_Product.feature" }, glue = {
				"step.Defination" }, dryRun = false, monochrome = true
)

public class TestRunner {

}