package BaseApi;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DeleteApi {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth/user";

    public static RequestSpecification getDeleteSpecAuth(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build()
                .given()
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter());
    }

    @Step("user delete")
    public static ValidatableResponse deleteUserWithAuthorizationHeader(String token) {
        return given()
                .spec(getDeleteSpecAuth(token))
                .when()
                .delete()
                .then();
    }
}




