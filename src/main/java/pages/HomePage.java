package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ILink textInputLink = getElementFactory().getLink(
            By.xpath("//a[normalize-space()='Text Input']"),
            "Text Input Link"
    );

    public HomePage() {
        super(By.id("title"), "UI Testing Playground Home Page");
    }

    public void clickTextInputLink() {
        textInputLink.click();
    }
}
