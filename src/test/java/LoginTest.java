import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }

    @Test
    void loginSuccessTest() {

        WebDriver driver = createDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.getCurrentUrl().contains("inventory"));

        driver.quit();
    }

    @Test
    void loginWrongUsernameTest() {
        WebDriver driver = createDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());

        driver.quit();
    }

    @Test
    void loginWrongPasswordTest() {
        WebDriver driver = createDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());

        driver.quit();
    }
}