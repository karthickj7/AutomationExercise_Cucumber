package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.*;

import java.io.File;

public class RegisterWhileCheckoutSteps {
    ProductsPage productsPage;
    HomePage homePage;
    CartPage cart;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    @And("the user adds a product to cart")
    public void theUserAddsAProductToCart() throws InterruptedException {
        productsPage = new ProductsPage(BaseClass.getDriver());
        productsPage.hoverAndAddProduct(1);
        productsPage.clickContinueShopping();
        productsPage.hoverAndAddProduct(2);
//        productsPage.clickContinueShopping();

    }

    @When("the user clicks on cart page and the page is displayed")
    public void theUserClicksOnCartPageAndThePageIsDisplayed() {
        homePage = new HomePage(BaseClass.getDriver());
        homePage.clickCart();

    }

    @And("the user clicks on proceed to checkout")
    public void theUserClicksOnProceedToCheckout() {
        cart = new CartPage(BaseClass.getDriver());
        cart.clickCheckout();
    }

    @And("the user clicks on register or login button")
    public void theUserClicksOnRegisterLoginButton() {
        checkoutPage = new CheckoutPage(BaseClass.getDriver());
        checkoutPage.clickLogin();
    }

    @And("verify the address and review the order")
    public void verifyTheAddressAndReviewTheOrder() {
        if (!checkoutPage.isReviewOrderDisplayed()) {
            Assert.fail("**** Error displaying review order ****");
        }
        if (!checkoutPage.isAddressDetailsDisplayed()) {
            Assert.fail("**** Error displaying address details ****");
        }
    }


    @And("the user enter comments {string} and clicks on place order")
    public void theUserEnterCommentsAndClicksOnPlaceOrder(String comment) {
        checkoutPage.setComments(comment);
        checkoutPage.clickPlaceOrder();
    }

    @And("the user enters the payment details")
    public void theUserEntersThePaymentDetails() {
        paymentPage = new PaymentPage(BaseClass.getDriver());
        paymentPage.setName(BaseClass.getRandomAlphabetic());
        paymentPage.setTxt_cardNumber(BaseClass.getRandomNumeric());
        paymentPage.setCvv("123");
        paymentPage.setExpiryMonth("11");
        paymentPage.setExpiryYear("3456");


    }

    @And("the user clicks pay and confirm button")
    public void theUserClicksPayAndConfirmButton() {
        paymentPage.clickPlaceOrder();
    }

    @And("verify the order placed msg")
    public void verifyTheOrderPlacedMsg() {
        if (!paymentPage.isOrderPlaceMsgDisplayed()) {
            Assert.fail("**** Error displaying order confirmation msg ****");
        }
    }


    @And("download invoice and verify it is successfully downloaded")
    public void downloadInvoiceAndVerifyItIsSuccessfullyDownloaded() throws InterruptedException {
        paymentPage.clickDownloadInvoice();
        Thread.sleep(3000);
        File downloadedFile = new File(System.getProperty("user.dir") + "\\Downloads\\invoice.txt");
        Assert.assertTrue("**** Error downloading invoice file ****", downloadedFile.exists());
    }


}
