package com.test.sample.utils;

import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.List;

public class TestDataGenerator implements Serializable {

    private static ThreadLocal<TestDataGenerator> instanceOfDataPackage = ThreadLocal.withInitial(TestDataGenerator::new);
    public static synchronized TestDataGenerator getTestData() {return instanceOfDataPackage.get();}
    public static synchronized void cleanDataPackage() {
        instanceOfDataPackage.remove();
    }

    private static final long serialVersionUID = 531253454563L;
    private static final Faker faker = new Faker();
    private String newEmailAddress;
    private String firstName;
    private String lastName;
    private String newPassword;
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
    private List<Integer> userIds;
    private List<Integer> subIds;

    public void generateTestData(){
        newEmailAddress = generateRandomEmailAddress();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        newPassword = StringGenerators.generateRandomId();
        company = faker.company().name();
        addressLineOne = faker.address().streetAddress();
        addressLineTwo = faker.address().streetAddressNumber() + "/" + faker.address().buildingNumber();
        city = faker.address().city();
        postalCode = StringGenerators.numberBetween(10000,99999);
        additionalInfo = faker.company().url();
        homePhone = faker.phoneNumber().cellPhone();
        mobilePhone = faker.phoneNumber().cellPhone();
        alias = faker.company().buzzword();
        id = StringGenerators.generateRandomId();
    }

    private String generateRandomEmailAddress(){
        return faker.name().firstName() + "." + faker.name().lastName() + "@test.com";
    }

    public String getNewEmailAddress() {
        return newEmailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNewPassword() {
        return newPassword;
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

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public List<Integer> getSubIds() {
        return subIds;
    }

    public void setSubIds(List<Integer> subIds) {
        this.subIds = subIds;
    }

    public String getHighestUserId() {
        return TestDataManager.getReader().readSpecificProperty("highestUserId");
    }

    public String getHighestId() {
        return TestDataManager.getReader().readSpecificProperty("highestId");
    }

}
