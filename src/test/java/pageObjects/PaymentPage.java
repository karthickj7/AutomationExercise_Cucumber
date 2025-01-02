package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//input[@data-qa=\"name-on-card\"]")
    WebElement txt_nameOnCard;
    @FindBy(xpath = "//input[@data-qa=\"card-number\"]")
    WebElement txt_cardNumber;
    @FindBy(xpath = "//input[@data-qa=\"cvc\"]")
    WebElement txt_cvv;
    @FindBy(xpath = "//input[@data-qa=\"expiry-month\"]")
    WebElement txt_expiryMonth;
    @FindBy(xpath = "//input[@data-qa=\"expiry-year\"]")
    WebElement txt_expiryYear;
    @FindBy(id = "submit")
    WebElement btn_placeOrder;
    @FindBy(xpath = "//*[contains(text(),'Your order has been confirmed!')]")
    WebElement msg_orderConfirmationMsg;
    @FindBy(xpath = "//a[text()=\"Download Invoice\"]")
    WebElement btn_downloadInvoice;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        txt_nameOnCard.sendKeys(name);
    }

    public void setTxt_cardNumber(String cardNumber) {
        txt_cardNumber.sendKeys(cardNumber);
    }

    public void setCvv(String cvv) {
        txt_cvv.sendKeys(cvv);
    }

    public void setExpiryMonth(String month) {
        txt_expiryMonth.sendKeys(month);
    }

    public void setExpiryYear(String year) {
        txt_expiryYear.sendKeys(year);
    }

    public void clickPlaceOrder() {
        btn_placeOrder.click();
    }

    public boolean isOrderPlaceMsgDisplayed() {
        return msg_orderConfirmationMsg.isDisplayed();
    }

    public void clickDownloadInvoice() {
        btn_downloadInvoice.click();
    }


//


}
