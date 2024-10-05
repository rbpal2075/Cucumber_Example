package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/java/features/login.feature",
			glue= {"stepDefinitions"},
			plugin = {"pretty" ,
					  "html:target/report/cucumber.html",
					  "json:target/cucumber-reports"
			         }
			
			)
	public class TestRunner {			

}
