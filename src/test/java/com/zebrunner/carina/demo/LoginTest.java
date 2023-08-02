package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.components.header.HeaderMenu;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginFormBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginForm;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.demo.propertiesData.PropertiesData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;


public class LoginTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testLogIn() throws IOException {
        /*HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");
*/
        SoftAssert softAssert = new SoftAssert();

        //I know that we should use HomePage homePage = new HomePage(getDriver());
        //But that is not working on my computer, so I'm having to hardcode it
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LoginForm loginForm = new LoginForm(driver);

        //open homepage
        loginForm.openHomePage();
        softAssert.assertTrue(loginForm.homePageIsOpened());

        //Retrieve email and Decrypt password from properties file
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");

        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);

        loginForm.login(properties.getProperty("email"), Arrays.toString(decodePassword));
        softAssert.assertTrue(loginForm.successfulLogin());

    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidEmail() throws IOException {

        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //open homepage
        LoginForm loginForm = new LoginForm(driver);
        SoftAssert softAssert = new SoftAssert();

        loginForm.openHomePage();
        softAssert.assertTrue(loginForm.homePageIsOpened());

        //Decrypt password from properties file
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");

        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);

        //Enter invalid email and valid password
        loginForm.login("wrongEmail@email.com", new String(decodePassword));
        softAssert.assertEquals(loginForm.getInvalidEmailText(), "Reason: User record not found.", "Reason: User record not found.''Reason: Wrong email.");

    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidPassword() throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //Open homepage
        LoginForm loginForm = new LoginForm(driver);
        SoftAssert softAssert = new SoftAssert();

        loginForm.openHomePage();
        softAssert.assertTrue(loginForm.homePageIsOpened());

        //Get instance of the PropertiesData class to retrieve the password from the properties file.
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));

        //Enter invalid email and valid password
        loginForm.login(properties.getProperty("email"), "changemeee");
        softAssert.assertEquals(loginForm.getInvalidPasswordText(), "Reason: Wrong password.", "Reason: Wrong password.");

    }

    @Test()
    public void testPractice() throws IOException {
/*
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        //Decrypting
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");
        byte[] decryptedPassword = Base64.getDecoder().decode(encryptedPassword);
        String pw = Arrays.toString(decryptedPassword);

        LoginForm loginForm = new LoginForm(getDriver());
        loginForm.login2(properties.getProperty("email"), pw);

        softAssert.assertTrue(loginForm.successfulLogin());

        System.out.println("decrypted password: " + decryptedPassword);*/

    }

    @Test
    public void testEncryption() throws IOException {
       /* String pw = "changeme";
        byte[] encryptPassword = Base64.getEncoder().encode(pw.getBytes());
        System.out.println("Encrypted PW: " + new String(encryptPassword));

        byte[] decodedPassword = Base64.getDecoder().decode(encryptPassword);
        System.out.println("Decrypted PW: " + new String(decodedPassword));*/

/*
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");
        System.out.println("Encrypted password:  " + encryptedPassword);

        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);
        System.out.println("Decrypted PW from properties: " + new String(decodePassword));*/

    }
}