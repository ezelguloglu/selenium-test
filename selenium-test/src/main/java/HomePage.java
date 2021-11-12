
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    //SearchBox searchBox;
    LoginPage loginPage;
    By searchBoxLocater = new By.ByCssSelector("input[id='search_input']");
    By searchButton = new By.ByCssSelector("input[class='activated']");
    By myAccount = new By.ByCssSelector("a[id='menuUserIcon']");
    By cartCountLocator = By.id("spanCart");
    By cartContainerLocator = By.className("header-icon-label");
    By loginLocator = By.className("dropdown-toggle");

    public HomePage (WebDriver driver) {
        super(driver);
        //searchBox = new SearchBox(driver);
        loginPage = new LoginPage(driver);
    }

    public LoginPage loginPage() { return this.loginPage; }

    //public SearchBox searchBox(){
    //    return this.searchBox;
    //}

    public boolean isProductCountUp() {
        return getCartCount()>0;
    }

    public void login () {
        click(loginLocator);
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);

    }
    public void search(String text) {
        click(searchBoxLocater);
        type(searchBoxLocater, text);
        click(searchButton);
    }

    public boolean isLoggedIn() {
        return isDisplayed(myAccount);
    }
}


