package com.test.sample.step_definitions;

import com.test.sample.screenplay_pattern.selenium.*;
import com.test.sample.selenium.pages.HomePage;
import com.test.sample.selenium.targets.CreateAccountTargets;
import com.test.sample.selenium.targets.LoginPageTargets;
import com.test.sample.selenium.targets.MyAccountTargets;
import com.test.sample.selenium.webdriver_factory.WebDriverFactory;
import cucumber.api.java8.En;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static com.test.sample.utils.TestDataManager.getDeserializedData;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class GUIStepDefinitions extends BaseDefinitions implements En {

    public GUIStepDefinitions() {

        Given("(.*) can browse the web", (String actor) ->
                theActorCalled(actor).whoCan(BrowseTheWeb.with(new WebDriverFactory().getWebdriver())));

        When("(.*) attempts to provide data for new account registration", (String actor) -> {
            theActorCalled(actor).attemptsTo(
                    Click.on(LoginPageTargets.getSignInBtn()),
                    ProvideData.forNewEmailRegistration(),
                    ProvideData.forNewPersonalInformation(),
                    ProvideData.forNewAddress(),
                    ProvideData.forAdditionalInformation());
        });

        Then("(.*) should verify that the account was successfully created", (String actor) ->
                theActorCalled(actor).attemptsTo(
                        Click.on(CreateAccountTargets.getRegisterButton()),
                        VerifyWebPageTitle
                        .wasVisible(CreateAccountTargets.MY_ACCOUNT_PAGE_TITLE)));

        Given("(.*) successfully opens the home page", (String actor) ->
                theActorCalled(actor).attemptsTo(Open.browserOn().the(new HomePage())));

        When("(.*) attempts to provide login data", (String actor) -> {
            theActorCalled(actor).whoCan(
                    Authenticate.withCredentials(
                            getDeserializedData().getEmailAddress(), getDeserializedData().getPassword()));
            theActorCalled(actor).attemptsTo(
                    LogIntoTheAccount.withCredentials());
        });

        Then("(.*) should successfully log into the account", (String actor) ->
                theActorCalled(actor).attemptsTo(
                        VerifyWebPageTitle
                        .wasVisible(CreateAccountTargets.MY_ACCOUNT_PAGE_TITLE)));

        Given("(.*) opens \"([^\"]*)\" tab", (String actor, String tabName) ->
                theActorCalled(actor).attemptsTo(Click.on(MyAccountTargets.tab(tabName))));

        When("(.*) attempts to add a new address", (String actor) ->
                theActorCalled(actor).attemptsTo(
                        Click.on(MyAccountTargets.addNewAddressTab()),
                        ProvideData.forAnotherAddress(),
                        ProvideData.forAdditionalInformation(),
                        Click.on(MyAccountTargets.saveBtn())));

        Then("(.*) should verify that the new address has been added", (String actor) -> {
            theActorCalled(actor).attemptsTo(Validate.newAddress());
        });

    }
}
