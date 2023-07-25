package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class LoginPageBase extends AbstractPage {

    protected LoginPageBase(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract void testLogInIcon();

    public abstract void login(String email, String password);

    public abstract void invalidEmail(String email, String password);

    public abstract String getInvalidEmailText();

    public abstract void invalidPassword(String email, String password);

    public abstract String  getInvalidPasswordText();

}
