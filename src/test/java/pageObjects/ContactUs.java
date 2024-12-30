package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends BasePage {
    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_Name;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement txt_Email;
    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement txt_Subject;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement txt_Message;
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement load_File;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement btn_submit;

    public void setName(String name) {
        txt_Name.sendKeys(name);
    }

    public void setEmail(String email) {
        txt_Email.sendKeys(email);
    }

    public void setSubject(String subject) {
        txt_Subject.sendKeys(subject);
    }

    public void setMessage(String message) {
        txt_Message.sendKeys(message);
    }

    public void uploadFile(String path) {
        load_File.sendKeys(path);
    }

    public void clickSubmit() {
        btn_submit.click();
    }

}
