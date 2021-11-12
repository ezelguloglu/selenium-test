
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductsPage extends BasePage {
    By filter = By.id("filter-label");
    By moreProducts = By.id("pageIndex");
    By productNameLocator = By.id("model_1016564_4648215");

    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(filter);
    }

    public void clickMoreProducts(){
        click(moreProducts);
    }

    public void selectProduct() {
        click(productNameLocator);


    }

    private List <WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
