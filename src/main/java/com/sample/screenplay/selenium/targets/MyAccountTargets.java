package com.sample.screenplay.selenium.targets;

import net.serenitybdd.screenplay.targets.Target;

public class MyAccountTargets {

    public static Target tab(String tabName) {
        return Target.the("tab element").locatedBy(".//div//ul//li//span[text()='{0}']").of(tabName);
    }

    public static Target addNewAddressTab() {
        return Target.the("new address btn").locatedBy("//span[text()='Add a new address']");
    }

    public static Target saveBtn() {
        return Target.the("andSaveUserIds btn").locatedBy("//span[contains(text(),'Save')]");
    }

    public static Target addressAlias(String alias) {
        return Target.the("alias").locatedBy(".//h3[contains(text(),'{0}')]").of(alias);
    }

}
