package automation.cuckesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "automation/step_definition",
        dryRun = false,
        tags = "@librarians",
        publish = true
)
public class runner {
}
