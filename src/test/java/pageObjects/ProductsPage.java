package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()=\"All Products\"]")
    WebElement msg_allProducts;
    @FindBy(xpath = "(//a[text()=\"View Product\"])")
    List<WebElement> list_allProducts;
    @FindBy(id = "search_product")
    WebElement txt_searchProducts;
    @FindBy(id = "submit_search")
    WebElement btn_search;
    @FindBy(xpath = "//h2[text()=\"Searched Products\"]")
    WebElement msg_SearchedProducts;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsDisplayed() {
        return msg_allProducts.isDisplayed();
    }

    public int getProductCount(){
        return list_allProducts.size();
    }

    public void clickOnProductNo(String num) {
        String path = "(//a[text()='View Product'])" + "[" + num + "]";
        BaseClass.getDriver().findElement(By.xpath(path)).click();
    }
    public void setSearchProductName(String productName){
        txt_searchProducts.sendKeys(productName);
    }
    public void clickSearch(){
        btn_search.click();
    }
    public String getSearchedProductsMsg(){
        try {
            return msg_SearchedProducts.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

