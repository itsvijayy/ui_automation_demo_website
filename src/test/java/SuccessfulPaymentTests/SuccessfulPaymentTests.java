package SuccessfulPaymentTests;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SuccessfulPaymentFlow;

public class SuccessfulPaymentTests extends BaseTests {

    HomePage homePage;
    SuccessfulPaymentFlow successfulPaymentFlow;

    @BeforeClass
    public void initialisingPrerequisite() {
        homePage = new HomePage(driver);
        successfulPaymentFlow = new SuccessfulPaymentFlow(driver);
    }

    @Test
    public void testSuccessfulPaymentFlow() throws Exception {
        homePage.clickBuyButton();
        successfulPaymentFlow.assert_ShoppingCartText();
        successfulPaymentFlow.assert_CustomerDetailsText();
        successfulPaymentFlow.enter_NameText();
        successfulPaymentFlow.enter_EmailId();


    }



}
