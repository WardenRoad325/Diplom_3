package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPage {

    private WebDriver driver;

    // Используйте конструктор для инициализации WebDriver
    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    // Локатор для ссылки "Личный кабинет"
    private final By linkPersonalAccount = By.xpath("//a[@class='AppHeader_header__link__3D_hX']/p[@class='AppHeader_header__linkText__3q_va ml-2']");

    // Локатор для поля ввода электронной почты
    private final By inputEmail = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='text' and @name='name']");

    // Локатор для поля ввода пароля
    private final By inputPassword = By.xpath("//input[@type='password']");

    // Локатор для кнопки "Войти"
    private final By loginButton = By.className("button_button__33qZ0");

    // Метод для получения локатора ссылки "Личный кабинет"
    public By getLinkPersonalAccountLocator() {
        return linkPersonalAccount;
    }

    // Метод для получения локатора поля ввода электронной почты
    public By getInputEmailLocator() {
        return inputEmail;
    }

    // Метод для получения локатора поля ввода пароля
    public By getInputPasswordLocator() {
        return inputPassword;
    }

    // Метод для получения локатора кнопки "Войти"
    public By getLoginButtonLocator() {
        return loginButton;
    }

    // Метод для ввода электронной почты
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(inputEmail);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Метод для ввода пароля
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(inputPassword);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Метод для клика по кнопке "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public boolean isEmailInputDisplayed() {
        return driver.findElement(inputEmail).isDisplayed();
    }

}

