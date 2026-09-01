package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.brokenimage.BrokenImagesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesTests extends TestBase {

    BrokenImagesPage brokenImages;

    @BeforeEach
    public void precondition() {
        brokenImages = new HomePage(driver).getBrokenImagesPage();
    }

    @Test
    public void brokenImagesTest() {
        brokenImages
                .verifyBrokenImages();
    }
}
