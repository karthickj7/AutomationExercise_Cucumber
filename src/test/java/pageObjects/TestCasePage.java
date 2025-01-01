package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends BasePage{
    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()=\"Test Cases\"]")
    WebElement msg_TestCase;

    public String getTestCaseMsg(){
        try{
            return msg_TestCase.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
