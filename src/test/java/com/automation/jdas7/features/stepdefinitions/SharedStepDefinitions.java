package com.automation.jdas7.features.stepdefinitions;

import com.automation.jdas7.config.StepBase;
import com.automation.jdas7.exceptions.NotValidEnvironmentException;
import com.automation.jdas7.exceptions.UserNotFoundException;
import com.automation.jdas7.features.tasks.NavigateTo;
import io.cucumber.java.en.Given;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SharedStepDefinitions extends StepBase {
    @Given("^(.*) es un (.*)$")
    public void userRole(String actor, String userRole) throws UserNotFoundException, NotValidEnvironmentException {
        theActorCalled(actor).attemptsTo(NavigateTo.goHomePage());
        dataProvider.setUserRole(userRole);
    }
}
