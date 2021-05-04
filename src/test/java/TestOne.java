import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestOne {
    private WebDriver driver;
    private String baseUrl;
    private void assertEquals(String card_number_is_not_valid, String text) {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void testFirstAttempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"card-number-field\"]/label")).click();
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//div[@id='card-number-field']/div/label")).getText());
        }




    @Test
    public void testSecondAttempts() {
        driver.get(baseUrl);
        String Order_number=driver.findElement(By.xpath("//*[@id=\"order-number\"]")).getText();
        String Total=driver.findElement(By.xpath("/html/body/div[1]/form/section[1]/div[3]/div[2]/span[2]")).getText();
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0036");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("ARTEM DASKO");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("228");
        driver.findElement(By.id("order-number")).click();
        driver.findElement(By.id("action-submit")).click();
        assertEquals(Order_number, driver.findElement(By.xpath("//div[@id='payment-item-ordernumber']/div[2]")).getText());
        assertEquals(Total, driver.findElement(By.xpath("/html/body/div/section[2]/div[1]/div[7]/div[2]/span")).getText());
    }


    @Test
    public void testThirdAttempts() {
    driver.get(baseUrl);
    driver.findElement(By.id("input-card-number")).click();
    driver.findElement(By.id("input-card-number")).clear();
    driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
    driver.findElement(By.id("input-card-holder")).click();
    driver.findElement(By.id("input-card-holder")).clear();
    driver.findElement(By.id("input-card-holder")).sendKeys("ARTEM DASKO");
    driver.findElement(By.id("card-expires-month")).click();
    new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
    driver.findElement(By.id("card-expires-month")).click();
    driver.findElement(By.id("card-expires-year")).click();
    new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
    driver.findElement(By.id("card-expires-year")).click();
    driver.findElement(By.id("input-card-cvc")).click();
    driver.findElement(By.id("input-card-cvc")).clear();
    driver.findElement(By.id("input-card-cvc")).sendKeys("228");
    driver.findElement(By.id("action-submit")).click();
    driver.findElement(By.id("failure")).click();
    assertEquals("Decline",driver.findElement(By.xpath("/html/body/div/section[1]/div[3]/div/div[2]/span")).getText());
}


    @After
    public void tearDown() {
        driver.quit();
    }
}