package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileMyTestPractice implements IAbstractTest, IMobileUtils {
    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void myPracticeTest() throws MalformedURLException {

        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPageBase = welcomePageBase.clickNextBtn();

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(loginPageBase.verifyNameFieldIsPresent(), "Name field is not present");
            softAssert.assertTrue(loginPageBase.verifyPasswordFieldIsPresent(), "Password field is not present");
            softAssert.assertTrue(loginPageBase.maleRadioButtonIsPresent(), "Male radio button is not present");
            softAssert.assertTrue(loginPageBase.femaleRadioButtonIsPresent(), "Female radio button is not present");
            softAssert.assertTrue(loginPageBase.verifyPrivacyPolicyIsPresent(), "Privacy policy button is not present");

            loginPageBase.typeName(username);
            softAssert.assertTrue(loginPageBase.verifyNameField(), "Name field is not filled");

            loginPageBase.typePassword(password);
            softAssert.assertTrue(loginPageBase.verifyPasswordField(), "Password field is not filled");

            loginPageBase.selectMaleSex();
            softAssert.assertTrue(loginPageBase.isMaleRadioButtonChecked(), "Male radio button is not selected");

            loginPageBase.checkPrivacyPolicyCheckbox();
            softAssert.assertTrue(loginPageBase.isPrivacyPolicyChecked(), "Privacy policy button is not selected");

            softAssert.assertAll();

        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");

        }
}
