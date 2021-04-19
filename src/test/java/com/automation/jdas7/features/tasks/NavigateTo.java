package com.automation.jdas7.features.tasks;

import com.automation.jdas7.features.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
  public static Performable goHomePage() {
    return Task.where("{0} abre la pagina",
        Open.browserOn().the(HomePage.class)
    );
  }
}
