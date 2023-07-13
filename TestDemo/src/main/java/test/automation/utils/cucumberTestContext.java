package test.automation.utils;

import org.openqa.selenium.WebDriver;
import test.automation.pages.PageObjectManager;

import java.io.IOException;


public class cucumberTestContext {

    public WebDriver driver;

    public PageObjectManager pageObjectManager;

    public DriverManager drivermanager;

    public GenericUtils genericUtils;


    public cucumberTestContext() throws IOException{
        drivermanager = new DriverManager();
        pageObjectManager = new PageObjectManager(drivermanager.getDriver());
        genericUtils = new GenericUtils(drivermanager.getDriver());
    }

}
