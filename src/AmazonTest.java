import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonTest extends Amazon {


    @Test()
    public void amazonHomePageTitle() {
        Assert.assertEquals(driver.getTitle(), amazonTitle);
    }

    @Test
    public void searchHandSanitizer(){
        driver.findElement(By.id(searchBox)).sendKeys(searchHandSanitizer);
        driver.findElement(By.id(searchBox)).submit();
        String actualText=driver.findElement(By.xpath(handSanitizerActualText)).getText();
        Assert.assertEquals(actualText, handSanitizerExpectedText);
    }

    @Test
    public void searchMultipleItems(){
        clearTypeAndClickOnSearch();
        Assert.assertNotNull(getItems(), "watch");
        Assert.assertNotNull(getItems(), "Rage Against The Machine");
    }

    // Tests objects under 'All' search dropdown.
    @Test
    public void allDropDown() {
        List<WebElement> element = getListOfWebElementsById("searchDropdownBox");
        List<String> listOfText = getListOfString(element);
        for (String st : listOfText) {
            System.out.println(st);
        }
        List<String> expectedMenu = listOfText;
        Assert.assertEquals(listOfText, expectedMenu);
    }


    @Test(dataProvider = "validLogins")
    public void testTwoUsersCanLogInSuccessfully(String email, String password) throws InterruptedException {
        signIn(email, password);
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"A3j9qSxBBnA2Qf-yGu46PQ\"]/div[1]/div/h2")).isDisplayed(), true);
        Assert.assertEquals(driver.findElement(By.linkText("We will email you a One Time Password (OTP) to authenticate your request.")).isDisplayed(), true);
    }

    @Test()
    public void testHelpLink(){
        helpLinkClick();
        Assert.assertTrue(helpLinkVerificationText(), "Test Failed");
    }

    @Test
    public void testHelpTitle(){
        helpLinkClick();
        Assert.assertEquals(driver.getTitle(), helpTitle);
    }

    @Test
    public void testRegistryTab(){
        Assert.assertTrue(registryVerificationText(), "Test Failed.");
    }

    @Test
    public void testRegistryTitle(){
        driver.findElement(By.xpath("//a[text()='Registry']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon.com: : Registry");
    }

    @Test
    public void testTodaysDealTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).isDisplayed(), true);
    }

    @Test
    public void testTodaysDealTitle(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
        Assert.assertEquals(driver.getTitle(), "International Shopping: Shop special offers and deals that ship internationally");
    }

    @Test
    public void testGiftCardTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Registry']")).isDisplayed(), true);
    }

    @Test
    public void testGiftTitle(){
        driver.findElement(By.xpath("//a[text()='Registry']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon.com: : Registry");
    }

    @Test
    public void testSellTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Sell']")).isDisplayed(), true);
    }

    @Test
    public void testSellTitle(){
        driver.findElement(By.xpath("//a[text()='Sell']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Sell Products Online with Selling on Amazon.");
    }

    @Test
    public void testHelloSignInTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).isDisplayed(), true);
    }

    @Test
    public void testHelloSignInTitle(){
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
    }

    @Test
    public void testReturnOrdersTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[1]")).isDisplayed(), true);
    }

    @Test
    public void testReturnOrderTitle(){
        driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[1]")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
    }

    @Test
    public void testCartOrdersTab(){
        Assert.assertEquals(driver.findElement(By.id("nav-cart")).isDisplayed(), true);
    }

    @Test
    public void testCardTitle(){
        driver.findElement(By.id("nav-cart")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon.com Shopping Cart");
    }

    @Test
    public void testMusicsTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Amazon Music']")).isDisplayed(), true);
    }

    @Test
    public void testMusicTitle(){
        driver.findElement(By.xpath("//a[text()='Amazon Music']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon Music Unlimited - Stream 60 million songs online now.");
    }

    @Test
    public void testAmazonAdvertisingTab(){
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Amazon Advertising']")).isDisplayed(), true);
    }

    @Test
    public void testAmazonAdvertisingTitle(){
        driver.findElement(By.xpath("//a[text()='Amazon Advertising']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon Advertising: Online advertising on Amazon");
    }

    @Test
    public void testAlexaLink(){
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Alexa']")).isDisplayed(), true);
    }

    @Test
    public void testAlexaLinkTitle(){
        driver.findElement(By.xpath("//a[text()='Alexa']")).click();
        Assert.assertEquals(driver.getTitle(), "Alexa - Keyword Research, Competitive Analysis, &amp; Website Ranking");
    }

    @Test
    public void testAmazonBusinessLink(){
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()=' Your Business']")).isDisplayed(), true);
    }

    @Test
    public void testAmazonBusinessTitle(){
        driver.findElement(By.xpath("//span[text()=' Your Business']")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon Business – Amazon for Work | Amazon Business");
    }
}
