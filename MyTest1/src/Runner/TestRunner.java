package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "Feature"
	, glue = {"stepDefinition"}
	, dryRun = true
	, monochrome = false
	, plugin = { "pretty" }
	, strict = false
)

public class TestRunner {
}
