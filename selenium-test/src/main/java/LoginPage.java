import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    By email = By.id("LoginEmail");
    By password = By.id("Password");
    By loginButton = By.id("loginLink");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login (String text1, String text2){
        type(email, text1);
        click(email);
        type(password, text2);
        click(password);
        click(loginButton);

    }


}
