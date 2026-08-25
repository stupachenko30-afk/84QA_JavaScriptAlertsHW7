package com.herokuapp.pages.draganddrop;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "column-a")
    WebElement columnA;
    @FindBy(id = "column-b")
    WebElement columnB;
    public DragAndDropPage dragAToB() {
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }
    public DragAndDropPage verifyDragAndDrop() {
        Assertions.assertEquals("B", columnA.getText());
        Assertions.assertEquals("A", columnB.getText());
        return this;
    }
    public DragAndDropPage dragBToA() {
        actions.dragAndDrop(columnB, columnA).perform();
        return this;
    }
    public DragAndDropPage verifyOriginalPosition() {
        Assertions.assertEquals("A", columnA.getText());
        Assertions.assertEquals("B", columnB.getText());
        return this;
    }
}

