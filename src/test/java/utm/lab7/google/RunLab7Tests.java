package utm.lab7.google;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/lab7",
        glue = "utm.lab7.google",
        plugin = {
                "pretty",
                "html:target/cucumber-lab7-report.html"
        }
)
public class RunLab7Tests {
}
