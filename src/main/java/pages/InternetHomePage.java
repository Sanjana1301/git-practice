package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class InternetHomePage extends Form {

    private final ILink fileUploadLink = getElementFactory().getLink(
            By.xpath("//a[normalize-space()='File Upload']"),
            "File Upload Link"
    );

    public InternetHomePage() {
        super(By.xpath("//h1[normalize-space()='Welcome to the-internet']"), "The Internet Home Page");
    }

    public void clickFileUploadLink() {
        fileUploadLink.click();
    }
}
