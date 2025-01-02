package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageObjects.HomePage;

import javax.swing.*;

public class VerifySubscriptionSteps {
    HomePage homePage;
    JavascriptExecutor jsExecutor;

    @And("the user scrolls down to subscription section")
    public void theUserScrollsDownToSubscriptionSection() throws InterruptedException {
        homePage = new HomePage(BaseClass.getDriver());
        Thread.sleep(1000);
        jsExecutor = (JavascriptExecutor) BaseClass.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView()", homePage.txt_SubscribeEmail);
        Thread.sleep(1000);
    }

    @When("the user enter the email {string}and click on arrow key")
    public void theUserEnterTheEmailAndClickOnArrowKey(String email) {
        homePage.setSubscribeEmail(email);
        homePage.clickSubscribe();
    }

    @Then("the user is displayed with successfully subscribed")
    public void theUserIsDisplayedWithSuccessfullySubscribed() {
        if (!"You have been successfully subscribed!".equals(homePage.getSubscriptionSuccessMsg())) {
            Assert.fail("**** Error performing subscription ****");
        }

    }



}
