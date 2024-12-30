package stepDefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterUserPage;

import java.util.Map;

public class RegisterUserSteps {

    LoginPage login;
    RegisterUserPage registerUser;
    MyAccountPage myAccountPage;


    @Given("the user navigates to login page and new user sign up message is displayed")
    public void theUserNavigatesToLoginPageAndNewUserSignUpMessageIsDisplayed() {
        BaseClass.getLogger().info("**** Starting RegisterUser Steps ****");
        login = new LoginPage(BaseClass.getDriver());
        BaseClass.getLogger().info("**** Clicking in Sign Up / Login  ****");
        login.clickMyAccount();
        if (!"New User Signup!".equals(login.getNewUserMsg())){
            BaseClass.getLogger().error("**** New User Signup! failed ****");
            Assert.fail("**** New User Signup! failed ****");
        }
    }

    @When("the user enters the login details {string} and {string} and clicks signup")
    public void theUserEntersTheLoginDetailsAndAndClicksSignup(String name, String email) {
        BaseClass.getLogger().info("**** Entering Email and Name for signup ****");
        login.setSignUpName(name);
        login.setSignUpEmail(email);

        BaseClass.getLogger().info("**** Clicking on signup button ****");
        login.clickSignUp();

        registerUser = new RegisterUserPage(BaseClass.getDriver());
        if (!registerUser.getAccountCreationMsg().equals("ENTER ACCOUNT INFORMATION")){
            BaseClass.getLogger().error("**** ENTER ACCOUNT INFORMATION msg failed ****");
            Assert.fail("**** ENTER ACCOUNT INFORMATION msg failed  ****");
        }
    }

    @And("the user enters the details into below fields and click on Create Account button")
    public void theUserEntersTheDetailsIntoBelowFieldsAndClickOnCreateAccountButton(DataTable dataTable) {
        BaseClass.getLogger().error("**** Entering New User info ****");
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerUser.setTitle(dataMap.get("title"));
        registerUser.setPassword("password");
        registerUser.checkNewsLetter(dataMap.get("newsletter"));
        registerUser.checkOffers(dataMap.get("offers"));
        registerUser.setFirstName(dataMap.get("firstName"));
        registerUser.setLastName(dataMap.get("lastName"));
        registerUser.setCompany(dataMap.get("company"));
        registerUser.setAddress1(dataMap.get("address1"));
        registerUser.setAddress2(dataMap.get("address2"));
        registerUser.setState(dataMap.get("state"));
        registerUser.setCity(dataMap.get("city"));
        registerUser.setZipCode(dataMap.get("zipcode"));
        registerUser.setMobileNumber(dataMap.get("mobilenumber"));

        BaseClass.getLogger().info("**** Clicking on create account btn ****");
        registerUser.clickCreateAccount();


    }

    @Then("the account created message is displayed")
    public void theAccountCreatedMessageIsDisplayed() {
        if (!"ACCOUNT CREATED!".equals(registerUser.getAccountCreatedMsg())){
            Assert.fail("ACCOUNT CREATED! msg failed");
        }
    }

    @And("the user clicks continue and verify logged in msg")
    public void theUserClicksContinueAndVerifyLoggedInMsg() {
        BaseClass.getLogger().info("**** Clicking on continue button in register user page ****");
        registerUser.clickContinue();
        myAccountPage = new MyAccountPage(BaseClass.getDriver());

        boolean msg = myAccountPage.getLoggedInMsg();
        if (!msg) {
            Assert.fail("**** Login msg Failed****");
        }


    }

    @And("the user clicks delete account and deleted msg is visible.")
    public void theUserClicksDeleteAccountAndDeletedMsgIsVisible() {
        BaseClass.getLogger().info("**** Clicking on delete account ****");
        myAccountPage.clickDeleteAccount();
        if (myAccountPage.getAccountDeletedMsg().equals("ACCOUNT DELETED!")) {
            myAccountPage.clickDeleteContinue();
            Assert.assertTrue(true);
        } else {
            Assert.fail("**** ACCOUNT DELETED! msg failed ****");
        }
    }


    @When("the user enters existing email {string} and {string} and clicks signup")
    public void theUserEntersExistingEmailAndAndClicksSignup(String name, String email) {
        BaseClass.getLogger().info("**** Entering existing email address ****");
        login = new LoginPage(BaseClass.getDriver());
        login.setSignUpName(name);
        login.setSignUpEmail(email);
        BaseClass.getLogger().info("**** Clicking on sign up button ****");
        login.clickSignUp();
    }

    @Then("the user is presented with email already exists msg.")
    public void theUserIsPresentedWithEmailAlreadyExistsMsg() {
        BaseClass.getLogger().info("**** Checking existing email error msg ****");
        login = new LoginPage(BaseClass.getDriver());
        if (!"Email Address already exist!".equals(login.getEmailExistsMsg())){
            Assert.fail("**** Email Address already exist! msg error ****");
        }

    }
}
