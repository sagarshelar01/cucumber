package com.vtiger.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.remote.tracing.Tags;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "src/test/resources/Features/",
		glue= "com.vtiger.stepsdefinations",
		dryRun=true,
		plugin = {"pretty","json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports.html"},
		tags = "@leadFunctionality"
		
		)
public class testRunner {

}
