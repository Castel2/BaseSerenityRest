package com.test.rest.exceptions;

public class ValidateUserException extends Error{

    public static final String MESSAGE_ERROR = "It was not possible to validate the user information";

    public ValidateUserException(String message, Throwable cause){
        super(message, cause);
    }

}
