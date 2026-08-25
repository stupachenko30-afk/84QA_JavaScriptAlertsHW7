package com.herokuapp.pages.dropdown;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    public DropDownPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropDownPage selectOption(String option) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
        return this;
    }

    public DropDownPage verifySelectedOption(String option) {
        Select select = new Select(dropdown);
        Assertions.assertEquals(option,
                select.getFirstSelectedOption().getText()
        );
        return this;
    }
}

