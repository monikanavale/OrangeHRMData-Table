package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"AllFeatureFiles"},
		glue = {"StepDefinition"},
		dryRun=false,
		monochrome=true
		
		)

public class RunnerTest {

}
