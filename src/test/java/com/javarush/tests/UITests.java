package com.javarush.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UITests extends TestBase {

    @Test
    @DisplayName("Тест смены языка страницы")
    void switchLanguageTest() {
        mainPage.openPage()
                .changeLanguage()
                .checkLanguage();
    }


    @Test
    @DisplayName("Тест страницы Курс")
    void courseTest() {
        mainPage.openPage()
                .goToCourse()
                .checkJavaCore();
    }

    @Test
    @DisplayName("Тест фильтрации пользователей")
    void searchTest() {
        mainPage.openPage()
                .goToUsers()
                .filterUsersLevel()
                .checkUsersLevel();
    }

    @Test
    @DisplayName("Тест страницы Задачи")
    void firsTaskTest() {
        mainPage.openPage()
                .goToTasks()
                .checkFirstTask();
    }

    @Test
    @DisplayName("Тест регистрации пользователей через UI")
    void newUserTest() {
        mainPage.openPage()
                .registrationUser(testData.getEmail(), testData.getPassword())
                .checkFirstCourse();
    }
}