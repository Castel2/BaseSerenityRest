package com.test.rest.stepdefinitions;

import com.test.rest.exceptions.ValidateUserException;
import com.test.rest.questions.ValidateUser;
import com.test.rest.tasks.ConsumeGetMethod;
import com.test.rest.utils.Data;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchUsersStepDefinitions {


    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Data.BASE_URL)));
        OnStage.theActorCalled("Channel");
        SerenityRest.useRelaxedHTTPSValidation();
    }


    @When("^the channel request the user with id (.*)$")
    public void the_channel_request_the_user_with_id(String id) {
        theActorInTheSpotlight().attemptsTo(ConsumeGetMethod.to(Data.USERS_PATH.concat(id)));
    }


    @Then("^the user information should contains the user with name (.*) email (.*) and city (.*)$")
    public void the_users_information_should_contains_the_information(String name, String email, String city) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateUser.information(name,email,city))
                .orComplainWith(Error.class, ValidateUserException.MESSAGE_ERROR));
    }


}
