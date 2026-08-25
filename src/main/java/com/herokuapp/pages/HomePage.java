package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.alerts.AlertsPage;
import com.herokuapp.pages.draganddrop.DragAndDropPage;
import com.herokuapp.pages.frames.FramesPage;
import com.herokuapp.pages.windows.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //  <a href="/javascript_alerts">JavaScript Alerts</a>
    @FindBy(css = "a[href$='/javascript_alerts']")
    WebElement alertsLink;
    public AlertsPage getAlertsPage(){
        clickWithJS(alertsLink);
        return new AlertsPage(driver);
    }
    @FindBy(css = "a[href='/windows']")
    WebElement windowsLink;

    public WindowsPage getWindowsPage() {
        clickWithJS(windowsLink);
        return new WindowsPage(driver);
    }
    @FindBy(css = "a[href='/frames']")
    WebElement framesLink;

    public FramesPage getFramesPage() {
        click(framesLink);
        return new FramesPage(driver);
    }
    @FindBy(css = "a[href='/drag_and_drop']")
    WebElement dragAndDropLink;

    public DragAndDropPage getDragAndDropPage() {
        click(dragAndDropLink);
        return new DragAndDropPage(driver);
    }
}

