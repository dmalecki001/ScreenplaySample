package com.test.sample.screenplay_pattern.selenium;

import com.test.sample.selenium.targets.MyAccountTargets;
import com.test.sample.utils.TestDataGenerator;
import net.serenitybdd.screenplay.Question;

public class ValidationQuestions {

    public static Question<String> addressAlias() {
        return actor -> MyAccountTargets.addressAlias(TestDataGenerator.getTestData().getAlias()).resolveFor(actor).getText();
    }
}
