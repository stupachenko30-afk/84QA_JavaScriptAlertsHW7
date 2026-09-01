package com.herokuapp.pages.brokenimage;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

        @FindBy(css = "div.example img")
        List<WebElement> images;

    public BrokenImagesPage verifyBrokenImages() {
        int brokenImagesCount = 0;
        for (WebElement image : images) {
            Object width = js.executeScript(
                    "return arguments[0].naturalWidth;",
                    image);

            if ((Long) width == 0) {
                brokenImagesCount++;
                System.out.println("Broken image: " + image.getAttribute("src"));
            }
        }
        Assertions.assertEquals(2, brokenImagesCount);
        return this;
    }
}


