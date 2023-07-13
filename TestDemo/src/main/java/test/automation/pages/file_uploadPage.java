package test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class file_uploadPage {
    public WebDriver driver;

    public file_uploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "file-upload")
    public static WebElement uploadButton;

    @FindBy(id = "file-submit")
    public static WebElement submitButton;

    @FindBy(tagName = "h3")
    public static WebElement Message;
}
