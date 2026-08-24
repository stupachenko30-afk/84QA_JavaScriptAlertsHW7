package com.herokuapp.pages.frames;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframe")
    WebElement iframe;

    public IFramePage switchToIFrame() {
        driver.switchTo().frame(iframe);
        return this;
    }
    @FindBy(id = "tinymce")
    WebElement textArea;

    public IFramePage verifyText(String text) {
        Assertions.assertTrue(isContainsText(text, textArea));
        return this;
    }
    public IFramePage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
    @FindBy(css = "h3")
    WebElement pageTitle;

    public IFramePage verifyPageTitle(String text) {
        Assertions.assertTrue(isContainsText(text, pageTitle));
        return this;
    }
}