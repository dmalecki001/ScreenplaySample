package com.sample.screenplay.selenium;

import com.sample.screenplay.selenium.targets.LoginPageTargets;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class LogIntoTheAccount implements Task {

    public static LogIntoTheAccount withCredentials() {
        return Instrumented.instanceOf(LogIntoTheAccount.class).newInstance();
    }

    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }

    @Override
    @Step("{0} attempts to log into account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPageTargets.getSignInBtn()),
                Enter.theValue(authenticated(actor).username()).into(LoginPageTargets.getLoginEmailAddress()),
                Enter.theValue(authenticated(actor).password()).into(LoginPageTargets.getPassword()),
                Click.on(LoginPageTargets.getSignIntoTheAccountBtn()));
    }

}
