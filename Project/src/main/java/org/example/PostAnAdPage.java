package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static io.appium.java_client.MobileBy.AndroidUIAutomator;


public class PostAnAdPage extends BasePage {
    public PostAnAdPage(AndroidDriver driver) {
        super(driver);
    }
    public By postAnAddButton = By.xpath(setXpathByContentDesc("android.widget.FrameLayout","Post an Ad"));
    public By mobileNumberTextBox = By.xpath(setXpathByIndex("android.widget.EditText","1"));
    public By passwordTextBox = By.xpath(setXpathByIndex("android.widget.EditText","0"));
    public By loginButton = By.xpath(setXpathByIndex("android.view.View","6"));
    public By okButton = By.xpath(setXpathByIndex("android.widget.Button","0"));
    public By chooseCategory = By.id("com.forsale.forsale:id/chooseCategoryField");
    public By nextButton = AndroidUIAutomator ("new UiSelector().text(\"Next\")");
    public By servicesCategory = By.xpath(setXpathByIndex("android.view.ViewGroup","4"));
    public By satellite = By.xpath(setXpathByIndex("android.view.ViewGroup","5"));
    public By chooseListing = By.id("com.forsale.forsale:id/chooseDistrictField");
    public By chooseDistrict = By.id("com.forsale.forsale:id/locationSelectorText");
    public By theDistrict = AndroidUIAutomator ("new UiSelector().text(\"Kuwait City\")");
    public By doneButton = By.id("com.forsale.forsale:id/btnProceed");
    public By doneChoice = AndroidUIAutomator ("new UiSelector().text(\"Done\")");
    public By titleTextBox = By.id("com.forsale.forsale:id/adTitleField");
    public By mediaTitle = AndroidUIAutomator ("new UiSelector().text(\"Add Media\")");

    public void clickPostAnAd(){
        click(postAnAddButton);
    }

    public void enterMobileNumber(){
    setText(mobileNumberTextBox,"00000111");
    }
    public void enterPassword(){
        setText(passwordTextBox,"4saleTest");
    }
    public void clickLoginButton(){
        click(loginButton);
    }

    public void clickOkButton(){
        click(okButton);
    }
    public void selectCategory(){
        click(chooseCategory);
        click(servicesCategory);
        click(satellite);
    }
    public void clickNextButton(){
        click(nextButton);
    }
    public void assertErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By toastLocator = By.xpath("//android.widget.Toast");
        WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
        String toastMessage = toastElement.getText();
        String expectedMessage = "Kindly Fill all the required information!";
        Assert.assertEquals(expectedMessage, toastMessage);
    }
    public void chooseListing(){
        click(chooseListing);
    }
    public void chooseDistrict(){
        click(chooseDistrict);
        click(theDistrict);
        click(doneButton);
    }
    public void clickDone(){
        click(doneChoice);
    }
    public void enterTheTitle(){
        setText(titleTextBox,"TV Services");
    }
    public void assertMediaPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mediaPageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(mediaTitle));
        String actualText = mediaPageTitle.getText();
        String expectedText = "Add Media";
        Assert.assertEquals(expectedText, actualText);
    }


}
