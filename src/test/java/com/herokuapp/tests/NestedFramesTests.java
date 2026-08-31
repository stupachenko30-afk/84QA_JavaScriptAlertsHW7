package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.frames.NestedFramesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends TestBase {

    NestedFramesPage nestedFrames;

    @BeforeEach
    public void precondition() {
        nestedFrames = new HomePage(driver).getNestedFramesPage();
    }


    @Test
    @Tag("smoky")
    public void nestedFramesTest() {
        new NestedFramesPage(driver)
                .switchToTopFrame()
                .switchToLeftFrame()
                .verifyFrameText("LEFT")
                .switchToParentFrame()
                .switchToMiddleFrame()
                .verifyFrameText("MIDDLE")
                .switchToParentFrame()
                .switchToRightFrame()
                .verifyFrameText("RIGHT")
                .switchToDefaultContent()
                .switchToBottomFrame()
                .verifyFrameText("BOTTOM");
    }
}
