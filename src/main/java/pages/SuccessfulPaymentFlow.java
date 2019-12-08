package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Logger;

public class SuccessfulPaymentFlow {

    WebDriver driver;
    public SuccessfulPaymentFlow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Logger log = Logger.getLogger(getClass().getSimpleName());

    // All WebElements
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement assertShoppingCartText;
    @FindBy(xpath = "//div[contains(text(),'Customer Details')]")
    WebElement assertCustomerDetailsText;
    @FindBy(xpath = "(//input[contains(@type, 'text')])[1]")
    WebElement enterName;
    @FindBy(xpath = "(//input[contains(@type, 'email')])[1]")
    WebElement enterEmail;
    @FindBy(xpath = "(//input[contains(@type, 'text')])[2]")
    WebElement enterPhoneNo;
    @FindBy(xpath = "(//input[contains(@type, 'text')])[3]")
    WebElement enterCity;
    @FindBy(xpath = "(//td[contains(@class, 'input')])[11]")
    WebElement assertAddress;
    @FindBy(xpath = "(//input[contains(@type, 'text')])[4]")
    WebElement enterPostalCode;
    @FindBy(xpath = "(//div[contains(@class, 'cart-checkout')])[1]")
    WebElement buttonCheckout;
    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement iFramePaymentOption;
    @FindBy(xpath = "//span[contains(@class, 'text-amount-title')]")
    WebElement assertAmountText;
    @FindBy(xpath = "(//a[contains(@class, 'text-actionable')]/span)[1]")
    WebElement assertOrderDetails;
    @FindBy(xpath = "(//a[contains(@class, 'text-actionable')]/span)[2]")
    WebElement assertShippingDetails;
    @FindBy(xpath = "(//span[contains(@class, 'item-name')])[1]")
    WebElement assertMidtransPillowText;
    @FindBy(xpath = "(//td[contains(@class, 'table-amount text-body')])[1]")
    WebElement assertAmountDetailsText;
    @FindBy(xpath = "(//a[contains(@class, 'button-main-content')])[1]")
    WebElement clickContinueButton;
    @FindBy(xpath = "(//div[contains(@class, 'list-title text-actionable-bold')])[1]")
    WebElement clickCreditCard;
    @FindBy(xpath = "(//h1[contains(@class, 'logo-store')])[1]")
    WebElement assertSampleStore;
    @FindBy(xpath = "(//span[contains(@class, 'text-amount-amount')])[1]")
    WebElement assertFinalAmount;
    @FindBy(xpath = "//input[contains(@name, 'cardnumber')]")
    WebElement enterCardNumber;
    @FindBy(xpath = "(//input[contains(@type, 'tel')])[2]")
    WebElement enterExpiryDate;
    @FindBy(xpath = "(//input[contains(@type, 'tel')])[3]")
    WebElement enterCVV;
    @FindBy(xpath = "//div[contains(@class, 'button-main show')]")
    WebElement clickPayNowButton;
    @FindBy(xpath = "//div[contains(@class, 'col-xs-7')]/input[contains(@id, 'PaRes')]")
    WebElement enterPassword;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    WebElement clickOKButton;
    @FindBy(xpath = "(//div[contains(@class, 'text-sucess text-bold')])[1]")
    WebElement assertTransactionSuccessfulText;
    @FindBy(xpath = "//span[contains(@class, 'sprite modal-close-dark')]")
    WebElement clickImportantInfoPopUp;



    public void assert_ShoppingCartText() {
        Assert.assertEquals(assertShoppingCartText.getText(), "Shopping Cart  ");
        log.info("Shopping Cart text verified");
    }

    public void assert_CustomerDetailsText() {
        Assert.assertEquals(assertCustomerDetailsText.getText(), "Customer Details");
        log.info("Customer Details text verified");
    }

    public void enter_NameText() {
        enterName.clear();
        enterName.sendKeys("Test SuccessfulPayment");
        log.info("Entered Name: Test SuccessfulPayment");
    }

    public void enter_EmailId() {
        enterEmail.clear();
        enterEmail.sendKeys("test@yopmail.com");
        log.info("Entered EmailId: test@yopmail.com");
    }

    public void enter_PhoneNo() {
        enterPhoneNo.clear();
        enterPhoneNo.sendKeys("9876543210");
        log.info("Entered Phone No: 9876543210");
    }

    public void enter_City() {
        enterCity.clear();
        enterCity.sendKeys("Bengaluru");
        log.info("Entered City : Bengaluru");
    }

    public void assert_Address() throws Exception {
        Assert.assertEquals(assertAddress.getText(), "MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11");
        log.info("Address text verified");
    }

    public void enter_PostalCode() {
        enterPostalCode.clear();
        enterPostalCode.sendKeys("560068");
        log.info("Entered Postal Code : 560068");
    }

    public void clickCheckoutButton() throws Exception {
        buttonCheckout.click();
        Thread.sleep(2000);
    }

    public void paymentPage() throws Exception {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFramePaymentOption);

        Assert.assertEquals(assertAmountText.getText(), "amount");
        log.info("Amount text verified");
        Assert.assertEquals(assertOrderDetails.getText(), "order details");
        log.info("Order Details text verified");
        Assert.assertEquals(assertMidtransPillowText.getText(), "Midtrans Pillow");
        log.info("Midtrans Pillow text verified");
        Assert.assertEquals(assertAmountDetailsText.getText(),"20,000");
        log.info("Amount: 20000");

        assertShippingDetails.click();
        Assert.assertEquals(assertShippingDetails.getText(), "shipping details");
        log.info("Shipping Details text verified");

        Assert.assertEquals(clickContinueButton.getText(), "CONTINUE");
        log.info("Continue button text verified");
        clickContinueButton.click();

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    public void enterCreditCardDetails(String CreditCardNumber) throws Exception {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFramePaymentOption);

        Assert.assertEquals(assertSampleStore.getText(), "Sample Store");
        log.info("Sample Store text verified");
        clickCreditCard.click();

        Assert.assertEquals(assertFinalAmount.getText(), "19,000");
        log.info("Final Amount text verified");

        enterCardNumber.sendKeys(CreditCardNumber);
        Thread.sleep(1000);
        enterExpiryDate.sendKeys("02/20");
        enterCVV.sendKeys("123");
        clickImportantInfoPopUp.click();
        clickPayNowButton.click();
        Thread.sleep(8000);

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    public void enterOTP() throws Exception {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFramePaymentOption);
//        enterPassword.click();
        enterPassword.sendKeys("112233");
        Thread.sleep(3000);
        clickOKButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(assertTransactionSuccessfulText.getText(), "19,000");
        log.info("Transaction Successful text verified");

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }


}
