package com.automation.jdas7.features.tasks;

import com.automation.jdas7.features.ui.LoginUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

  private String email;
  private String password;

  @Step("ingresar el producto a consultar")
  public static Task loginU(String email, String password) {
    return Instrumented.instanceOf(Login.class).withProperties(email, password);
  }

  public Login(String email, String password) {
    this.email = email;
    this.password = password;
  }

  @Step("cliente consulta su producto")
  public <T extends Actor> void performAs(T user) {
    user.attemptsTo(
        WaitUntil.the(LoginUI.EMAIL, isVisible()),
        WaitUntil.the(LoginUI.EMAIL, isEnabled()),
        Enter.theValue(email).into(LoginUI.EMAIL),
        WaitUntil.the(LoginUI.BUTTON_NEXT, isVisible()),
        WaitUntil.the(LoginUI.BUTTON_NEXT, isEnabled()),
        Click.on(LoginUI.BUTTON_NEXT),
        WaitUntil.the(LoginUI.PASSWORD, isVisible()),
        WaitUntil.the(LoginUI.PASSWORD, isEnabled()),
        Enter.theValue(password).into(LoginUI.PASSWORD),
        WaitUntil.the(LoginUI.BUTTON_LOGIN, isVisible()),
        WaitUntil.the(LoginUI.BUTTON_LOGIN, isEnabled()),
        Click.on(LoginUI.BUTTON_LOGIN));

  }


}
