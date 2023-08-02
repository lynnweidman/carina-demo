package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class LoginFormBase extends AbstractPage {

    protected LoginFormBase(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //public abstract void login(String email, String password);
    public abstract void login(String email, String password);

    public abstract void login2(String email, String password);

    public abstract void clickLoginIcon();

    public abstract void openHomePage();

    public abstract boolean homePageIsOpened();

    public abstract HomePageBase clickLoginIcon2();

    public abstract void clickSubmitButton2();

    public abstract HomePageBase clickSubmitButton();

    public abstract boolean successfulLogin();

    public abstract boolean headerIconIsPresent();

    public abstract void invalidEmail(String email, String password);

    public abstract String getInvalidEmailText();

    public abstract void invalidPassword(String email, String password);

    public abstract String  getInvalidPasswordText();

    public abstract boolean logOutIconDisplayed();


}
