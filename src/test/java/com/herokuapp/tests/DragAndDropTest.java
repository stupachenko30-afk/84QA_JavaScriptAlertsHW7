package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.draganddrop.DragAndDropPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends TestBase {

    DragAndDropPage DAD;

    @BeforeEach
    public void precondition() {
        DAD = new HomePage(driver)
                .getDragAndDropPage();
    }

    @Test
    public void dragAToBPositiveTest() {
        DAD.dragAToB().verifyDragAndDrop();
    }
    @Test
    public void dragBToAPositiveTest() {
        DAD.dragBToA().verifyDragAndDrop();
    }
    @Test
    @Tag("smoky")
    public void dragAndDropBackTest() {
        DAD.verifyOriginalPosition().dragAToB()
                .verifyDragAndDrop().dragBToA()
                .verifyOriginalPosition();
    }
}