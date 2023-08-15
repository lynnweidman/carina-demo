package com.zebrunner.carina.demo.gui.components.header;

import com.zebrunner.carina.demo.enums.HeaderButtonLink;
import com.zebrunner.carina.demo.enums.HeaderIconLink;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginForm;
import com.zebrunner.carina.demo.utils.HeaderPageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase{

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(id = "login-active")
    ExtendedWebElement loginIcon;

    /*@FindBy(xpath = "//*[@id=\"header\"]/div/div")
    ExtendedWebElement headerMenuButton;
*/

    @FindBy(id = "header")
    ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//*[@id=\"social-connect\"]")
    ExtendedWebElement headerIcon;

    @Override
    public LoginForm openLoginForm() {
        loginIcon.click();
        //return new HomePage(driver);
        return new LoginForm(driver);
    }

    public AbstractPage clickHeaderMenuButton(HeaderButtonLink headerButtonLink) {
        headerMenuButton.format(headerButtonLink.getValue()).click();
        return new HeaderPageFactory().getPageByHeaderButton(headerButtonLink, getDriver());
    }

    public void clickHeaderMenuIcon(HeaderIconLink headerIconLink) {
        headerIcon.format(headerIconLink.getValue()).click();
    }

}
