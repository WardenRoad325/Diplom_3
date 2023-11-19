package ToppingsConstructorCheck;
import PageObject.ConstructorPage;
import PageObject.LoginPage;
import PageObject.PasswordRecovery;
import PageObject.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Step;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
public class ToppingConstructorCheckTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ConstructorPage constructorPage;
    private RegistrationPage registrationPage;
    private PasswordRecovery passwordRecovery;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        constructorPage = new ConstructorPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecovery = new PasswordRecovery(driver);
        driver.manage().window().maximize();

    }
    @Step("Проверка перехода к разделау булки")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void checkBunsTopping() {
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage.clickIngredients();
        constructorPage.clickBuns();
    }
    @Step("Проверка перехода к разделау булки")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void checkIngredientsTopping() {
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage.clickSauce();
        constructorPage.clickIngredients();
    }
    @Step("Проверка перехода к разделау булки")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void checkSouceTopping() {
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage.clickIngredients();
        constructorPage.clickSauce();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
