//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
//public class Sample {
//
//    public static void main(String[] args) throws InterruptedException, AWTException {
//
//        String name ="Morty";
//        String surName ="Smith";
//        String prefics = "Vselennaya".concat(String.valueOf((int) (Math.random()*(200+1)) - 100));
//        StringBuilder gmailUser =new StringBuilder().append(name).append(surName).append(prefics);
//
//        //Show the path to WebDriver
//        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        //OnLoad Event
//        driver.get("https://www.gmail.com/mail/help/intl/ru/about.html?de.");
//
//
//        waitForElementLocatedBy(driver, 10, By.xpath("//*[@id='gmail-create-account']"));
//
//        WebElement createButton = driver.findElement(By.xpath("//*[@id='gmail-create-account']"));
//        driver.manage().window().maximize();
//        createButton.click();
//
//        System.out.println("Page title is: " + driver.getTitle());
//
//        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
//        System.out.println("Найдено поле 1");
//        firstName.sendKeys(name);
//        System.out.println("Заполнено поле 1");
//        Thread.sleep(1000);
//
//        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
//        System.out.println("Найдено поле 2");
//        lastName.sendKeys(surName);
//        System.out.println("Заполнено поле 2");
//        Thread.sleep(1000);
//
//        WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
//        System.out.println("Найдено поле 3");
//        userName.sendKeys(gmailUser);
//        System.out.println("Заполнено поле 3");
//        Thread.sleep(1000);
//
////        WebElement viewPass = driver.findElement(By.xpath("//*[@id='view_container']/form/div[2]/div/div[1]/div[3]/div[2]/div/span/span/span[2]"));
////        System.out.println("Найдено поле 4");
////        viewPass.click();
////        Thread.sleep(1000);
//
//        WebElement password = driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input"));
//        System.out.println("Найдено поле 5");
//        password.sendKeys(prefics);
//        System.out.println("Заполнено поле 5");
//        Thread.sleep(1000);
//
//        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='confirm-passwd']/div[1]/div/div[1]/input"));
//        confirmPassword.sendKeys(prefics);
//
//        WebElement nextStep = driver.findElement(By.xpath("//*[@id='accountDetailsNext']"));
//        nextStep.click();
//
//
//
////        WebElement linknext = driver.findElement(By.xpath("//*[@jsname='IHFM4']"));
////        linknext.click();
////
////        JavascriptExecutor jse = (JavascriptExecutor) driver;
////
////        jse.executeScript("window.scrollBy(0,250)");
////
////        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
////        Thread.sleep(500);
////
////        WebElement rightClickElement = driver.findElement(By.linkText("давай я поищу за тебя"));
////        Actions builder = new Actions(driver);
////
////        builder.moveToElement(rightClickElement).contextClick().build().perform();
////
////        Robot robot = new Robot();
////        robot.keyPress(KeyEvent.VK_DOWN);
////        robot.setAutoDelay(100);
////        robot.keyPress(KeyEvent.VK_DOWN);
////        robot.setAutoDelay(100);
////        robot.keyPress(KeyEvent.VK_DOWN);
////        robot.setAutoDelay(100);
////        robot.keyPress(KeyEvent.VK_DOWN);
////        robot.setAutoDelay(100);
////
////        robot.keyPress(KeyEvent.VK_ENTER);
////        robot.setAutoDelay(100);
////
////       // robot.keyRelease(KeyEvent.VK_ENTER);
////
////        //builder.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
////       // builder.sendKeys(Keys.RETURN).build().perform();
////
//
//        Thread.sleep(5000);
//        driver.quit();
//    }
//
//
//    /**
//     * Explicit waits - driver waits until result "by" appears or timeOut
//     */
//    private static WebElement waitForElementLocatedBy(WebDriver driver, long timeoutSec, By by) {
//        return new WebDriverWait(driver, timeoutSec)
//                .until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//}
