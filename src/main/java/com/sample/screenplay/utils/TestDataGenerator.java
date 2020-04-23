package com.sample.screenplay.utils;

import com.github.javafaker.Faker;

import java.io.Serializable;

public class TestDataGenerator implements Serializable {

    private static final long serialVersionUID = 531253454563L;
    private static ThreadLocal<TestDataGenerator> instanceOfDataPackage = ThreadLocal.withInitial(TestDataGenerator::new);
    transient private final Faker faker = new Faker();
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
    private String company;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String postalCode;
    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;
    private String alias;
    private String id;

    public static TestDataGenerator getTestData() {
        synchronized (TestDataGenerator.class) {
            return instanceOfDataPackage.get();
        }
    }

    public static void cleanDataPackage() {
        synchronized (TestDataGenerator.class) {
            instanceOfDataPackage.remove();
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAlias() {
        return alias;
    }

    public String getId() {
        return id;
    }

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
