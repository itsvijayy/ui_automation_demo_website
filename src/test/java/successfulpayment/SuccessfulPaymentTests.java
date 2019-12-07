package successfulpayment;

import base.BaseTests;
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
        successfulPaymentFlow.enter_PhoneNo();
        successfulPaymentFlow.enter_City();
        successfulPaymentFlow.assert_Address();
        successfulPaymentFlow.enter_PostalCode();
        successfulPaymentFlow.clickCheckoutButton();
        successfulPaymentFlow.paymentPage();

    }



}
