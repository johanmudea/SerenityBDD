package co.com.sofka.stepdefinitions.update;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import co.com.sofka.util.UpdateKeys;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static co.com.sofka.questions.APIResponse.response;
import static co.com.sofka.task.DoPut.doPut;
import static co.com.sofka.util.FileUtilities.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateClassStepDefinition extends ServiceSetUp {

    private static final String UPDATE_FILE = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\update.json";


    private static final Logger LOGGER = Logger.getLogger(UpdateClassStepDefinition.class);

    private final HashMap<String, Object> headers = new HashMap<>();
    private final Actor actor = Actor.named("Samuelito");
    private String bodyRequest;



    @Given("el usuario esta en la pagina  con name {string} y el job {string}")
    public void elUsuarioEstaEnLaPaginaConNameYElJob(String name, String job) {

        generalSetUp();
        actor.can(CallAnApi.at(BASE_URI));
        headers.put("content-Type", ContentType.JSON);
        LOGGER.info(ContentType.JSON);


        bodyRequest = defineBodyRequest(name, job);
        LOGGER.info(bodyRequest);


    }

    @When("cuando el usuario hace una solicitud de actualizacion")
    public void cuandoElUsuarioHaceUnaSolicitudDeActualizacion() {

        actor.attemptsTo(
                doPut()
                        .usingTheResource(RESOURCE_UPDATE)
                        .withHeaders(headers)
                        .andBodyRequest(bodyRequest)

        );

    }
    @Then("se debera ver un codigo de respuesta exitoso status.")
    public void seDeberaVerUnCodigoDeRespuestaExitosoStatus() {

        LastResponse.received().answeredBy(actor).prettyPrint();

        actor.should(
                seeThatResponse("El status deberia ser: " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                ),
                seeThat("La respuesta deberia no ser nula: ", response(), Matchers.notNullValue())
        );

    }


    private String defineBodyRequest(String name, String job){
        return readFile(UPDATE_FILE)
                .replace(UpdateKeys.NAME.getValue(), name)
        .replace(UpdateKeys.JOB.getValue(), job);
    }

}
