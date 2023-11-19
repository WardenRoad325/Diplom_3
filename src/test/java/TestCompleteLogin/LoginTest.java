package TestCompleteLogin;

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

public class LoginTest {

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


    @Step("Вход по кнопке «Войти в аккаунт» на главной")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void testCompleteLoginFlow() {
        driver.get("https://stellarburgers.nomoreparties.site");

        loginPage.clickLoginButton();
        // Используйте Duration.ofSeconds для указания длительности ожидания в секундах
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        assertEquals(driver.getCurrentUrl(), "https://stellarburgers.nomoreparties.site/login");
        assertTrue(loginPage.isEmailInputDisplayed(), "Email input is not displayed on the page");
    }

    @Step("Вход через кнопку «Личный кабинет»")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void testCompleteLoginUserProfile() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        constructorPage.clickPersonalAccount();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    @Step("Вход через кнопку в форме регистрации")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void testCompleteLoginUserRegisterPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage.getButtonLoginRegistrationLocator();
        // Используйте Duration.ofSeconds для указания длительности ожидания в секундах
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        assertEquals(driver.getCurrentUrl(), "https://stellarburgers.nomoreparties.site/login");
        assertTrue(loginPage.isEmailInputDisplayed(), "Email input is not displayed on the page");
    }

    @Step("Вход через кнопку в форме восстановления пароля.")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void testCompleteLoginUserPasswordRecovery() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        passwordRecovery.getButtonLoginRecoveryLocator();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


