package com.zebrunner.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectMaleSex();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

	public abstract CarinaDescriptionPageBase login();

	public abstract boolean maleRadioButtonIsPresent();

	public abstract boolean femaleRadioButtonIsPresent();

	public abstract boolean verifyNameFieldIsPresent();

	public abstract boolean verifyPasswordFieldIsPresent();

	public abstract boolean verifyPrivacyPolicyIsPresent();

	public abstract boolean verifyNameField();

	public abstract boolean verifyPasswordField();

	public abstract boolean isMaleRadioButtonChecked();

	public abstract boolean isPrivacyPolicyChecked();

}
