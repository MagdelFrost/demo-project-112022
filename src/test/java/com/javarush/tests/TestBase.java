package com.javarush.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.javarush.config.Project;
import com.javarush.helpers.AllureAttachments;
import com.javarush.helpers.DriverSettings;
import com.javarush.helpers.DriverUtils;
import com.javarush.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    MainPage mainPage = new MainPage();
    CoursePage coursePage = new CoursePage();
    RegistrationPage registrationPage = new RegistrationPage();
    TasksPage tasksPage = new TasksPage();
    UserPage userPage = new UserPage();

    Faker faker = new Faker();

    String password = faker.numerify("#*#*#*#*#");
    String email = faker.internet().emailAddress();

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
