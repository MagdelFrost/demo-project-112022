package com.javarush.tests;

import com.github.javafaker.Faker;
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
                .goToCourse();

        coursePage.checkJavaCourse("Java Core");
    }

    @Test
    @DisplayName("Тест фильтрации пользователей")
    void searchTest() {
        mainPage.openPage()
                .goToUsers();

        userPage.filterUsersLevel("Продвинутый")
                .checkUsersLevel();
    }

    @Test
    @DisplayName("Тест страницы Задачи")
    void firsTaskTest() {
        mainPage.openPage()
                .goToTasks();

        tasksPage.checkTask("Первая программа");
    }

    @Test
    @DisplayName("Тест регистрации пользователей через UI")
    void newUserTest() {
        mainPage.openPage();

        registrationPage.registrationUser(email, password);

        coursePage.checkTitle("Обучение программированию на Java");
    }

    //TODO: Еще 2 теста;
    //TODO: раскидать тесты по классам;
}