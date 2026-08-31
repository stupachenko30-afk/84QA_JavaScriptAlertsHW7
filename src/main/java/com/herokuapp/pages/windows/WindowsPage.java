package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href='/windows/new']")
    WebElement clickHereLink;

    public WindowsPage clickHere() {
        originalWindow = driver.getWindowHandle();
        click(clickHereLink);
        return this;
    }
    public WindowsPage switchToNewWindow() {


        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        return this;
    }
    @FindBy(css = "h3")
    WebElement WindowTitle;
    public WindowsPage verifyWindowTitle(String text) {
        Assertions.assertTrue(isContainsText(text, WindowTitle));
        return this;
    }
    private String originalWindow;
    public WindowsPage switchToOriginalWindow() {
        driver.switchTo().window(originalWindow);
        return this;
    }
    public WindowsPage verifyNumberOfWindows(int expectedNumber) {
        Assertions.assertEquals(expectedNumber, driver.getWindowHandles().size());
        return this;
    }
    public WindowsPage closeNewWindow() {
        driver.close();
        driver.switchTo().window(originalWindow);
        return this;
    }

}

