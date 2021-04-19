package com.automation.jdas7.features.questions;

import com.automation.jdas7.features.ui.OverflowUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OverflowQuestion {

    public static Question<String> textForm() {
        return actor -> Text.of(OverflowUI.TEXT_OVERFLOW).viewedBy(actor).asString();
    }
}
