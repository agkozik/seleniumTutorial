import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItStep {

    public static WebDriver driver;

    @BeforeAll
    public static void InitialDriver() throws Exception {
        System.out.println("Before All InitialDriver method called");

        //String browser = "chrome";
        //String browser = "firefox";
        String browser = "Edge";

        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {

            driver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkTextOnPage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("fgjdfkfdgk");
        //search.sendKeys("котики");
        search.submit();
        myWaitVar(driver, 1, By.id("resultStats"));
    }

    @Test
    public void checkCountOfLinksOnTheSearchResult() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("sas adfaads");
        search.submit();

        List<WebElement> listElements = driver.findElements(By.cssSelector(".ellip"));
        assertTrue(listElements.size() >= 3, "Link Number '4' Does not exist");

        System.out.println("Quantity of links on the page "
                .concat("'").concat(title).concat("' = ").concat(String.valueOf(listElements.size())));
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

    @ParameterizedTest
    @CsvSource({"миша любит,3", "миша любит,5", "миша любит,20"})
    public void contextMenuClickOn3rdElement(String text, int numberItem) throws InterruptedException {

        driver.get("https://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys(text);


        myWaitVar(driver, 10, By.className("sbct"));

        Actions actions = new Actions(driver);

        List<WebElement> menu = driver.findElements(By.className("sbct"));
        System.out.println("Drop list contains "
                .concat(String.valueOf(menu.size())).concat(" items."));

        assertTrue(menu.size() >= numberItem, "The element "
                .concat(String.valueOf(numberItem))
                .concat(" does not exist. The drop list contains less then "
                        .concat(String.valueOf(menu.size())).concat(" items.")));

        actions.moveToElement(menu.get(numberItem - 1)).build().perform();
        menu.get(numberItem - 1).click();
    }

    @AfterAll
    public static void quitAll() throws InterruptedException {
        System.out.println("After All method called");
        Thread.sleep(1000);

        driver.quit();
        driver = null;
    }

    /**
     * Explicit wait - driver waits until result "by" will be visible
     */
    private WebElement myWaitVar(WebDriver driver, long timeoutSec, By by) {

        return new WebDriverWait(driver, timeoutSec)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

