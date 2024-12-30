package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement btn_home;
    @FindBy(xpath = "//a[@href='/products']")
    WebElement btn_products;
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement btn_cart;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btn_logout;
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement btn_deleteAccount;
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement btn_contactUs;
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement msg_loggedIn;
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement msg_accountDeleted;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement btn_deleteContinue;
    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    WebElement msg_loginError;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public void clickHome() {
        btn_home.click();
    }

    public void clickProducts() {
        btn_products.click();
    }

    public void clickCart() {
        btn_cart.click();
    }

    public void clickLogOut() {
        btn_logout.click();
    }

    public void clickDeleteAccount() {
        btn_deleteAccount.click();
    }

    public void clickContactUs() {
        btn_contactUs.click();
    }

    public boolean getLoggedInMsg() {
       return msg_loggedIn.isDisplayed();
    }

    public String getAccountDeletedMsg() {
        try {
            return msg_accountDeleted.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clickDeleteContinue() {
        btn_deleteContinue.click();
    }

    public String getLoginErrorMsg(){
        try{
            return msg_loginError.getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
