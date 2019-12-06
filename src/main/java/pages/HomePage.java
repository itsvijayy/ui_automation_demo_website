package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Logger;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Logger log = Logger.getLogger(getClass().getSimpleName());

    @FindBy(className = "pull-left")
    WebElement headerLogoText;
    @FindBy(className = "title")
    WebElement homepageBodyText;
    @FindBy(xpath = "//a[@class='btn buy']")
    WebElement buyButton;

    public void assert_HeaderLogoText() throws Exception {
        Assert.assertEquals(headerLogoText.getText(), "coco", "Header Logo Text is not same");
        log.info("Header Logo text verified");
    }

    public void assert_BodyLogoText() throws Exception {
        Assert.assertEquals(homepageBodyText.getText(), "Midtrans Pillow");
        log.info("Body text verified");
    }

    public void assert_BuyButtonText() throws Exception{
        Assert.assertEquals(buyButton.getText(), "BUY NOW");
        log.info("Body text verified");
    }

    public SuccessfulPaymentFlow clickBuyButton() throws Exception {
        buyButton.click();
        log.info("Clicked on Buy Button");
        return new SuccessfulPaymentFlow(driver);
    }



}
