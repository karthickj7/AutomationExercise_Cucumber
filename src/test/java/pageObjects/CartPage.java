package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//table[@id=\"cart_info_table\"]")
    WebElement table_product;
    @FindBy(xpath = "//table[@id=\"cart_info_table\"]/tbody/tr")
    List<WebElement> list_products;
    @FindBy(xpath = "//table[@id=\"cart_info_table\"]/tbody/tr[1]/td")
    List<WebElement> list_products_column;
    @FindBy(xpath = "//a[normalize-space()=\"Proceed To Checkout\"]")
    WebElement btn_checkout;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCount() {
        return list_products.size();
    }

    public int getProductColumnCount() {
        return list_products_column.size();
    }

    public void clickCheckout() {
        btn_checkout.click();
    }

    public String getProductRowValue(int rowNum, int colNum) {
        return BaseClass.getDriver().findElement(By.xpath(String.format("//table[@id='cart_info_table']//tbody//tr[%d]/td[%d]", rowNum, colNum))).getText();
    }

    public boolean isProductValueDisplayed(int rowNum, int colNum) {
        return BaseClass.getDriver().findElement(By.xpath(String.format("//table[@id='cart_info_table']//tbody//tr[%d]/td[%d]", rowNum, colNum))).isDisplayed();
    }

    public String getProductQuantity(int num) {
        return BaseClass.getDriver().findElement(By.xpath(String.format("//table[@id='cart_info_table']//tbody//tr[%d]/td[%d]", num, 4))).getText();
    }
}
