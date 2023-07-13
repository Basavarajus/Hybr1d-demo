package test.automation.stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import test.automation.utils.cucumberTestContext;

import java.io.File;
import java.io.IOException;

public class Hooks {
    cucumberTestContext cucumberTestContext;

    public Hooks(cucumberTestContext cucumberTestContext){
        this.cucumberTestContext = cucumberTestContext;

    }

    @Before
    public void BeforeScenario() throws IOException{

    }

    @After
    public void AfterScenario() throws IOException{
        cucumberTestContext.drivermanager.quitDriver();

    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException{
        WebDriver driver = cucumberTestContext.drivermanager.getDriver();
        if(scenario.isFailed()){
            File sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] filecontent= FileUtils.readFileToByteArray(sourcePath);
        }
    }
}
