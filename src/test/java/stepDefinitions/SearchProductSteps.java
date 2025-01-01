package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.ProductsPage;

public class SearchProductSteps {
    ProductsPage productsPage;

    @Then("the user enters product name in search box and clicks search")
    public void theUserEntersProductNameInSearchBoxAndClicksSearch() {
        productsPage = new ProductsPage(BaseClass.getDriver());
        productsPage.setSearchProductName("Sleeveless");
        productsPage.clickSearch();
    }

    @And("the searched products msg is displayed")
    public void theSearchedProductsMsgIsDisplayed() {
        if (!"SEARCHED PRODUCTS".equals(productsPage.getSearchedProductsMsg())) {
            Assert.fail("**** Error with searched products msg ****");
        }
    }

    @And("verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        if (productsPage.getProductCount() < 1){
            Assert.fail("**** Error displaying search products ****");
        }else {
            Assert.assertTrue(true);
        }

    }
}
