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










}
