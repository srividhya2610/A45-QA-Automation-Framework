package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public BasePage ( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
//    public void click(By locator) {
    protected void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

//    public WebElement findElement(By locator) {
    protected WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

//    public void doubleClick(By locator) {
    protected void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }


}
