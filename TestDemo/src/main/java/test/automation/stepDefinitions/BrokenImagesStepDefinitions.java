package test.automation.stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import test.automation.pages.broken_image;
import test.automation.utils.cucumberTestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static test.automation.pages.broken_image.*;

import static org.junit.Assert.assertEquals;

public class BrokenImagesStepDefinitions {
    public WebDriver driver;

     cucumberTestContext testContextSetup;
     broken_image broken_image;

    public BrokenImagesStepDefinitions(cucumberTestContext testContextSetup){
        this.testContextSetup = testContextSetup;
        this.broken_image = testContextSetup.pageObjectManager.getBrokenImagePage();
    }


    @Given("I am on the webpage {string}")
    public void iAmOnTheWebpage(String url) {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("I validate the images")
    public void iValidateTheImages() throws IOException {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<String> brokenImages = new ArrayList<>();
        Integer iBrokenImageCount = 0;
        System.out.println("The page under test has " +  broken_image.BrokenImage.size() + " images");
        for (WebElement img : broken_image.BrokenImage) {
            if (img != null) {
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(img.getAttribute("src"));
                HttpResponse response = client.execute(request);
                /* For valid images, the HttpStatus will be 200 */
                if (response.getStatusLine().getStatusCode() != 200) {
                    System.out.println(img.getAttribute("outerHTML") + " is broken.");
                    iBrokenImageCount++;
                }
            }
        }
    }


    @Then("I should see the list of broken images")
    public void iShouldSeeTheListOfBrokenImages() {
//        List<String> brokenImages = (List<String>) driver.getScenario().getData("brokenImages");
//        assertEquals("There are broken images on the page", 0, brokenImages.size());
        driver.quit();
    }
}
