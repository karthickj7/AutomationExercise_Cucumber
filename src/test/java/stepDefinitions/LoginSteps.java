package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginSteps {

    LoginPage login;
    MyAccountPage accountPage;

    @Given("the user navigates to login page")
    public void theUserNavigatesToLoginPage() {
        BaseClass.getLogger().info("**** Starting Login Steps ****");
        login = new LoginPage(BaseClass.getDriver());
        login.clickMyAccount();
    }

    @When("the user enters email as {string} and password as {string}")
    public void theUserEntersEmailAsAndPasswordAs(String email, String pwd) {
        BaseClass.getLogger().info("**** Entering valid login details ****");
        login.setLoginEmail(email);
        login.setLoginPassword(pwd);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        BaseClass.getLogger().info("**** Clicking on login button ****");
        login.clickLogin();
    }

    @Then("the user should be redirected to the MyAccount Page")
    public void theUserShouldBeRedirectedToTheMyAccountPage() {
        accountPage = new MyAccountPage(BaseClass.getDriver());
        BaseClass.getLogger().info("**** Checking the logged in message ****");
        Assert.assertTrue(accountPage.getLoggedInMsg());
    }

    @When("the user enters incorrect email as {string} and password as {string}")
    public void theUserEntersIncorrectEmailAsAndPasswordAs(String email, String pwd) {
        BaseClass.getLogger().info("**** Entering invalid login details ****");
        login.setLoginEmail(email);
        login.setLoginPassword(pwd);
    }

    @Then("the user should be presented with a error msg")
    public void theUserShouldBePresentedWithAErrorMsg() {
        accountPage = new MyAccountPage(BaseClass.getDriver());
        BaseClass.getLogger().info("**** Checking the login error message ****");
        if (!"Your email or password is incorrect!".equals(accountPage.getLoginErrorMsg())) {
            Assert.fail("**** Login Error Msg Mismatch ****");
        }

    }

    @And("the user clicks the logout button and login page is visible")
    public void theUserClicksTheLogoutButtonAndLoginPageIsVisible() {
        BaseClass.getLogger().info("**** Clicking the logout button ****");
        accountPage = new MyAccountPage(BaseClass.getDriver());
        accountPage.clickLogOut();

        if(!"https://www.automationexercise.com/login".equals(BaseClass.getDriver().getCurrentUrl())){
            Assert.fail("**** Navigation to Login Page failed ****");
        }
    }
}
