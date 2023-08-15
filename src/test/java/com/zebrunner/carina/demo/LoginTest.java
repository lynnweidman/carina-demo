package com.zebrunner.carina.demo;


import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.*;
import java.util.Base64;
import java.util.Properties;


public class LoginTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Lynn Weidman")
    public void testLogIn() throws IOException {

        SoftAssert softAssert = new SoftAssert();

        //Open homepage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Open login form
        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        softAssert.assertTrue(loginForm.loginFormIsOpened(), "Login form is not opened.");

        //Retrieve email and Decrypt password from properties file
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");

        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);

        loginForm.login(properties.getProperty("email"),  new String(decodePassword));
        softAssert.assertEquals(loginForm.successfulLogin(), "test.user - user account");

        softAssert.assertAll();

    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidEmail() throws IOException {

        SoftAssert softAssert = new SoftAssert();

        //Open homepage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Open login form
        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        softAssert.assertTrue(loginForm.loginFormIsOpened(), "Login form is not opened.");

        //Decrypt password from properties file
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");

        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);

        //Enter invalid email and valid password
        loginForm.login("wrongEmail@email.com", new String(decodePassword));
        softAssert.assertEquals(loginForm.getInvalidEmailText(), "Reason: User record not found.", "Reason: User record not found.''Reason: Wrong email.");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidPassword() throws IOException {

        SoftAssert softAssert = new SoftAssert();

        //Open homepage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Open login form
        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        softAssert.assertTrue(loginForm.loginFormIsOpened(), "Login form is not opened.");

        //Get instance of the PropertiesData class to retrieve the password from the properties file.
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));

        //Enter invalid email and valid password
        loginForm.login(properties.getProperty("email"), "changemeee");
        softAssert.assertEquals(loginForm.getInvalidPasswordText(),("Reason: Wrong password."), "Did not get invalid password message");

        softAssert.assertAll();
    }

    //@Test
   /* public void testEncryption() throws IOException {
        String pw = "Password*555";
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

       /* Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\carina-demo\\src\\test\\resources\\Login.properties"));
        String encryptedPassword = properties.getProperty("encryptedPassword");
        System.out.println("Encryped pw ======" + encryptedPassword);
        byte[] decryptedPassword = Base64.getDecoder().decode(encryptedPassword);
        String pw = Arrays.toString(decryptedPassword);
        System.out.println("Decryped pa ====  " + pw);*/

    }


