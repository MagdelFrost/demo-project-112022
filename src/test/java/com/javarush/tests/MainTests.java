package com.javarush.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Основные тесты
 */
public class MainTests extends TestBase {

    @Test
    @DisplayName("Тест смены языка страницы")
    void switchLanguageTest() {
        mainPage.openPage()
                .changeLanguage()
                .checkLanguage();
    }

    @Test
    @DisplayName("Тест смены темы страницы")
    void switchThemeTest() {
        mainPage.openPage()
                .themeChange()
                .checkTheme();
    }

    @Test
    @DisplayName("Тест регистрации пользователей через UI")
    void newUserTest() {
        mainPage.openPage();
        registrationPage.registrationUser(email, password);
        coursePage.checkTitle("Обучение программированию на Java");
    }
}