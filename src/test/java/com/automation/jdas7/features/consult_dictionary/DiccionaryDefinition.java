package com.automation.jdas7.features.consult_dictionary;

import com.automation.jdas7.features.consult_dictionary.steps.DiccionarySteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DiccionaryDefinition {

    @Steps
    DiccionarySteps anna;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        anna.is_the_home_page();
    }

    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        anna.looks_for(word);
    }

    @Then("they should see the definition '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        anna.should_see_definition(definition);
    }

}
