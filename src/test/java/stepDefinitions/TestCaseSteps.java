package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.TestCasePage;

public class TestCaseSteps {
    HomePage home;
    TestCasePage testCasePage;
    @When("the user clicks the test cases button")
    public void theUserClicksTheTestCasesButton() {
        BaseClass.getLogger().info("**** Started TestCaseSteps ****");
        home = new HomePage(BaseClass.getDriver());
        home.clickTestCase();
    }

    @Then("the user is navigated to test case page")
    public void theUserIsNavigatedToTestCasePage() {
        testCasePage = new TestCasePage(BaseClass.getDriver());
        if (!"TEST CASES".equals(testCasePage.getTestCaseMsg())){
            Assert.fail("**** Navigation to test cage page failed ****");
        }else {
            BaseClass.getLogger().info("**** Navigated to Test Class Page****");
            BaseClass.getLogger().info("**** Finished TestCaseSteps ****");
        }
    }


}
