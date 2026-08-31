package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.dropdown.DropDownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DropDownTest extends TestBase {
    DropDownPage dropDP;

    @BeforeEach
    public void precondition(){
        dropDP = new HomePage(driver).getDropDownPage();
    }
    @Test
    public void defaultOptionTest() {
        dropDP.verifySelectedOption("Please select an option");
    }
    @Test
    public void selectOption1Test() {
        dropDP.selectOption("Option 1")
                .verifySelectedOption("Option 1");
    }

    @Test
    @Tag("smoky")
    public void selectOption2Test() {
        dropDP.selectOption("Option 2")
                .verifySelectedOption("Option 2");
    }
}
