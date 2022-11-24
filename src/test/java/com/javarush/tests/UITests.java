package com.javarush.tests;

import org.junit.jupiter.api.Test;

public class UITests extends TestBase {

    @Test
    void switchLanguageTest() {
        mainPage.openPage()
                .changeLanguage()
                .checkLanguage();
    }


    @Test
    void courseTest() {
        mainPage.openPage()
                .goToCourse()
                .checkJavaCore();
    }

    @Test
    void searchTest() {
        mainPage.openPage()
                .goToUsers()
                .filterUsersLevel()
                .checkUsersLevel();
    }

    @Test
    void firsTaskTest() {
        mainPage.openPage()
                .goToTasks()
                .checkFirstTask();
    }

    @Test
    void newUserTest() {
        mainPage.openPage()
                .registrationUser(testData.getEmail(), testData.getPassword())
                .checkFirstCourse();
    }
}