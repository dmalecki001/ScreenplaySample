package com.test.sample.utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Synchronized;

import java.io.Serializable;

public class TestDataGenerator implements Serializable {

    private static ThreadLocal<TestDataGenerator> instanceOfDataPackage = ThreadLocal.withInitial(TestDataGenerator::new);
    private static final long serialVersionUID = 531253454563L;

    @Synchronized
    public static TestDataGenerator getTestData() {
        return instanceOfDataPackage.get();
    }

    @Synchronized
    public static void cleanDataPackage() {
        instanceOfDataPackage.remove();
    }

    transient private final Faker faker = new Faker();
    @Getter
    private String emailAddress;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String password;
    @Getter
    private String company;
    @Getter
    private String addressLineOne;
    @Getter
    private String addressLineTwo;
    @Getter
    private String city;
    @Getter
    private String postalCode;
    @Getter
    private String additionalInfo;
    @Getter
    private String homePhone;
    @Getter
    private String mobilePhone;
    @Getter
    private String alias;
    @Getter
    private String id;

    public void generateTestData() {
        emailAddress = generateRandomEmailAddress();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = StringGenerators.generateRandomUUId();
        company = faker.company().name();
        addressLineOne = faker.address().streetAddress();
        addressLineTwo = faker.address().streetAddressNumber() + "/" + faker.address().buildingNumber();
        city = faker.address().city();
        postalCode = StringGenerators.numberBetween(10000, 99999);
        additionalInfo = faker.company().url();
        homePhone = faker.phoneNumber().cellPhone();
        mobilePhone = faker.phoneNumber().cellPhone();
        alias = faker.company().buzzword();
    }

    private String generateRandomEmailAddress() {
        return faker.name().firstName() + "." + faker.name().lastName() + "@test.com";
    }

}
