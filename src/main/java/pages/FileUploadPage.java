package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FileUploadPage extends Form {

    private final ITextBox chooseFileInput = getElementFactory().getTextBox(
            By.id("file-upload"),
            "Choose File Input"
    );

    private final IButton uploadButton = getElementFactory().getButton(
            By.id("file-submit"),
            "Upload Button"
    );

    private final ILabel uploadedFilesLabel = getElementFactory().getLabel(
            By.id("uploaded-files"),
            "Uploaded Files Name Label"
    );

    public FileUploadPage() {
        super(By.xpath("//h3[normalize-space()='File Uploader']"), "File Upload Page");
    }

    public void selectFile(String absoluteFilePath) {
        chooseFileInput.sendKeys(absoluteFilePath);
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public String getUploadedFileName() {
        uploadedFilesLabel.state().waitForDisplayed();
        return uploadedFilesLabel.getText().trim();
    }
}
