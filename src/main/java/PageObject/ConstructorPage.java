package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConstructorPage {

    private WebDriver driver;

    // Используйте конструктор для инициализации WebDriver
    public ConstructorPage(WebDriver webDriver) {
        this.driver = webDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    // Локатор для кнопки "Войти в аккаунт"
    private final By loginButtonLocator = By.xpath("//button[contains(@class, 'button_button_type_primary') and contains(@class, 'button_button_size_large')]");

    // Локатор для ссылки "Личный кабинет"
    private final By linkPersonalAccountLocator = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    // локатор кнопки конструктор
    private final By linkConstructorLocator = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/']");
    // Локатор для SVG-элемента
    private final By svgLocator = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    // Локатор блока Соус начинки при выбранном другом блоке
    private final By sauceBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[2]");

    // Локатор блока конструктора Булки при выбранном другом блоке
    private final By bunsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[1]");
    // Локатор блока конструктора Начинки при выбранном другом блоке
    private final By ingredientsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[3]");

    //метод для клика на блок соус
    public void  clickSauce(){
        driver.findElement(sauceBlockUnselected).click();
    }
    // метод для клика по блоку булки
    public void  clickBuns(){
        driver.findElement(bunsBlockUnselected).click();
    }
    //метод для клика на блок начинки
    public void clickIngredients(){
        driver.findElement(ingredientsBlockUnselected).click();
    }
    // Метод для клика по кнопке "Войти в аккаунт"
    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickConstructorLink(){
        driver.findElement(linkConstructorLocator).click();
    }
    // Метод для клика по ссылке "Личный кабинет"
    public void clickPersonalAccount() {
        driver.findElement(linkPersonalAccountLocator).click();

    }

    public void ClickSvgText(){
        driver.findElement(svgLocator).click();
    }
    // Пример метода, который возвращает текст SVG-элемента
    public String getSvgText() {
        WebElement svgElement = driver.findElement(svgLocator);
        return svgElement.getText();
    }
}

