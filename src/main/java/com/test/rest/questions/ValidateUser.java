package com.test.rest.questions;

import com.test.rest.models.User;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.test.rest.utils.Data.RESPONSE;

public class ValidateUser implements Question<Boolean> {

    private String name;
    private String email;
    private String city;

    public ValidateUser(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response usersResponse = actor.recall(RESPONSE);
        User user= usersResponse.getBody().as(User.class, ObjectMapperType.GSON);
        boolean correctName = user.getName().equals(name);
        boolean correctEmail = user.getEmail().equals(email);
        boolean correctCity = user.getAddress().getCity().equals(city);
        return (correctName && correctEmail && correctCity);

    }

    public static ValidateUser information (String name, String email, String city){
        return new ValidateUser(name,email,city);
    }
}
