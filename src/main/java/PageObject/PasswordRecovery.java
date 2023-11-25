package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecovery extends BasePage {

    private final By forgetPassword = By.xpath("//h2[text()='Восстановление пароля']");
    private final By buttonEnter = By.xpath("//a[@href='/login']");

    public PasswordRecovery(WebDriver driver) {
        super(driver);
    }

    @Step("click login button")
    public void clickLogin() {
        driver.findElement(buttonEnter).click();
    }

    @Step("wait for forget password page")
    public void waitForLoad() {
        waitForElementVisibility(forgetPassword);
    }
}