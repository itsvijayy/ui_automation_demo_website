package pages;

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
        enterPhoneNo.sendKeys("9986920809");
        log.info("Entered Phone No: 9986920809");
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
        Thread.sleep(3000);
    }

    public void paymentPage() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFramePaymentOption);

        Assert.assertEquals(assertAmountText.getText(), "amount");


        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }





}
