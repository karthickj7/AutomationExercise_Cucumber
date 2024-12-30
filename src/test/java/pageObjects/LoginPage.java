package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // sign up / login
    @FindBy(xpath = "//a[@href=\"/login\"]")
    WebElement btn_myAccount;
    @FindBy(xpath = "//input[@data-qa=\"login-email\"]")
    WebElement txt_loginEmail;
    @FindBy(xpath = "//input[@data-qa=\"login-password\"]")
    WebElement txt_loginPassword;
    @FindBy(xpath = "//button[@data-qa=\"login-button\"]")
    WebElement btn_login;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    WebElement txt_signUpEmail;
    @FindBy(xpath = "//input[@data-qa=\"signup-name\"]")
    WebElement txt_signUpName;
    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    WebElement btn_signUp;
    @FindBy(xpath = " //*[contains(text(),'Logged in as')]")
    WebElement msg_loginSuccess;
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement msg_newUser;
    @FindBy(xpath = "//*[text()='Email Address already exist!']")
    WebElement msg_emailExists;


    // sign up / login
    public void clickMyAccount() {
        btn_myAccount.click();
    }

    public String getNewUserMsg() {
        try {
            return msg_newUser.getText();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void setLoginEmail(String email)  {
        txt_loginEmail.sendKeys(email);
    }

    public void setLoginPassword(String pwd) {
        txt_loginPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btn_login.click();
    }

    public String verify_loginSuccess() {
        try {
            return msg_loginSuccess.getText();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void setSignUpName(String name) {
        txt_signUpName.sendKeys(name);
    }

    public void setSignUpEmail(String email) {
        txt_signUpEmail.sendKeys(email);
    }

    public void clickSignUp() {
        btn_signUp.click();
    }

    public String getEmailExistsMsg(){
        try {
            return msg_emailExists.getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
