package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/lab6",   // ⬅️ doar lab 6
        glue = {"stepdefs", "hooks"},
        plugin = {"pretty", "html:target/cucumber-lab6-report.html"},
        monochrome = true
)
public class RunCucumberTest {
}
