import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver;

    @BeforeMethod
    public void launchChormeBrowser() {
        String chromeDriver = "webdriver.chrome.driver";
        String chromeDriverPath = "lib/browserDriver/chromedriver.exe";
        // For Chrome Browser
        System.setProperty(chromeDriver, chromeDriverPath);
        driver = new ChromeDriver();
        String url = "https://www.amazon.com/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

}
