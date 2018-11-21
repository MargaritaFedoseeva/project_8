import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"demo.steps"},
        plugin = {
                "pretty",
                "demo.reporter.AllureReporter"})
public class CucumberRunner {
}
