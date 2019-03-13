package com.test.sample.screenplay_pattern.selenium;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.InvalidArgumentException;

public class Authenticate implements Ability {

    private String username;
    private String password;

    public static Authenticate withCredentials(String username, String password) {
        return new Authenticate(username, password);
    }

    public static Authenticate as(Actor actor) {

        if (actor.abilityTo(Authenticate.class) == null) {
            throw new InvalidArgumentException(actor.getName());
        }

        return actor.abilityTo(Authenticate.class);
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

}