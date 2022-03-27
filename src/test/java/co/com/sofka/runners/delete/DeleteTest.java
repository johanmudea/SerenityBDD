package co.com.sofka.runners.singleuser;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/delete.feature"},
        glue = {"co.com.sofka.stepdefinitions.delete"})


public class DeleteTest {
}
