import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class ItStep {

    public static WebDriver driver;

    @BeforeAll
    public static void InitialDriver() {
        System.out.println("Before All InitialDriver method called");

        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void checkText() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("fgjdfkfdgk");
        //search.sendKeys("котики");
        search.submit();

        WebElement nothingFound = driver
                .findElement(By.xpath("//div[contains(@class, 'med card-section') and contains(.,'ничего не найдено')]"));
    }

    @Test
    public void checkCountOfLinksOnTheSearchResult() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("sas adfaads");
        search.submit();

        List<WebElement> listElements = driver.findElements(By.cssSelector(".ellip"));
        assertTrue(listElements.size()>=3, "Link Number '4' Does not exist");

        System.out.println("Quantity of links on the page ".concat("'").concat(title).concat("' = ").concat(String.valueOf(listElements.size())));
        System.out.println("Click on Link: ".concat(" ").concat(String.valueOf(listElements.get(2).getText())));
        listElements.get(2).click();
    }

    @Test
    public void CheckTitleTutBy() {
        driver.get("https://www.tut.by/");
        String title = driver.getTitle();
        System.out.println(title);
        assertTrue(title.contains("TUT.BY"));
    }

    @AfterAll
    public static void quitAll() throws InterruptedException {
        System.out.println("After All method called");
        Thread.sleep(500);

        driver.quit();
        driver = null;
    }
    /**
     * Explicit waits - driver waits until result "by" appears or timeOut
     */
    private static WebElement waitForElementLocatedBy(WebDriver driver, long timeoutSec, By by) {
        return new WebDriverWait(driver, timeoutSec)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
