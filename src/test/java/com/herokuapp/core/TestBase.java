package com.herokuapp.core;

import com.herokuapp.utils.MyListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", "chrome"));

    @BeforeEach
    public void init() {
        driver = app.start();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }
}