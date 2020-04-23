package com.sample.screenplay.selenium;

import com.sample.screenplay.selenium.targets.MyAccountTargets;
import com.sample.screenplay.utils.TestDataGenerator;
import net.serenitybdd.screenplay.Question;

public class ValidationQuestions {

    public static Question<String> addressAlias() {
        return Question.about("the address alias").answeredBy(actor ->
                MyAccountTargets.addressAlias(TestDataGenerator.getTestData().getAlias()).resolveFor(actor).getText());
    }
}
