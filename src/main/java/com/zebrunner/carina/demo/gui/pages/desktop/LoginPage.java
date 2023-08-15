package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {


    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nick-submit")
    ExtendedWebElement loginButton;

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public LoginPage loginUser(User user) {
        writeToLoginTextBox(user.getEmail());
        writeToPasswordTextBox(user.getPassword());
        return clickLoginButton();
    }

    private void writeToPasswordTextBox(String password) {
    }

    private void writeToLoginTextBox(String email) {
    }

}
