package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//FeaturesSteps/faceloginfea.feature",
		glue={"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/Html Reportss"}
)

public class TestRun 
{
	//Empty
}
