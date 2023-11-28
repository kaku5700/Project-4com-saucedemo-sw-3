package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on Login
        clickOnElement(By.id("login-button"));
        //Verify actual and expected text
        verifyTextDisplayed(By.xpath("//span[contains(text(), 'Products')]"), "Products");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on Login
        clickOnElement(By.id("login-button"));
        //Verify 6 Products are displayed
        verifyNumberFromElement(By.className("inventory_item"), 6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
