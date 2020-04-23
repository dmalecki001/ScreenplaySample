package com.sample.screenplay.selenium.targets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageTargets {

    public static Target getSignInBtn() {
        return Target.the("sign in button").located(By.className("login"));
    }

    public static Target getCreateAccountBtn() {
        return Target.the("create an account").located(By.id("SubmitCreate"));
    }

    public static Target getEmailAddress() {
        return Target.the("email address").located(By.xpath(".//label[text()='Email address']/following-sibling::input[@id='email_create']"));
    }

    public static Target getLoginEmailAddress() {
        return Target.the("email address").located(By.xpath(".//label[text()='Email address']/following-sibling::input[@id='email']"));
    }

    public static Target getPassword() {
        return Target.the("password").located(By.xpath(".//label[text()='Password']/following-sibling::span/input[@id='passwd']"));
    }

    public static Target getSignIntoTheAccountBtn() {
        return Target.the("sign in button").located(By.id("SubmitLogin"));
    }
}
