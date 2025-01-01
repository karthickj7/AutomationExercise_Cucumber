package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductsPage extends BasePage {

    //    @FindBy(xpath = "(//a[text()=\"View Product\"])")
//    List<WebElement> list_allProducts;
    @FindBy(xpath = "//div[@class=\"productinfo text-center\"]")
    List<WebElement> list_allProducts;
    @FindBy(xpath = "//h2[normalize-space()=\"All Products\"]")
    WebElement msg_allProducts;
    @FindBy(id = "search_product")
    WebElement txt_searchProducts;
    @FindBy(id = "submit_search")
    WebElement btn_search;
    @FindBy(xpath = "//h2[text()=\"Searched Products\"]")
    WebElement msg_SearchedProducts;
    @FindBy(xpath = "//a[text()=\"Add to cart\"]")
    List<WebElement> btn_addToCart;
    @FindBy(xpath = "//button[text()=\"Continue Shopping\"]")
    WebElement btn_continueShopping;
    @FindBy(xpath = "//p/a[@href=\"/view_cart\"]")
    WebElement btn_viewCart;

    Actions action;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsDisplayed() {
        return msg_allProducts.isDisplayed();
    }

    public int getProductCount() {
        return list_allProducts.size();
    }

    public void hoverAndAddProduct(int index) throws InterruptedException {
        action = new Actions(BaseClass.getDriver());

        action.moveToElement(list_allProducts.get(index)).perform();
        Thread.sleep(1000);
        clickAddToCart(index);
    }

    public void clickAddToCart(int index) {
        index = index * 2;
        action.moveToElement(btn_addToCart.get(index)).click().perform();
    }

    public void clickContinueShopping() {
        btn_continueShopping.click();
    }

    public void clickViewCart() {
        btn_viewCart.click();
    }

    public void clickOnViewProductOf(String num) {
        String path = "(//a[text()='View Product'])" + "[" + num + "]";
        BaseClass.getDriver().findElement(By.xpath(path)).click();
    }

    public void setSearchProductName(String productName) {
        txt_searchProducts.sendKeys(productName);
    }

    public void clickSearch() {
        btn_search.click();
    }

    public String getSearchedProductsMsg() {
        try {
            return msg_SearchedProducts.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

