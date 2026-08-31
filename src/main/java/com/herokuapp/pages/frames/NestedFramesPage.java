package com.herokuapp.pages.frames;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    WebElement topFrame;

    public NestedFramesPage switchToTopFrame() {
        driver.switchTo().frame(topFrame);
        return this;
    }
    @FindBy(name = "frame-left")
    WebElement leftFrame;

    public NestedFramesPage switchToLeftFrame() {
        driver.switchTo().frame(leftFrame);
        return this;
    }

    public NestedFramesPage verifyFrameText(String text) {
        String actualText = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(text, actualText);
        return this;
    }

    public NestedFramesPage switchToParentFrame() {
        driver.switchTo().parentFrame();
        return this;
    }
    @FindBy(name = "frame-middle")
    WebElement middleFrame;

    public NestedFramesPage switchToMiddleFrame() {
        driver.switchTo().frame(middleFrame);
        return this;
    }
    @FindBy(name = "frame-right")
    WebElement rightFrame;

    public NestedFramesPage switchToRightFrame() {
        driver.switchTo().frame(rightFrame);
        return this;
    }

    public NestedFramesPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
    @FindBy(name = "frame-bottom")
    WebElement buttonFrame;

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().frame(buttonFrame);
        return this;
    }
}
