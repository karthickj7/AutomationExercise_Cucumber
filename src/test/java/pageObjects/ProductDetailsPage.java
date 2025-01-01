package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"product-information\"]/h2")
    WebElement txt_productName;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p[contains(text(),\"Category:\")]")
    WebElement txt_category;
    @FindBy(xpath = "//div[@class=\"product-information\"]/span/span[contains(text(),\"Rs.\")]")
    WebElement txt_price;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p/b[contains(text(),\"Availability:\")]")
    WebElement txt_availability;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p/b[contains(text(),\"Condition:\")]")
    WebElement txt_condition;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p/b[contains(text(),\"Brand:\")]")
    WebElement txt_brand;
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameDisplayed() {
        return txt_productName.isDisplayed();

    }

    public boolean isCategoryDisplayed() {
        return txt_category.isDisplayed();
    }

    public boolean isPriceDisplayed() {
        return txt_price.isDisplayed();
    }

    public boolean isAvailabilityDisplayed() {
        return txt_availability.isDisplayed();
    }

    public boolean isConditionDisplayed() {
        return txt_condition.isDisplayed();
    }

    public boolean isBrandDisplayed() {
        return txt_brand.isDisplayed();
    }
}
