package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramesPage returnListOfFrames() {
        //using iframe tag
        System.out.println("The total numbers of iframes are " + iframes.size());

        //by executing java script
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length")
                .toString());
        System.out.println("The total numbers of iframes are " + numberOfFrames);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        return this;
    }

    @FindBy(id = "frame2")
    WebElement frame2;

    @FindBy(id = "framesWrapper")
    WebElement framesWrapper;
    public FramesPage switchToIframeByID() {
        driver.switchTo().frame(frame2);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public FramesPage handleNestedIframes() {
        //return number of iframes
        System.out.println("The total numbers of iframes are " + iframes.size());
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        System.out.println("Frame1 is " + body.getText());
        //return number of iframes in parent iframe
        System.out.println("The total numbers of iframes are " + iframes.size());
        //switch to child iframe
        driver.switchTo().frame(0);
        System.out.println("Frame0 is " + body.getText());
        //switch to parent frame
//        driver.switchTo().parentFrame();
//        System.out.println("Frame1 is " + body.getText());
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());
        return this;
    }
}
