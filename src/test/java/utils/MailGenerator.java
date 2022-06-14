package utils;

import com.github.javafaker.Faker;

public class MailGenerator {

    public MailGenerator() {
    }

    public static String getTemporaryEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}
