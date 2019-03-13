package com.test.sample.step_definitions;

import cucumber.api.java8.En;

public class NonExecutableSteps implements En {

    public NonExecutableSteps() {

        Given("^James has an account with \"([^\"]*)\" PLN$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Given("^James successfully logs into his account$", () -> {
            // Write code here that turns the phrase above into concrete actions
        });

        When("^he attempts to withdraw (.*) PLN$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Then("^he receives an error message$", () -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Then("^he receives an error message that the amount cannot be (\\d+)$", (Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Given("^he corrects the amount to be withdrawn$", () -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Then("^he should have (.*) PLN left on the account$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Given("^he accepts going into debit on his account$", () -> {
            // Write code here that turns the phrase above into concrete actions
        });

        Then("^he has a debit of (\\d+) PLN on his account$", (Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
        });

    }
}
