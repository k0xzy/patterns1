package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@UtilityClass

public class DataGenerator {

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {


        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {

        String city = faker.address().cityName();
        return city;
    }

    public static String generateName(String locale) {

        String name = faker.name().firstName() + " " + faker.name().lastName();
        return name;
    }

    public static String generatePhone(String locale) {

        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {

        public static UserInfo generateUser(String locale) {
            return new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );
        }
    }

    @Value
    @Data
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
