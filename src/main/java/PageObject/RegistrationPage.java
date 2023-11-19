package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistrationPage {
    private WebDriver driver;

    // Используйте конструктор для инициализации WebDriver
    public RegistrationPage(WebDriver webDriver) {
        this.driver = webDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    // Локатор для кнопки "Вход" на странице регистрации
    private final By buttonLoginRegistration = By.xpath("//a[@class='Auth_link__1fOlj' and @href='/login']");

    // Метод для получения локатора кнопки "Вход" на странице регистрации
    public void getButtonLoginRegistrationLocator() {
       driver.findElement(buttonLoginRegistration).click();
    }


}

