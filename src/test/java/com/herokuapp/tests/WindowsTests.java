package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class WindowsTests extends TestBase {
    WindowsPage windows;

    @BeforeEach
    public void precondition() {
        windows = new HomePage(driver).getWindowsPage();
    }

    @Test
    public void openNewWindowTest() {
        windows
                .clickHere()
                .switchToNewWindow()
                .verifyWindowTitle("New Window");
    }
    @Test
    public void switchBackToOriginalWindowTest() {
        windows
                .clickHere()
                .switchToNewWindow()
                .verifyWindowTitle("New Window")
                .switchToOriginalWindow()
                .verifyWindowTitle("Opening a new window");
    }
    @Test
    public void numberOfWindowsTest() {
        windows
                .clickHere()
                .verifyNumberOfWindows(2);
    }
    @Test
    public void closeNewWindowTest() {
        windows
                .clickHere()
                .switchToNewWindow()
                .verifyWindowTitle("New Window")
                .closeNewWindow()
                .verifyNumberOfWindows(1)
                .verifyWindowTitle("Opening a new window");
    }
}
