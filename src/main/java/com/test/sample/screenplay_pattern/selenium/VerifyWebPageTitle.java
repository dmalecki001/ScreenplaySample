package com.test.sample.screenplay_pattern.selenium;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class VerifyWebPageTitle implements Task {

    private final String title;

    public VerifyWebPageTitle(String title) {
        this.title = title;
    }

    @Override
    @Step("{0} verifies the web page title")
    public <T extends Actor> void performAs(T user) {
        user.should(eventually(seeThat(TheWebPage.title(),
                containsString(this.title))).waitingForNoLongerThan(15).seconds());
    }

    public static VerifyWebPageTitle wasVisible(String title) {
        return Instrumented.instanceOf(VerifyWebPageTitle.class).withProperties(title);
    }
}
