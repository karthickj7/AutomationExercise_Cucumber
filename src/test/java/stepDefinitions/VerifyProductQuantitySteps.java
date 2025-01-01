package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CartPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductsPage;

public class VerifyProductQuantitySteps {
    ProductsPage productsPage;
    ProductDetailsPage detailsPage;
    CartPage cartPage;

    @And("the user clicks on view product of any product")
    public void theUserClicksOnViewProductOfAnyProduct() {
        productsPage = new ProductsPage(BaseClass.getDriver());
        productsPage.clickOnViewProductOf("1");

    }

    @And("the quantity is increased to {string}")
    public void theQuantityIsIncreasedTo(String val) {
        detailsPage = new ProductDetailsPage(BaseClass.getDriver());
        detailsPage.setQuantity(val);
    }

    @Then("the user clicks add to cart and then view cart")
    public void theUserClicksAddToCartAndThenViewCart() {
        detailsPage.clickAddToCart();
        detailsPage.clickViewCart();
    }

    @And("verify the product quantity is {string}")
    public void verifyTheProductQuantityIs(String val) {
        cartPage = new CartPage(BaseClass.getDriver());
        if (!cartPage.getProductQuantity(1).equals(val)) {
            Assert.fail("**** Error Displaying correct quantity ****");
        }

    }
}
