package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/validateSmartBear.feature",
        glue = "steps",
        tags = "",
        plugin = "html:target/cucumber-reports"
)
public class Runner {

}