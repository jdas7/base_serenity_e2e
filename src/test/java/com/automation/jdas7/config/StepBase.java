package com.automation.jdas7.config;

import data.DataProvider;
import net.thucydides.core.annotations.Steps;

public abstract class StepBase {
    @Steps(shared = true)
    protected DataProvider dataProvider;
}
