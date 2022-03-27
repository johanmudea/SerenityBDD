package co.com.sofka.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.HashMap;

public class DoDelete implements Task {

    private String resource;
    private HashMap<String, Object> headers = new HashMap<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from(resource)

        );

    }

    public DoDelete usingResources(String resource) {
        this.resource = resource;
        return this;
    }

    public DoDelete withHeaders(HashMap<String, Object> headers) {
        this.headers = headers;
        return this;

    }

    public static DoDelete doDelete(){
        return new DoDelete();
    }


}
