
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import sun.rmi.runtime.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Test1 extends BaseTest{

    HomePage homepage = new HomePage (driver);
    LoginPage loginPage = new LoginPage(driver);
    //SearchBox searchBox = new SearchBox(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);;
    CartPage cartPage = new CartPage(driver);

    @Test
    @Order(1)
    public void login() {

        //Üye girişi yapılıyor
        homepage.loginPage().login("ezelaleyna@gmail.com","Antalyaeag94");
        Assertions.assertTrue(homepage.isLoggedIn(), "Giriş yapılamadı!");
    }

    //Ürün arama
    @Test
    @Order(2)
    public void searchProduct(){

        homepage.search("pantolan");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Aradığınız ürün bulunamadı!");
    }

        //Ürün aranıyor (alternatif)
        //WebElement searchBoxText = driver.findElement(By.id("search_input"));
        //searchBoxText.click();
        //searchBoxText.sendKeys("pantolan");


        //ScrollDown ediliyor
    @Test
    @Order(3)
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");
    }

        //Daha fazla ürün görüntülemek için ikinci sayfaya geçiliyor
    @Test
    @Order(4)
    public void seeMoreProducts(){
        productsPage.clickMoreProducts();
    }

        //Biraz daha aşağıya gidiliyor
    @Test
    @Order(5)
    public void littleScrollDown(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,3000)");
    }

        //Ürün seçiliyor
    @Test
    @Order(6)
    public void selectAProduct(){
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Ürün bulunamadı.");
    }

        //Beden seçiliyor
    @Test
    @Order(7)
    public void pickASize(){
        productDetailPage.selectSize();
    }

        //Sepete ekleniyor ve sepetle sayfanın kıyası yapılıyor
    @Test
    @Order(8)
    public void addToBasket(){
        productDetailPage.add_to_cart();
        Assertions.assertTrue(homepage.isProductCountUp(), "Ürün sayısı artmadı!");

    }

        //Sepetle ürünün fiyat kıyası yapılıyor
    @Test
    @Order(9)
    public void comparingPrices() {
        Assertions.assertTrue(productDetailPage.comparePrices(), "Fiyatlar doğru değil");
    }

        //Sepete gidiliyor ve kontrol ediliyor
    @Test
    @Order(10)
    public void goToBasket (){
        homepage.goToCart();
        Assertions.assertTrue(cartPage.checkIsProductAdded(), "Ürün sepete eklenemedi!");
    }


        //Sepette ürün sayısı arttırılıyor ve yeniden kontrol ediliyor
    @Test
    @Order(11)
    public void increasingProduct() {
        cartPage.increaseProductInCart();
        Assertions.assertTrue(cartPage.checkIsProductAdded2());
    }


        //Ürünler sepetten siliniyor, silinme onaylanıyor ve doğrulanıyor
    @Test
    @Order(12)
    public void deletingProducts(){
        cartPage.deleteProducts();
        cartPage.clickDelete();
        Assertions.assertTrue(cartPage.isDeleted());
    }











}
