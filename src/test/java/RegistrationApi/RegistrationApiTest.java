package RegistrationApi;
import BaseApi.RegistrationApi;
import BaseApi.DeleteApi;
import BaseApi.UserRegistrationData;
import Generator.TestDataGenerator;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RegistrationApiTest {

    private static String accessToken;


    @Step("Register user")
    @BeforeEach
    public void registerUser() {
        UserRegistrationData userData = TestDataGenerator.generateUserData();

        Response registrationResponse = RegistrationApi.registerUser(userData.getEmail(), userData.getPassword(), userData.getUsername());
        accessToken = registrationResponse.jsonPath().getString("accessToken");
    }

    @Step("Check successful registration")
    @Test
    public void testSuccessfulRegistration() {
        UserRegistrationData userData = TestDataGenerator.generateUserData();

        Response response = RegistrationApi.registerUser(userData.getEmail(), userData.getPassword(), userData.getUsername());
        assertEquals(200, response.getStatusCode(), "Failed to register user");
        assertTrue(accessToken != null && !accessToken.isEmpty());
    }

    @Step("Check incorrect password registration")
    @Test
    public void testIncorrectPasswordRegistration() {
        UserRegistrationData userData = TestDataGenerator.generateUserData();
        // Using a short password intentionally
        userData.setPassword("");

        Response response = RegistrationApi.registerUser(userData.getEmail(), userData.getPassword(), userData.getUsername());
        assertEquals(403, response.getStatusCode(), "User registration with incorrect password should fail");
    }

    @Step("Delete user")
    @DisplayName("Переход в личный кабинет c главной страницы  ")
    @Test
    public void testDeleteUser() {
        try {
            ValidatableResponse deleteResponse = DeleteApi.deleteUserWithAuthorizationHeader(accessToken);
            assertEquals(202, deleteResponse.extract().statusCode(), "Failed to delete user");
        } catch (Exception e) {
            fail("Exception during user deletion: " + e.getMessage());
        }
    }
}




