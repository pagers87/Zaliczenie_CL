package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductToCartPage {
    public AddProductToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "/#search_widget input.ui-autocomplete-input")
    WebElement searchBar;
    @FindBy(css = "#js-product-list .js-product .thumbnail-container .thumbnail")
    WebElement productApproval;
    @FindBy(id = "group_1")
    WebElement sizeBtn;
    @FindBy(className = "material-icons touchspin-up")
    WebElement quantityBtn;
    @FindBy(className = "btn btn-primary add-to-cart")
    WebElement addToCartBtn;
    @FindBy(className = "btn btn-primary")
    WebElement proceedToCheckoutBtn;
    public void enterSearch(String product) {
        searchBar.sendKeys(product);
        searchBar.submit();
        productApproval.click();
    }
    public void chooseQuantity() {
        for (int i = 0; i < 5; i++)
            quantityBtn.click();
    }
    public void addToCart() {
        addToCartBtn.click();
    }
    public void gotoProceedToCheckOut() {
        proceedToCheckoutBtn.click();
    }
}