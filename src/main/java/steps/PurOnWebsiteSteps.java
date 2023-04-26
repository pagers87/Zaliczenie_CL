package steps;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AddProductToCartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderConfirmPage;

public class PurOnWebsiteSteps {
    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl";
    private Object Duration;

    @Given("The user is on the main page, logs into their account by providing their {string} and {string} and goes to the clothing section.")
    public void logIntoApp(String Email, String Password) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        HomePage homePage2 = new HomePage(driver);
        homePage2.goToSingInPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homePage2.logIntoAccount(Email, Password);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @When("The user searches for the {string} by name, selects the size, adds the selected item numbers to the basket and proceeds to the checkout.")
    public void goToSingInPage (String product){
        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(driver);
        addProductToCartPage.enterSearch(product);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCartPage.chooseQuantity();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCartPage.addToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCartPage.gotoProceedToCheckOut();
    }
    @And("The user confirms the delivery address, selects the delivery method, chooses the appropriate payment method, accepts the terms and conditions, and clicks the button to confirm the order.")
    public void goToCheckoutPage(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout();
    }
    @Then("The user receives confirmation of the successful purchase of the item and takes a screenshot of the information.")
    public void verifyOrderComplete(){
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        Assert.assertEquals(orderConfirmPage.getAccountHeader(), "YOUR ORDER IS CONFIRMED");
    }
    @And("The browser is closed")
    public void tearDown(){
        driver.quit();
    }
}
