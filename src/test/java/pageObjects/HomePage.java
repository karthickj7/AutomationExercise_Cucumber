package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

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
    @FindBy(xpath = "//h2[normalize-space()=\"Get In Touch\"]")
    WebElement msg_GetInTouch;

    public void clickContactUs() {
        btn_ContactUs.click();
    }

    public void clickLogin_SignUp() {
        btn_myAccount.click();
    }

    public boolean isCoverImageDisplayed() {
        return img_cover.isDisplayed();
    }

    public String getTouchMsgDisplayed() {
        try {
            return msg_GetInTouch.getText();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
