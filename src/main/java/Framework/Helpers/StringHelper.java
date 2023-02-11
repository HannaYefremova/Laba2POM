package Framework.Helpers;

import com.github.javafaker.Faker;

public class StringHelper {
    private static final Faker faker = new Faker();

    public static String generateInvalidFirstName() {
        return faker.name().firstName();
    }

    public static String generateInvalidLastName() {
        return faker.name().lastName();
    }

    public static String generateInvalidEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateInvalidPassword() {
        return faker.internet().password();
    }
}
