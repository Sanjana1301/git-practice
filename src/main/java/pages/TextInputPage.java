package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TextInputPage extends Form {

    private final ITextBox newButtonNameInput = getElementFactory().getTextBox(
            By.id("newButtonName"),
            "New Button Name Input Field"
    );

    private final IButton updatingButton = getElementFactory().getButton(
            By.id("updatingButton"),
            "Updating Button"
    );

    public TextInputPage() {
        super(By.xpath("//h3[normalize-space()='Text Input']"), "Text Input Page");
    }

    public void enterButtonName(String text) {
        newButtonNameInput.clearAndType(text);
    }

    public void clickUpdatingButton() {
        updatingButton.click();
    }

    public String getButtonText() {
        return updatingButton.getText();
    }
}
