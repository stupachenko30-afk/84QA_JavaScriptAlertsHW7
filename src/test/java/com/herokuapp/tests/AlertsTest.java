package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AlertsTest extends TestBase {

    AlertsPage alerts;

    @BeforeEach
    public void precondition() {
        alerts = new HomePage(driver).getAlertsPage();
    }

    @Test
    public void jsAlertTest() {
        alerts
                .getAlerts()
                .acceptAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test
    public void jsConfirmCancelTest() {
        alerts
                .getConfirm()
                .clickOnOption("Cancel")
                .verifyResult("You clicked: Cancel");
    }
    @Test
    public void jsConfirmOkTest() {
        alerts
                .getConfirm()
                .clickOnOption("Ok")
                .verifyResult("You clicked: Ok");
    }

    @Test
    public void jsPromptTest() {
        alerts
                .getPrompt()
                .typeInAlert("Hello")
                .clickOnOption("Ok")
                .verifyResult("You entered: Hello");
    }
    @Test
    public void jsPromptCancelTest() {
        alerts
                .getPrompt()
                .typeInAlert("Hello")
                .clickOnOption("Cancel")
                .verifyResult("You entered: null");
    }
    @Test
    public void jsPromptEmptyTextTest() {
        alerts
                .getPrompt()
                .typeInAlert("")
                .clickOnOption("Ok")
                .verifyResult("You entered:");
    }
    @Test
    @Tag("smoky")
    public void jsAlertTextTest() {
        alerts
                .getAlerts()
                .verifyAlertText("I am a JS Alert")
                .acceptAlert();
    }
    @Test
    @Disabled
    public void listenerErrorTest() {
        driver.findElement(By.id("no-such-element"));
    }
}