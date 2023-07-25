package com.zebrunner.carina.demo;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class LoginTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testLogIn()  {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lcwtr\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("s9rowa@mail.ru", "changeme");
    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidEmail() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lcwtr\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidEmail("wrongEmail@email.com", "changeme");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getInvalidEmailText(), "Reason: User record not found.", "Reason: User record not found.''Reason: Wrong email.");

    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testInvalidPassword() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lcwtr\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidPassword("s9rowa@mail.ru", "changemee");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getInvalidPasswordText(), "Reason: Wrong password.", "Reason: Wrong password.");

    }
}