
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {


    By increasedNumberLocator = new By.ByCssSelector("input[class='item-quantity-input ignored']");
    By productNameLocator = By.className("rd-cart-item-main-info");
    By increaseProductLocator = By.id("Cart_AddQuantity_707474653");
    By deleteItems = new By.ByCssSelector("i[class='fa fa-trash-o']");
    By emptyCartConfirm = new By.ByCssSelector("a[class='homepage-link mt-20']");
    By deleteConfirm = By.id("Cart_ProductDelete_708493287");

    public CartPage (WebDriver driver) {

        super(driver);

    }



    public boolean checkIsProductAdded() {
        return getProducts().size()>0;
    }

    public void increaseProductInCart(){
        click(increaseProductLocator);
    }

    public boolean checkIsProductAdded2() {
        return getCountInCart()>1;}

    private int getCountInCart (){
        String count = find(increasedNumberLocator).getText();
        return Integer.parseInt(count);
    }

    public void deleteProducts(){
        click(deleteItems);
    }

    public void clickDelete(){
        click(deleteConfirm);
    }

    public boolean isDeleted() {
        return isDisplayed(emptyCartConfirm);
    }



    private List<WebElement> getProducts() {
        return findAll(productNameLocator);
    }
}
