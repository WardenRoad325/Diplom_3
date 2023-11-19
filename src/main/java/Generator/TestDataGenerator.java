package Generator;

import BaseApi.UserRegistrationData;
import com.github.javafaker.Faker;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static UserRegistrationData generateUserData() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String username = faker.name().username();

        return new UserRegistrationData(email, password, username);
    }
}

