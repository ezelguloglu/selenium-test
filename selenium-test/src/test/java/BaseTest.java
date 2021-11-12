import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
    WebDriver driver;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();

        WebElement logIn = driver.findElement(By.className("dropdown-toggle"));
        logIn.click();

        WebElement email = driver.findElement(By.id("LoginEmail"));
        email.click();
        email.sendKeys("ezelaleyna@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.click();
        password.sendKeys("Antalyaeag94");

        WebElement loginButton = driver.findElement(By.id("loginLink"));
        loginButton.click();

    }

}
