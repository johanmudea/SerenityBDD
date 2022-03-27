package co.com.sofka.stepdefinitions.delete;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import java.util.HashMap;
import static co.com.sofka.task.DoDelete.doDelete;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeleteStepDefinitions extends ServiceSetUp {

    private static Logger LOGGER = Logger.getLogger(DeleteStepDefinitions.class);
    private final HashMap<String, Object> headers = new HashMap<>();

    private final Actor actor = Actor.named("Johan");


    @Given("me encuentro en el servicio")
    public void meEncuentroEnElServicio() {

        generalSetUp();
        actor.can(CallAnApi.at(BASE_URI));

    }

    @When("realizo una peticion de eliminacion de usuario")
    public void realizoUnaPeticionDeEliminacionDeUsuario() {

        actor.attemptsTo(
                doDelete().usingResources(DELETE)

        );

    }
    @Then("Se obtendra un status de no contenido.")
    public void seObtendraUnStatusDeNoContenido() {

        actor.should(
                seeThatResponse("El Status debería ser: "+ HttpStatus.SC_NO_CONTENT,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_NO_CONTENT)

        ));

    }

}
