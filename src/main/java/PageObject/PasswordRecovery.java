package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PasswordRecovery {
    private WebDriver driver;

    // Используйте конструктор для инициализации WebDriver
    public PasswordRecovery(WebDriver webDriver) {
        this.driver = webDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    // Локатор для кнопки "Восстановление пароля"
    private final By buttonLoginRecovery = By.className("Auth_link__1fOlj");

    // Метод для получения локатора кнопки "Восстановление пароля"
    public void getButtonLoginRecoveryLocator() {
        driver.findElement(buttonLoginRecovery).click();
    }
}

