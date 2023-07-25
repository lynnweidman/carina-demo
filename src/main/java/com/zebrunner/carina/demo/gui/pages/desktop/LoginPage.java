package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
       // PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login-active")
    private ExtendedWebElement loginIcon;

    @FindBy(id= "email")
    WebElement emailTextbox;

    @FindBy(id = "upass")
    WebElement passwordTextbox;

    @FindBy(id="nick-submit")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div[2]/p")
    WebElement wrongEmailText;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div[2]/p")
    WebElement wrongPasswordText;

//Testing login Icon
    @Override
    public void testLogInIcon() {
        driver.get("https://www.gsmarena.com/");
        loginIcon.click();
    }


    @Override
    public void login(String email, String password) {
        String nickname= "test.user";
        driver.get("https://www.gsmarena.com/");

        loginIcon.click();
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        submit.click();

        LOGGER.info(nickname + " logged in at " + LocalDateTime.now());

    }

    @Override
    public void invalidEmail(String email, String password) {
        driver.get("https://www.gsmarena.com/");

        loginIcon.click();
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        submit.click();

    }

    public String getInvalidEmailText() {
        String emailText = wrongEmailText.getText();
        return emailText;
    }

    @Override
    public void invalidPassword(String email, String password) {
        driver.get("https://www.gsmarena.com/");

        loginIcon.click();
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        submit.click();
    }

    @Override
    public String getInvalidPasswordText() {
        String passwordText = wrongPasswordText.getText();
        return passwordText;
    }


}

