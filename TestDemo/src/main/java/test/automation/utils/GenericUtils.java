package test.automation.utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
    public static WebDriver driver;
    public GenericUtils(WebDriver driver) {

        this.driver = driver;
    }
}
