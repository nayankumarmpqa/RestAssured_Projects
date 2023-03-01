package CucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files",
        glue = "Step_Definition_Files"
)

public class TestRunner {


}
