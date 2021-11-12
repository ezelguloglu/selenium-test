
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By priceInCart = new By.ByCssSelector("p[class='amount']");
    By priceInPage = new By.ByCssSelector("span[class='price-regular single-price']");
    By productSize =new By.ByCssSelector("a[key='4']");

    public ProductDetailPage (WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return false;
    }

    public boolean comparePrices() {
        return getPriceInCart()==getPriceInPage();

    }

    private int getPriceInCart (){
        String count = find(priceInCart).getText();
        return Integer.parseInt(count);
    }

    private int getPriceInPage (){
        String count = find(priceInPage).getText();
        return Integer.parseInt(count);
    }

    public void selectSize (){
        click(productSize);

    }

    public void add_to_cart() {
        click(addToCartButtonLocator);
    }



}


