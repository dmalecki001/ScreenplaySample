package com.sample.screenplay.selenium;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.sample.screenplay.selenium.ValidationQuestions.addressAlias;
import static com.sample.screenplay.utils.TestDataGenerator.getTestData;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;

public class Validate {

    public static Performable newAddress() {
        return Tasks.instrumented(NewAddressValidation.class);
    }

    class NewAddressValidation implements Interaction {
        @Override
        @Step("{0} attempts to validate the address")
        public <T extends Actor> void performAs(T actor) {
            actor.should(eventually(seeThat(addressAlias(),
                    is(getTestData().getAlias().toUpperCase()))));
        }
    }

}
