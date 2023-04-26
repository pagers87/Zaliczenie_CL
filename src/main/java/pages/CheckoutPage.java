package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "btn btn-primary")
    WebElement checkoutBtn;
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")
    WebElement selfPickUpBtn;
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    WebElement continue2Btn;
    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/span/span")
    WebElement payByCheckBtn;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement agreeTermsBtn;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    WebElement placeOrderBtn;

    public void goToCheckout() {
        checkoutBtn.click();
        continueBtn.click();
        selfPickUpBtn.click();
        continue2Btn.click();
        payByCheckBtn.click();
        agreeTermsBtn.click();
        placeOrderBtn.click();
    }
}