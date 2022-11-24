package com.javarush.tests.data;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class TestData {

    Faker faker = new Faker();

    String password = faker.numerify("#*#*#*#*#");
    String email = faker.internet().emailAddress();
}
