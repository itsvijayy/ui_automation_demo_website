package HomePageTests;

import base.BaseTests;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SuccessfulPaymentFlow;


public class HomePageTest extends BaseTests {
    HomePage homePage;
    SuccessfulPaymentFlow successfulPaymentFlow;

    @BeforeClass
    public void initialisingPrerequisite() {
        homePage = new HomePage(driver);
        successfulPaymentFlow = new SuccessfulPaymentFlow(driver);
    }

    @Test
    public void testHomePage() throws Exception {

        homePage.assert_HeaderLogoText();
        homePage.assert_BodyLogoText();
        homePage.assert_BuyButtonText();


    }





}
