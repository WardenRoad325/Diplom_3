package PageObject;

import org.openqa.selenium.By;

public class UserProfilePage {
    // Локатор для кнопки профиля на странице пользователя
    private final By buttonProfile = By.xpath("//li[@class='Account_listItem__35dAP']//a[contains(@class, 'Account_link_active__2opc9') and contains(@href, '/account/profile')]");

    // Метод для получения локатора кнопки профиля
    public By getButtonProfileLocator() {
        return buttonProfile;
    }
}

