package com.javarush.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Тесты с переходом на страницы подразделов
 */
public class SubPagesTests extends TestBase{

    @Test
    @DisplayName("Тест страницы Курс")
    void courseTest() {
        mainPage.openPage()
                .goTo("QUESTS");
        coursePage.checkJavaCourse("Java Core");
    }

    @Test
    @DisplayName("Тест фильтрации пользователей")
    void searchTest() {
        mainPage.openPage()
                .goTo("USERS");
        userPage.filterUsersLevel("Продвинутый")
                .checkUsersLevel();
    }

    @Test
    @DisplayName("Тест страницы Задачи")
    void firsTaskTest() {
        mainPage.openPage()
                .goTo("TASKS");
        tasksPage.checkTask("Первая программа");
    }

    @Test
    @DisplayName("Тест поиска на странице задачи")
    void taskSearchTest() {
        mainPage.openPage()
                .goTo("TASKS");
        tasksPage.searchTask("С каждым разом огромнее")
                .checkSearchResult("С каждым разом огромнее");
    }
}
