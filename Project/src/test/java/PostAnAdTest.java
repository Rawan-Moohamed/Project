import jdk.jfr.Description;
import org.testng.annotations.Test;


public class PostAnAdTest extends BaseTest {

    @Description("Check that there is a validation message will be displayed without filling all required data " +
            "when posting an Ad")
    @Test(priority = 0, enabled = true)
    private void checkForValidationMessagePostAnAd(){
        postAnAdPage.waitElement(postAnAdPage.postAnAddButton);
        postAnAdPage.clickPostAnAd();
        postAnAdPage.enterMobileNumber();
        postAnAdPage.enterPassword();
        postAnAdPage.clickLoginButton();
        postAnAdPage.clickOkButton();
        postAnAdPage.selectCategory();
        postAnAdPage.clickNextButton();
        postAnAdPage.assertErrorMessage();
    }
    @Description("Check that successfully posting an Ad")
    @Test(priority = 1, enabled = true)
    private void checkForSuccessPostAnAd(){
        postAnAdPage.waitElement(postAnAdPage.postAnAddButton);
        postAnAdPage.clickPostAnAd();
        postAnAdPage.enterMobileNumber();
        postAnAdPage.enterPassword();
        postAnAdPage.clickLoginButton();
        postAnAdPage.clickOkButton();
        postAnAdPage.selectCategory();
        postAnAdPage.chooseListing();
        postAnAdPage.chooseDistrict();
        postAnAdPage.clickDone();
        postAnAdPage.enterTheTitle();
        driver.hideKeyboard();
        postAnAdPage.clickNextButton();
        postAnAdPage.assertMediaPage();

    }

}
