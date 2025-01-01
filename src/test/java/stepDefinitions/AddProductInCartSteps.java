package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pageObjects.CartPage;
import pageObjects.ProductsPage;

public class AddProductInCartSteps {
    ProductsPage productsPage;
    Actions action;
    CartPage cart;

    @When("the user adds products to cart")
    public void theUserAddsProductsToCart() throws InterruptedException {
        BaseClass.getLogger().info("**** Started add products in cart steps ****");
        productsPage = new ProductsPage(BaseClass.getDriver());
        action = new Actions(BaseClass.getDriver());


        productsPage.hoverAndAddProduct(0);
        Thread.sleep(1000);
        productsPage.clickContinueShopping();
        Thread.sleep(1000);
        productsPage.hoverAndAddProduct(1);
        Thread.sleep(1000);


    }

    @And("the user clicks on view cart")
    public void theUserClicksOnViewCart() {
        productsPage.clickViewCart();

    }

    @Then("verify the products are added verify the infos")
    public void verifyTheProductsAreAddedVerifyTheInfos() {
        cart = new CartPage(BaseClass.getDriver());
        System.out.println(cart.getProductCount());
        System.out.println(cart.getProductColumnCount());
        for (int i = 1; i <= cart.getProductCount(); i++) {
            for (int j = 3; j < cart.getProductColumnCount(); j++) {
                if (!cart.isProductValueDisplayed(i, j)) {
                    Assert.fail("**** Error displaying Product details ****");
                }
            }
        }
        Assert.assertTrue(true);
    }
}
