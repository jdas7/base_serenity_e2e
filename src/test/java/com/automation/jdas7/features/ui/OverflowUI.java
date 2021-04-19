package com.automation.jdas7.features.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OverflowUI {

    public static final Target TEXT_OVERFLOW= Target
        .the("Texto de desborde contraseña incorrecta")
        .located(By.cssSelector("#view_container div.OyEIQ.uSvLId div:nth-child(2)"));
}
