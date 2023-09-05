package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "pages",
        tags = "@Registration",
        plugin = {"pretty", "html:src/test/resources/reports/RegistrationReport.html"}
)

public class RunTestRegistration {
}
