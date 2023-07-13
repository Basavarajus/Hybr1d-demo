package test.automation.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;

    public file_uploadPage file_upload;
    public broken_image broken_image;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public file_uploadPage getFileUploadPage(){
           file_upload = new file_uploadPage(driver);
           return file_upload;
    }

    public broken_image getBrokenImagePage(){
        broken_image = new broken_image(driver);
        return broken_image;
    }
}
