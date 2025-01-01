package stepDefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.ContactUs;
import pageObjects.HomePage;

import java.util.Map;

public class ContactUsSteps {
    HomePage home;
    ContactUs contactUs;

    @Given("the user navigates to base page")
    public void theUserNavigatesToBasePage() {
        home = new HomePage(BaseClass.getDriver());
        if (!home.isCoverImageDisplayed()) {
            Assert.fail("**** Cover Image display failed ****");
        }
    }

    @And("the user clicks on contactus button")
    public void theUserClicksOnContactusButton() {
        home.clickContactUs();
    }

    @When("the msg GET IN TOUCH is visible")
    public void theMsgGETINTOUCHIsVisible() {
        contactUs = new ContactUs(BaseClass.getDriver());
        if (!"GET IN TOUCH".equals(contactUs.getTouchMsgDisplayed())) {
            Assert.fail("**** Error with Get In Touch msg ****");
        }

    }

    @And("the user enters the contact details into below field")
    public void theUserEntersTheContactDetailsIntoBelowField(DataTable table) {

        Map<String, String> dataMap = table.asMap(String.class, String.class);
        contactUs.setName(dataMap.get("name"));
        contactUs.setEmail(dataMap.get("email"));
        contactUs.setSubject(dataMap.get("subject"));
        contactUs.setMessage(dataMap.get("message"));
    }

    @And("the user uploads the file from {string}")
    public void theUserUploadsTheFileFrom(String path) {
        String filePath = System.getProperty("user.dir") + path;
        contactUs.uploadFile(filePath);
    }

    @Then("the user click the submit button and clicks ok")
    public void theUserClickTheSubmitButtonAndClicksOk() {
        contactUs.clickSubmit();
        BaseClass.getDriver().switchTo().alert().accept();
    }

    @And("the user is presented with successful submission msg")
    public void theUserIsPresentedWithSuccessfulSubmissionMsg() {
        if (!"Success! Your details have been submitted successfully.".equals(contactUs.getSubmitSuccessMsg())) {
            Assert.fail("**** Error with Submit success message ****");
        }
    }

    @And("the user click home button and home page is displayed")
    public void theUserClickHomeButtonAndHomePageIsDisplayed() {
        contactUs.clickHomeButton();
        if ("https://www.automationexercise.com/".equals(BaseClass.getDriver().getCurrentUrl())) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("**** Error displaying home page ****");
        }
    }


}
