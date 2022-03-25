package co.com.sofka.runners.update;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/soap/currencyName.feature"},
        glue = {"co.com.sofka.stepdefinition.soap"}
)
public class UpdateTest {
}
