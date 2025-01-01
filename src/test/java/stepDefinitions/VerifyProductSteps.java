package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductsPage;

public class VerifyProductSteps {
    HomePage home;
    ProductsPage productsPage;
    ProductDetailsPage detailsPage;

    @When("the user clicks on products")
    public void theUserClicksOnProducts() {
        BaseClass.getLogger().info("**** Started VerifyProduct Steps ****");
        home = new HomePage(BaseClass.getDriver());
        home.clickProducts();
    }

    @And("the user navigates to all products and products list is visible")
    public void theUserNavigatesToAllProductsAndProductsListIsVisible() {
        productsPage = new ProductsPage(BaseClass.getDriver());
        if (!productsPage.isAllProductsDisplayed()){
            Assert.fail("**** Navigation to all products page failed ****");
        }
        if (productsPage.getProductCount()<1){
            Assert.fail("**** Error displaying products ****");
        }
    }

    @Then("the user click on view product of first product")
    public void theUserClickOnViewProductOfFirstProduct() {
        productsPage.clickOnProductNo("1");
    }

    @And("the user is landed on product details page")
    public void theUserIsLandedOnProductDetailsPage() {
        if (!BaseClass.getDriver().getCurrentUrl().contains("https://www.automationexercise.com/product_details/")) {
            BaseClass.getLogger().error("**** Failed to load product details page ****");
            Assert.fail("**** Navigation to load product details page failed **** ");
        }
    }

    @And("the product details are visible")
    public void theProductDetailsAreVisible() {
        BaseClass.getLogger().info("**** Checking if products details are displayed ****");
        detailsPage = new ProductDetailsPage(BaseClass.getDriver());
        if (!detailsPage.isProductNameDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying Product Name details ****");
            Assert.fail("**** Error displaying Product Name details ****");
        } else if (!detailsPage.isCategoryDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying Category details ****");
            Assert.fail("**** Error displaying Category details ****");
        } else if (!detailsPage.isPriceDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying Price details ****");
            Assert.fail("**** Error displaying Price details ****");
        } else if (!detailsPage.isAvailabilityDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying availability details ****");
            Assert.fail("**** Error displaying availability details ****");
        } else if (!detailsPage.isConditionDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying Condition details ****");
            Assert.fail("**** Error displaying condition details ****");
        } else if (!detailsPage.isBrandDisplayed()) {
            BaseClass.getLogger().error("**** Error displaying brand details ****");
            Assert.fail("**** Error displaying brand details ****");
        }

        BaseClass.getLogger().info("**** Finished VerifyProduct Steps ****");
    }
}
