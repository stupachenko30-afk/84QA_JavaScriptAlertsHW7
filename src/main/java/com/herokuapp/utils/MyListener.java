package com.herokuapp.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;


public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    private final WebDriver driver;

    public MyListener(WebDriver driver) {
        this.driver = driver;
    }

        @Override
        public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

            logger.error("The test has a problem!!!");
            logger.error("**************************");
            logger.error("Method --> {}", method.getName());
            logger.error("Target exception --> {}", e.getTargetException());

            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String link = "screenshots/screen_" + time + ".png";

            logger.error("Screen with error --> {}", link);

            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                Files.createDirectories(new File("screenshots").toPath());
                Files.copy(tmp.toPath(), new File(link).toPath());
            } catch (IOException ex) {
                logger.error("Failed to save screenshot", ex);
            }
        }
    @Override
    public void afterGet(WebDriver driver, String url) {
        logger.info("We opened the site {}", url);
    }
    @Override
    public void afterClick(WebElement element) {
        logger.info("We clicked on {}", element);
        logger.info("****************************");
    }
    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("We enter {} to element {}", keysToSend, element);
        logger.info("****************************");
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("{} contains {}", element, result);
        logger.info("****************************************");
    }
    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        logger.info("{}", actions);
        logger.info("********************************");
    }
}
