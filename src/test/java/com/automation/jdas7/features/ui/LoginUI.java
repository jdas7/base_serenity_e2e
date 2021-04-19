package com.automation.jdas7.features.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target EMAIL = Target.the("correo")
        .located(By.cssSelector("#identifierId"));

    public static final Target BUTTON_NEXT = Target.the("boton siguiente")
        .located(By.cssSelector("#identifierNext"));

    public static final Target PASSWORD = Target.the("contraseña")
        .located(By.cssSelector("#password input"));

    public static final Target BUTTON_LOGIN = Target.the("boton Login")
        .located(By.cssSelector("#passwordNext button"));

}
