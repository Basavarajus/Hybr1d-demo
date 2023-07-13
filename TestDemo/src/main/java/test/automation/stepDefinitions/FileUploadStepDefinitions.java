package test.automation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import test.automation.pages.broken_image.*;
import test.automation.pages.file_uploadPage;

import test.automation.utils.cucumberTestContext;

import static org.junit.Assert.assertTrue;
import static test.automation.pages.file_uploadPage.*;

public class FileUploadStepDefinitions {
    private ChromeDriver driver;


    cucumberTestContext testContextSetup;
    file_uploadPage file_upload;

    public FileUploadStepDefinitions(cucumberTestContext testContextSetup){
        this.testContextSetup = testContextSetup;
        this.file_upload = testContextSetup.pageObjectManager.getFileUploadPage();
    }

    @When("I upload the file with path {string}")
    public void iUploadTheFileWithPath(String filePath) {
        uploadButton.sendKeys(filePath);
        submitButton.click();
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
       Message.getText().contains("File Uploaded!");
        driver.quit();
    }
}

