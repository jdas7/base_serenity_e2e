package com.automation.jdas7.features.questions;

import com.automation.jdas7.features.ui.SuccessUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ApprovalQuestion {
    public static Question<String> textApproved() {
        return actor -> Text.of(SuccessUI.TEXT_APPROVED).viewedBy(actor).asString();
    }
}
