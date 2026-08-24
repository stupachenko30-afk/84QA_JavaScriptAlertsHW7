package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.frames.IFramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IFramesTests extends TestBase {

    IFramePage iFrame;

    @BeforeEach
    public void precondition() {
        iFrame = new HomePage(driver)
                .getFramesPage()
                .getIFramePage();
    }

    @Test
    public void iframeTextTest() {
        iFrame
                .switchToIFrame()
                .verifyText("Your content goes here.");
    }
    @Test
    public void switchBackFromIFrameTest() {
        iFrame
                .switchToIFrame()
                .verifyText("Your content goes here.")
                .switchToDefaultContent()
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}