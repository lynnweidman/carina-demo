package com.zebrunner.carina.demo.utils;

import com.zebrunner.carina.demo.enums.HeaderButtonLink;
import com.zebrunner.carina.demo.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

public class HeaderPageFactory {
    public AbstractPage getPageByHeaderButton(HeaderButtonLink headerButtonLink, WebDriver driver) {
        switch (headerButtonLink.getValue()) {
           // case "Phone Finder":
               // return new PhoneFinderSearchPage(driver);

            case "News":
                return new NewsPage(driver);

            default:
                throw new NotImplementedException("Page objects isn't implemented");
        }
    }
}
