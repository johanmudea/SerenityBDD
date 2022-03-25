package co.com.sofka.runners.update;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/update.feature"},
        glue = {"co.com.sofka.stepdefinitions.update"}
)
public class UpdateTest {
}
