package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.enums.HeaderIconLink;
import com.zebrunner.carina.demo.gui.pages.common.User;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginForm;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.demo.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginDynamicTest implements IAbstractTest {

    @Test(description = "Login scenarios", dataProvider = "Login scenarios")
    @MethodOwner(owner = "Lynn Weidman")
    public void testDynamicLogin (User user, String message) throws IOException {

        SoftAssert softAssert = new SoftAssert();

        //Open homepage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        LoginPage loginPage = loginForm.loginUser(user);

        softAssert.assertEquals(loginForm.successfulLogin(), "test.user-user account");

        softAssert.assertAll();

    }


    @DataProvider(parallel = true, name = "login scenarios")
    public Object[][] dataProviderTest() {
        return new Object[][]{
                {new UserService().getUser(), ""},
                {new UserService().getUserWithInvalidEmail(), "Reason: User record not found."},
                {new UserService().getUserWithInvalidPassword(), "Reason: Wrong password."}
        };
    }
}
