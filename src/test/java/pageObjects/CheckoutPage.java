package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    WebElement msg_AddressDetails;
    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    WebElement msg_ReviewOrder;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement txt_Comments;
    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement btn_placeOrder;
    @FindBy(xpath = "//a[normalize-space()=\"Register / Login\"]")
    WebElement btn_login;
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddressDetailsDisplayed() {
        return msg_AddressDetails.isDisplayed();
    }

    public boolean isReviewOrderDisplayed() {
        return msg_ReviewOrder.isDisplayed();
    }

    public void setComments(String msg) {
        txt_Comments.sendKeys(msg);
    }

    public void clickPlaceOrder() {
        btn_placeOrder.click();
    }

    public void clickLogin() {
        btn_login.click();
    }


}
