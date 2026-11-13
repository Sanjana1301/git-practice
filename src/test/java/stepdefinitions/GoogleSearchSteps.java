package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.GoogleSearchPage;

public class GoogleSearchSteps {

    private final GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on the Google search page")
    public void verifyUserOnGoogleSearchPage() {
        Assert.assertTrue(googleSearchPage.state().waitForDisplayed(),
                "Google search page should be displayed");
    }

    @When("user enters {string} in the Google search field")
    public void enterSearchText(String text) {
        googleSearchPage.enterSearchText(text);
    }

    @When("user applies the search")
    public void applySearch() {
        googleSearchPage.applySearch();
    }

    @Then("first search result should contain {string}")
    public void verifyFirstSearchResult(String expectedText) {
        String actualResultText = googleSearchPage.getFirstSearchResultText();
        Assert.assertTrue(
                actualResultText.toLowerCase().contains(expectedText.toLowerCase()),
                String.format("Expected first search result '%s' to contain '%s'",
                        actualResultText, expectedText)
        );
    }
}