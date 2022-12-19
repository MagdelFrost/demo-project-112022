package com.javarush.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    @Step("Регистрация пользователя через UI")
    public void registrationUser(String email, String password) {
        $("#button_menu_start_learning_unauthorized_user").click();
        $("#id_button_jr_welcome_start_learning_1").click();
        $$("#todo_add").find(text("Русский")).click();
        $("#id_button_jr_welcome_choose_java_developer").click();
        $("#id_button_jr_welcome_literary").click();
        $("#id_button_jr_welcome_motivation_always").click();
        $("#id_button_jr_welcome_dark_theme").click();
        $("[placeholder='Email']").setValue(email);
        $("[placeholder='Пароль']").setValue(password);
        $("#id_button_jr_welcome_create_account").click();
        $("#id_button_jr_welcome_start_from_scratch").click();
        sleep(9000);
        $("#id_button_jr_welcome_get_course").click();
    }
}
