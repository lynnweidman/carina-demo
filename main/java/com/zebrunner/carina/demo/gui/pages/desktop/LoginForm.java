package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginFormBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginFormBase.class)
public class LoginForm extends LoginFormBase {

    public LoginForm (WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");

        //this.driver = driver;
        // PageFactory.initElements(driver,this);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath =   "//div[@id='social-connect']//i[contains(@class,'%s')]")
    private ExtendedWebElement headerIcon;

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

    @FindBy(xpath = "//*[@id=\"social-connect\"]/a[8]/i")
    ExtendedWebElement logOutIcon;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/button")
    WebElement headerMenu;

    @FindBy(xpath =  "//*[@id=\"body\"]/div/div[1]/div/div/div[2]/div/h1")
    ExtendedWebElement testUserAccountText;

    @FindBy(id = "login-active")
    ExtendedWebElement userIcon;

    @Override
    public boolean headerIconIsPresent() {
        headerIcon.isPresent();
        return true;
    }

    @Override
    public void clickLoginIcon() {
        loginIcon.click();

    }


    @Override
    public void openHomePage() {
        driver.get("https://www.gsmarena.com/");

    }

    @Override
    public boolean homePageIsOpened() {
        loginIcon.isPresent();
        return true;
    }


    @Override
    public void login(String email, String password) {
        String nickname= "test.user";
        loginIcon.click();
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        submit.click();

        LOGGER.info(nickname + " logged in at " + LocalDateTime.now());

    }

    @Override
    public boolean successfulLogin() {
        logOutIcon.isPresent();
        return true;
    }

    @Override
    public void login2(String email, String password) {
        String nickname= "test.user";
       // driver.get("https://www.gsmarena.com/");
        clickLoginIcon();
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        submit.click();
        LOGGER.info(nickname + " logged in at " + LocalDateTime.now());

    }

    @Override
    public void invalidEmail(String email, String password) {

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

    @Override
    public boolean logOutIconDisplayed() {
        logOutIcon.isPresent();

        return true;
    }

    public HomePageBase getHeaderMenu() {
        headerMenu.click();
        return initPage(getDriver(), HomePageBase.class);

    }

    @Override
    public HomePageBase clickLoginIcon2() {
        loginIcon.click();
        return initPage(getDriver(), HomePageBase.class);

    }

    @Override
    public HomePageBase clickSubmitButton() {
        loginIcon.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void clickSubmitButton2() {
        submit.click();
    }

}
