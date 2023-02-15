package CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


// Test runner file need Feature file information
// It also needs Step definition file location as well
// You can esure both files/packages are residing under same srs/test/java folder

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",  // Package level path for feature files
        glue = "StepDefFiles"  // Package name of the Step definition file
)
public class TestRunner {

}
