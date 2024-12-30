package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserPage extends BasePage {

    @FindBy(xpath = "//h2/b[text()='Enter Account Information']")
    WebElement msg_accountCreation;
    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    WebElement rd_gender_mr;
    @FindBy(xpath = "//input[@id=\"id_gender2\"]")
    WebElement rd_gender_mrs;
    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement txt_password;
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement chkd_newsletter;
    @FindBy(xpath = "//input[@id='optin']")
    WebElement chkd_offers;
    @FindBy(xpath = "//input[@id=\"first_name\"]")
    WebElement txt_firstName;
    @FindBy(xpath = "//input[@id=\"last_name\"]")
    WebElement txt_lastName;
    @FindBy(xpath = "//input[@id=\"company\"]")
    WebElement txt_company;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement txt_address1;
    @FindBy(xpath = "//input[@id='address2']")
    WebElement txt_address2;
    @FindBy(xpath = "//input[@id='state']")
    WebElement txt_state;
    @FindBy(xpath = "//input[@id='city']")
    WebElement txt_city;
    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement txt_zipcode;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement txt_mobileNumber;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement btn_createAccount;
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement msg_AccountCreated;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btn_continue;

    public RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreationMsg() {
        try {
            return msg_accountCreation.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getAccountCreatedMsg() {
        try {
            return msg_AccountCreated.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void setTitle(String gender) {
        if (gender.equalsIgnoreCase("mrs")) {
            rd_gender_mrs.click();
        } else {
            rd_gender_mr.click();
        }
    }

    public void setPassword(String pwd) {
        txt_password.sendKeys(pwd);
    }

    public void checkNewsLetter(String bool) {
        if (bool.equalsIgnoreCase("true")) {
            chkd_newsletter.click();
        }
    }

    public void checkOffers(String bool) {
        if (bool.equalsIgnoreCase("true")) {
            chkd_offers.click();
        }
    }

    public void setFirstName(String fName) {
        txt_firstName.sendKeys(fName);
    }

    public void setLastName(String lName) {
        txt_lastName.sendKeys(lName);
    }

    public void setCompany(String company) {
        txt_company.sendKeys(company);
    }

    public void setAddress1(String address1) {
        txt_address1.sendKeys(address1);
    }

    public void setAddress2(String address2) {
        txt_address2.sendKeys(address2);
    }

    public void setState(String state) {
        txt_state.sendKeys(state);
    }

    public void setCity(String city) {
        txt_city.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        txt_zipcode.sendKeys(zipCode);
    }

    public void setMobileNumber(String mobileNumber) {
        txt_mobileNumber.sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        btn_createAccount.click();
    }

    public String verify_accountCreatedMsg() {
        try {
            return msg_AccountCreated.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clickContinue() {
        btn_continue.click();
    }
}
