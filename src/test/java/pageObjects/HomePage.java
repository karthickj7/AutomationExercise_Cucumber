package pageObjects;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href=\"/login\"]")
    WebElement btn_myAccount;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement btn_Home;
    @FindBy(xpath = "//a[@href='/products']")
    WebElement btn_Products;
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement btn_Cart;
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement btn_TestCases;
    @FindBy(xpath = "//a[normalize-space()='API Testing']")
    WebElement btn_ApiTesting;
    @FindBy(xpath = "//a[normalize-space()='Video Tutorials']")
    WebElement btn_VideoTutorials;
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement btn_ContactUs;
    @FindBy(xpath = "//*[@src=\"/static/images/home/girl2.jpg\"]")
    WebElement img_cover;
    @FindBy(id = "susbscribe_email")
    public WebElement txt_SubscribeEmail;
    @FindBy(id = "subscribe")
    WebElement btn_subscribe;
    @FindBy(xpath = "//div[text()=\"You have been successfully subscribed!\"]")
    WebElement msg_subscriptionSuccess;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickContactUs() {
        btn_ContactUs.click();
    }

    public void clickProducts() {
        btn_Products.click();
    }

    public void clickLogin_SignUp() {
        btn_myAccount.click();
    }

    public void clickTestCase() {
        btn_TestCases.click();
    }

    public boolean isCoverImageDisplayed() {
        return img_cover.isDisplayed();
    }

    public void setSubscribeEmail(String email) {
        txt_SubscribeEmail.sendKeys(email);
    }

    public void clickSubscribe() {
        btn_subscribe.click();
    }

    public String getSubscriptionSuccessMsg(){
        try {
            return msg_subscriptionSuccess.getText();
        } catch (Exception e){
            return e.getMessage();
        }
    }

}
