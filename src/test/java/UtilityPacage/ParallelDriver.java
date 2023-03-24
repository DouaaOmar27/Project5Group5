package UtilityPacage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class ParallelDriver {
    public WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass(alwaysRun = true)
    @Parameters(value = "browser")
    public void startingSettings(String browserName){
        if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().getPageLoadTimeout();
        login();
    }
    @AfterClass(alwaysRun = true)
    public void finishSettings(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    void login(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement emailAddress = driver.findElement(By.id("input-email"));
        emailAddress.sendKeys("tester@test.com" + Keys.TAB + "test123");
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        loginButton.click();
    }
    public void waitMethod(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElements(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void getTextFromElements(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.getText();
    }
    public void sendKeysElements(WebElement element,String msg){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(msg);
    }
}
