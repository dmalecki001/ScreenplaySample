package com.sample.screenplay.selenium.targets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountTargets {

    public static final String MY_ACCOUNT_PAGE_TITLE = "My account - My Store";

    public static Target getMrBtn() {
        return Target.the("Mr. button").located(By.id("id_gender1"));
    }

    public static Target getFirstNameField() {
        return Target.the("First name field").located(By.xpath(".//label[text()='First name ']/following-sibling::input[@id='customer_firstname']"));
    }

    public static Target getLastNameField() {
        return Target.the("Last name field").located(By.xpath(".//label[text()='Last name ']/following-sibling::input"));
    }

    public static Target getEmailField() {
        return Target.the("Email field").located(By.xpath(".//label[text()='Email ']/following-sibling::input"));
    }

    public static Target getPasswordField() {
        return Target.the("Password field").located(By.xpath(".//label[text()='Password ']/following-sibling::input"));
    }

    public static Target getNewsletterButton() {
        return Target.the("Newsletter button").located(By.xpath(".//input[@name='newsletter']"));
    }

    public static Target getFirstNameForAddress() {
        return Target.the("First name").located(By.xpath(".//label[text()='First name ']/following-sibling::input[@id='firstname']"));
    }

    public static Target getLastNameForAddress() {
        return Target.the("Last name").located(By.xpath(".//label[text()='Last name ']/following-sibling::input[@id='lastname']"));
    }

    public static Target getCompanyField() {
        return Target.the("Company field").located(By.xpath(".//label[text()='Company']/following-sibling::input"));
    }

    public static Target getAddressField() {
        return Target.the("Address field").located(By.xpath(".//label[text()='Address ']/following-sibling::input"));
    }

    public static Target getSecondAddressField() {
        return Target.the("2nd Address field").located(By.xpath(".//label[text()='Address (Line 2)']/following-sibling::input"));
    }

    public static Target getCityField() {
        return Target.the("City field").located(By.xpath(".//label[text()='City ']/following-sibling::input"));
    }

    public static Target getStateField() {
        return Target.the("State field").located(By.xpath(".//label[text()='State ']/following-sibling::div/select"));
    }

    public static Target getPostalCodeField() {
        return Target.the("Postal code field").located(By.xpath(".//label[text()='Zip/Postal Code ']/following-sibling::input"));
    }

    public static Target getCountryField() {
        return Target.the("Country field").located(By.xpath(".//label[text()='Country ']/following-sibling::div/select"));
    }

    public static Target getAdditionalInformation() {
        return Target.the("Additional Information").located(By.xpath(".//label[text()='Additional information']/following-sibling::textarea"));
    }

    public static Target getHomePhoneField() {
        return Target.the("Home phone field").located(By.xpath(".//label[contains(text(),'Home phone')]/following-sibling::input"));
    }

    public static Target getMobilePhoneField() {
        return Target.the("Mobile phone field").located(By.xpath(".//label[contains(text(),'Mobile phone')]/following-sibling::input"));
    }

    public static Target getAlias() {
        return Target.the("Alias").located(By.xpath(".//input[@id='alias']"));
    }

    public static Target getRegisterButton() {
        return Target.the("Register button").located(By.id("submitAccount"));
    }

    public static Target getDays() {
        return Target.the("days").located(By.xpath(".//select[@id='days']"));
    }

    public static Target getMonths() {
        return Target.the("months").located(By.xpath(".//select[@id='months']"));
    }

    public static Target getYears() {
        return Target.the("years").located(By.xpath(".//select[@id='years']"));
    }

}
