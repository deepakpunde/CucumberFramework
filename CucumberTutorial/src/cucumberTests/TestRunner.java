package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
		//Gives better formatted result.
		monochrome=true,
		
		//flag to check if cucmber needs to verify if for feature file statements step definition exists.
		dryRun=false,
		
		//location or path where feature file exists.
		features = "src/Feature",
		
		//location or path where Step Definition file exists.
		glue = {"stepDefinition"}	
		)

public class TestRunner {

}
