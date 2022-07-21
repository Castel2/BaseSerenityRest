package com.test.rest.tasks;

import com.test.rest.utils.Data;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeGetMethod implements Task {

    private String path;

    public ConsumeGetMethod(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path));
        actor.remember(Data.RESPONSE,SerenityRest.lastResponse());
    }

    public static ConsumeGetMethod to(String path){
        return instrumented(ConsumeGetMethod.class, path);
    }
}
