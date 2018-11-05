package com.academy.fx.model;


public class RegistrationFormFiller {

    public  RegistrationForm fillFormEmptyFirstName (String firstName, String lastName, String email,
                                                     String password, String confirmPassword){
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("", "test")
                .withLastName("", lastName)
                .withMail("", email)
                .withPassword("", password)
                .withConfirmPassword("q", confirmPassword);
        return registrationForm;

    }


}
