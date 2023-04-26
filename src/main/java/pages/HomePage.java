package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span")
    WebElement signBtn;
    @FindBy(id = "field-email")
    WebElement emailInput;
    @FindBy(id = "field-password")
    WebElement passwordInput;
    @FindBy(id = "submit-login")
    WebElement signInBtn;
    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a/img")
    WebElement homeBtn;

    public void goToSignInPage(){
        signBtn.click();
    }

    public void logIntoAccount(String Email, String Password) {
        emailInput.sendKeys(Email);
        passwordInput.sendKeys(Password);
        signInBtn.click();
    }
    public void goToHomePage() {
        homeBtn.click();
    }

    public void goToSingInPage() {

    }
}