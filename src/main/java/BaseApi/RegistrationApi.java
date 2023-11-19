package BaseApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RegistrationApi {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth/register";

    public static Response registerUser(String email, String password, String name) {
        String requestBody = "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"name\": \"" + name + "\"\n" +
                "}";

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(BASE_URL);
    }
}

