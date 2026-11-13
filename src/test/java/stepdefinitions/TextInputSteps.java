package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.TextInputPage;

import java.util.UUID;

public class TextInputSteps {

    private final HomePage homePage = new HomePage();
    private final TextInputPage textInputPage = new TextInputPage();
    private String randomText;

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");
    }

    @When("User clicks on 'Text Input' link")
    public void userClicksOnTextInputLink() {
        homePage.clickTextInputLink();
    }

    @Then("Text Input page should be open")
    public void textInputPageShouldBeOpen() {
        Assert.assertTrue(textInputPage.state().waitForDisplayed(), "Text Input page did not open");
    }

    @When("User enters random text into the text field")
    public void userEntersRandomTextIntoTheTextField() {
        randomText = "Test_" + UUID.randomUUID().toString().substring(0, 8);
        textInputPage.enterButtonName(randomText);
    }

    @When("User clicks the updating button")
    public void userClicksTheUpdatingButton() {
        textInputPage.clickUpdatingButton();
    }

    @Then("Text displayed on button should be the same as entered")
    public void textDisplayedOnButtonShouldBeTheSameAsEntered() {
        Assert.assertEquals(textInputPage.getButtonText(), randomText, "Button text does not match!");
    }
}
