package com.sample.screenplay.selenium;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.InvalidArgumentException;

import java.util.Objects;

public class Authenticate implements Ability {

    private String username;
    private String password;

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate withCredentials(String username, String password) {
        return new Authenticate(username, password);
    }

    public static Authenticate as(Actor actor) {
        Authenticate authenticate = actor.abilityTo(Authenticate.class);
        if (Objects.isNull(authenticate)) {
            throw new InvalidArgumentException(actor.getName());
        }
        return authenticate;
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

}