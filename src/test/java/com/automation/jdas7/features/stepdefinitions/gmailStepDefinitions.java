package com.automation.jdas7.features.stepdefinitions;

import com.automation.jdas7.config.StepBase;
import com.automation.jdas7.features.questions.OverflowQuestion;
import com.automation.jdas7.features.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class gmailStepDefinitions extends StepBase {

  private String theRestApiBaseUrl;
  private EnvironmentVariables environmentVariables;
  private static final int WAIT_NEXT_WINDOW = 2;
  private static final String EMAIL = "email";
  private static final String PASSWORD = "password";

  @Before
  public void setTheStage() {
    theRestApiBaseUrl = environmentVariables.getProperty("restapi.baseurl");
    OnStage.setTheStage(OnlineCast.whereEveryoneCan(
        CallAnApi.at(theRestApiBaseUrl)
    ));
  }

  @Cuando("intenta iniciar sesion")
  public void loginUser() {
    OnStage.withCurrentActor(
        Login.loginU(
            dataProvider.getUserData().get(EMAIL).getAsString(),
            dataProvider.getUserData().get(PASSWORD).getAsString()));
  }

  @Entonces("visualiza un error indicando que la contrasena es incorrecta")
  public void passwordFail() {
    theActorInTheSpotlight()
        .should(seeThat("Validación texto de error", OverflowQuestion.textForm(),
            equalTo("Contraseña incorrecta. Vuelve a intentarlo o selecciona \"¿Has olvidado tu contraseña?\" para cambiarla.")));
  }

}
