package co.com.sofka.stepdefinitions.singleuser;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static co.com.sofka.questions.APIResponse.response;
import static co.com.sofka.task.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class singleUserStepDefinition extends ServiceSetUp {

        private static Logger LOGGER = Logger.getLogger(singleUserStepDefinition.class);
        private final HashMap<String, Object> headers = new HashMap<>();

        private final Actor actor = Actor.named("Johan");


        @Given("me encuentro en el servicio")
        public void meEncuentroEnElServicio() {

                generalSetUp();
                actor.can(CallAnApi.at(BASE_URI));
                headers.put("Content-Type", ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8));



        }


        @When("realizo una peticion de consulta de usuario")
        public void realizoUnaPeticionDeConsultaDeUsuario() {

                actor.attemptsTo(
                        doGet().usingResources(RESOURCE_SINGLE_USER)
                                .withHeaders(headers)

                );


        }


        @Then("Se obtendra un status de OK en http.")
        public void seObtendraUnStatusDeOKEnHttp() {

                LastResponse.received().answeredBy(actor).prettyPrint();

                actor.should(
                        seeThatResponse("El Status debería ser: "+ HttpStatus.SC_OK,
                                validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)

                        ),
                        seeThat("La respuesta deberia ser nula: ", response(), Matchers.notNullValue())

                );

        }


}
