package com.herokuapp.pages.alerts;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement jsAlert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirm;

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPrompt;

    @FindBy(id = "result")
    WebElement result;

    public AlertsPage getAlerts() {
        clickWithJS(jsAlert);
        return this;
    }

    public AlertsPage getConfirm() {
        clickWithJS(jsConfirm);
        return this;
    }

    public AlertsPage getPrompt() {
        clickWithJS(jsPrompt);
        return this;
    }

    public AlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage clickOnOption(String option) {
        if (option != null && option.equalsIgnoreCase("Ok")) {
            driver.switchTo().alert().accept();
        } else if (option != null && option.equalsIgnoreCase("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    public AlertsPage typeInAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, result));
        return this;
    }
    public AlertsPage verifyAlertText(String expectedText) {
        String actualText = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedText, actualText);
        return this;
    }
}