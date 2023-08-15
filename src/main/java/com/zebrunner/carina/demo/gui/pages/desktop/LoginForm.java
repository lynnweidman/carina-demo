package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.enums.HeaderIconLink;
import com.zebrunner.carina.demo.gui.components.footer.FooterMenu;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginFormBase;
import com.zebrunner.carina.demo.gui.pages.common.User;
import com.zebrunner.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginFormBase.class)
public class LoginForm extends LoginFormBase {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "header")
    ExtendedWebElement headerIcon;

    @FindBy(id = "login-active")
    ExtendedWebElement loginIcon;

    @FindBy(id = "email")
    ExtendedWebElement emailTextbox;

    @FindBy(id = "upass")
    ExtendedWebElement passwordTextbox;

    @FindBy(id = "nick-submit")
    ExtendedWebElement submit;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/button")
    WebElement headerMenu;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div[2]/p")
    ExtendedWebElement invalidEmailText;

    @FindBy(id = "login-active")
    ExtendedWebElement userIcon;

    @FindBy(className="article-info-name")
    ExtendedWebElement validUserAccountText;

    @FindBy(xpath="//*[@id=\"body\"]/div/div[2]/p")
    ExtendedWebElement invalidPassword;

   /* @Override
    public void openHomePage() {
        driver.get("https://www.gsmarena.com/");

    }*/

    @Override
    public void clickLoginIcon() {
        loginIcon.click();

    }


    @Override
    public boolean homePageIsOpened() {
        loginIcon.isPresent();
        return true;
    }

    public boolean loginFormIsOpened() {
        emailTextbox.isPresent();
        return true;
    }


    @Override
    public void login(String email, String password) {
        String nickname = "test.user";
        emailTextbox.type(email);
        passwordTextbox.type(password);
        submit.click();

        LOGGER.info(nickname + " logged in at " + LocalDateTime.now());

    }



    public String getInvalidEmailText() {
        String invalidEmailTextMessage = invalidEmailText.getText() ;
        return invalidEmailTextMessage;
    }

    @Override
    public String successfulLogin() {
        loginIcon.click();
        String userAccount = validUserAccountText.getText();
        return userAccount;
    }


    public String getInvalidPasswordText() {
        String invalidPasswordText = invalidPassword.getText();
        return invalidPasswordText;
    }


    @Override
    public HomePageBase clickSubmitButton() {
        loginIcon.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    public void clickHeaderMenuIcon(HeaderIconLink headerIconLink) {
        loginIcon.format(headerIconLink.getValue()).click();
    }

    public LoginPage loginUser(User user) { return loginUser(user);}

}