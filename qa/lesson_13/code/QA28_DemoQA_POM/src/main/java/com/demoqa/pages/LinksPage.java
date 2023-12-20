package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksPage getAllLinks() {
        String url = "";
        System.out.println("Total links on the Page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //get url-connection and status code
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - "
                        + connection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - "
                        + connection.getResponseMessage());
            }
        } catch (Exception ex) {
            System.out.println(linkUrl + " - "
                    + ex.getMessage() + " is a broken link");
        }
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public LinksPage checkBrokenImages() {
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript
                                ("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("*********************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                }
            } catch (Exception ex) {
                System.out.println("Error occurred");
            }
        }
        return this;
    }
}
