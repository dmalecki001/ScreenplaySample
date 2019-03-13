package com.test.sample.screenplay_pattern.selenium;

import com.test.sample.utils.StringGenerators;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.test.sample.selenium.targets.CreateAccountTargets.*;
import static com.test.sample.selenium.targets.LoginPageTargets.getCreateAccountBtn;
import static com.test.sample.selenium.targets.LoginPageTargets.getEmailAddress;
import static com.test.sample.utils.TestDataGenerator.getTestData;

public class ProvideData {

    public static Performable forNewEmailRegistration(){
        return Task.where("{0} provides new email address",
                Enter.theValue(getTestData().getNewEmailAddress()).into(getEmailAddress()),
                Click.on(getCreateAccountBtn()));
    }

    public static Performable forNewPersonalInformation(){
        return Task.where("{0} provides new personal information", Click.on(getMrBtn()),
                Enter.theValue(getTestData().getFirstName()).into(getFirstNameField()),
                Enter.theValue(getTestData().getLastName()).into(getLastNameField()),
                Enter.theValue(getTestData().getNewEmailAddress()).into(getEmailField()),
                Enter.theValue(getTestData().getNewPassword()).into(getPasswordField()),
                SelectFromOptions.byValue(StringGenerators.numberBetween(1,32)).from(getDays()),
                SelectFromOptions.byValue(StringGenerators.numberBetween(1,13)).from(getMonths()),
                SelectFromOptions.byValue(StringGenerators.getRandomYear()).from(getYears()));
    }

    public static Performable forNewAddress(){
        return Task.where("{0} provides new address information",
                Enter.theValue(getTestData().getFirstName()).into(getFirstNameForAddress()),
                Enter.theValue(getTestData().getLastName()).into(getLastNameForAddress()),
                Enter.theValue(getTestData().getCompany()).into(getCompanyField()),
                Enter.theValue(getTestData().getAddressLineOne()).into(getAddressField()),
                Enter.theValue(getTestData().getAddressLineTwo()).into(getSecondAddressField()),
                Enter.theValue(getTestData().getCity()).into(getCityField()),
                SelectFromOptions.byValue(StringGenerators.numberBetween(1,54)).from(getStateField()),
                Enter.theValue(getTestData().getPostalCode()).into(getPostalCodeField()),
                SelectFromOptions.byValue("21").from(getCountryField()));
    }

    public static Performable forAnotherAddress(){
        return Task.where("{0} provides another address information",
                Enter.theValue(getTestData().getAddressLineOne()).into(getAddressField()),
                Enter.theValue(getTestData().getAddressLineTwo()).into(getSecondAddressField()),
                Enter.theValue(getTestData().getCity()).into(getCityField()),
                SelectFromOptions.byValue(StringGenerators.numberBetween(1,54)).from(getStateField()),
                Enter.theValue(getTestData().getPostalCode()).into(getPostalCodeField()),
                SelectFromOptions.byValue("21").from(getCountryField()));
    }

    public static Performable forAdditionalInformation(){
        return Task.where("{0} provides new additional information",
                Enter.theValue(getTestData().getAdditionalInfo()).into(getAdditionalInformation()),
                Enter.theValue(getTestData().getHomePhone()).into(getHomePhoneField()),
                Enter.theValue(getTestData().getMobilePhone()).into(getMobilePhoneField()),
                Enter.theValue(getTestData().getAlias()).into(getAlias()));
    }

    public static Performable forNewsletterSubscription(){
        return Task.where("{0} signs up for newsletter", Click.on(getNewsletterButton()));
    }


}
