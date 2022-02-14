package payments.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"com.currencycloud.steps"},
		features = "src/test/resources/features",
		plugin = { "pretty", "html:target/site/cucumber-pretty.html",
		"json:target/cucumber.json" })
public class RunCucumberTests {
}
