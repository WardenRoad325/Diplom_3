package CheckingPageSections;

import PageObject.ConstructorPage;
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


public class CheckingPageSectionsTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;



    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        constructorPage = new ConstructorPage(driver);
        driver.manage().window().maximize();

    }
    @Step("Переход в личный кабинет c главной страницы  ")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void openPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site");
        constructorPage.clickPersonalAccount();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    @Step("Переход из личного кабинета в конструктор")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void SwitchingPersonalAccounToConstructor(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        constructorPage.clickConstructorLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }
    @Step("Переход из личного кабинета в конструктор по клику на логотип ")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void SwitchingPersonalAccountToLogo(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        constructorPage.ClickSvgText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

