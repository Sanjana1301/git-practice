package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FileUploadPage;
import pages.InternetHomePage;

import java.nio.file.Paths;

public class FileUploadSteps {

    private final InternetHomePage homePage = new InternetHomePage();
    private final FileUploadPage fileUploadPage = new FileUploadPage();

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @Then("The Internet home page should be open")
    public void theInternetHomePageShouldBeOpen() {
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed!");
    }

    @When("User clicks on 'File Upload' link")
    public void userClicksOnFileUploadLink() {
        homePage.clickFileUploadLink();
    }

    @Then("File Upload page should be open")
    public void fileUploadPageShouldBeOpen() {
        Assert.assertTrue(fileUploadPage.state().waitForDisplayed(), "File Upload page is not open!");
    }

    @When("User selects {string} file to upload")
    public void userSelectsFileToUpload(String fileName) {
        String absolutePath = Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath()
                .toString();
        fileUploadPage.selectFile(absolutePath);
    }

    @When("User clicks on the 'Upload' button")
    public void userClicksOnTheUploadButton() {
        fileUploadPage.clickUploadButton();
    }

    @Then("Uploaded file name {string} should be displayed")
    public void uploadedFileNameShouldBeDisplayed(String expectedFileName) {
        String actualFileName = fileUploadPage.getUploadedFileName();
        Assert.assertEquals(actualFileName, expectedFileName, "Uploaded file name mismatch!");
    }
}
