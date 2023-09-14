package org.example;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    public static AndroidDriver driver;
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
    public void click(By locator) {
        waitElement(locator);
        find(locator).click();
    }
    public String setXpathByContentDesc(String source, String content) {
        return "//*[@class = '" + source + "' and contains(@content-desc,'" + content + "')]";
    }
    public String setXpathByIndex(String source, String index) {
        return "//" + source + "[@index='" + index + "']";
    }
    public void setText(By locator, String data) {
        waitElement(locator);
        find(locator).click();
        find(locator).sendKeys(data);
    }


}
