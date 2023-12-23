package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.ilcarro.pages.BasePage.driver;

public class HomePageSteps {

    @Given("User launches browser")
    public void user_launch_browser() {
        new HomePage(driver).launchBrowser();
    }

    @When("User opens ilCarro Home Page")
    public void open_ilCarro_HomePage() {
        new HomePage(driver).openUrl();
    }

    @Then("User verifies Home Page title")
    public void verify_HomePage_title() {
        new HomePage(driver).isHomePageTitleDisplayed();
    }

    @And("User quites browser")
    public void quite_browser() {
        new HomePage(driver).closeBrowser();
    }

}
