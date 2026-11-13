package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchPage extends Form {

    private final ITextBox searchBox = getElementFactory().getTextBox(
            By.name("q"), "Google Search Field");
    private final IButton searchButton = getElementFactory().getButton(
            By.name("btnK"), "Google Search Button");
    private final ILabel firstSearchResult = getElementFactory().getLabel(
            By.cssSelector("#search .MjjYud h3, #search h3"), "First Search Result");

    public GoogleSearchPage() {
        super(By.tagName("body"), "Google Search Form");
    }

    public void enterSearchText(String text) {
        searchBox.state().waitForDisplayed();
        searchBox.clearAndType(text);
    }

    public void applySearch() {
        searchBox.submit();
    }

    public String getFirstSearchResultText() {
        firstSearchResult.state().waitForDisplayed();
        return firstSearchResult.getText();
    }
}