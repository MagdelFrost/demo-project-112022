package com.javarush.tests.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Открываем сайт")
    public MainPage openPage() {
        open("");
        $(".button.button--sm-wide.button--apply").click();

        return this;
    }

    @Step("Смена языка")
    public MainPage changeLanguage() {
        $(".language-switcher__control").click();
        $$(".language-switcher-item").findBy(text("English")).click();

        return this;
    }

    @Step("Переходим на станицу курсов")
    public MainPage goToCourse() {
        $(".sidebar-nav-link.svelte-1myen61").click();

        return this;
    }

    @Step("Переходим на станицу пользователей")
    public MainPage goToUsers() {
        $("[data-site-tour-target='USERS']").click();

        return this;
    }

    @Step("Переходим на станицу задач")
    public MainPage goToTasks() {
        $("[data-site-tour-target='TASKS']").click();

        return this;
    }

    @Step("Фильтруем пользователей по уровню")
    public MainPage filterUsersLevel() {
        $(".ng-tns-c98-2.dropdown-select-control.ng-star-inserted").click();
        $$(".ng-tns-c98-2.no-border.ng-star-inserted").find(text(" Продвинутый ")).click();

        return this;
    }

    @Step("Регистрация пользователя через UI")
    public MainPage registrationUser(String email, String password) {
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

        return this;
    }

    @Step("Проверка языка страницы")
    public void checkLanguage() {
        $(".hero-section__container").shouldHave(text("Learn Java Online"));
    }

    @Step("Проверка наличия курса Java Core")
    public void checkJavaCore() {
        $(".site-layout__content").shouldHave(text("Java Core"));
    }

    @Step("Проверка уровня пользователей")
    public void checkUsersLevel() {
        $(".users-list__item.ng-star-inserted").shouldHave(text("Продвинутый"));
    }

    @Step("Проверка страницы задач")
    public void checkFirstTask() {
        $(".task-card__container").shouldHave(text("Первая программа"));
    }

    @Step("Проверка страницы курса после регистрации")
    public void checkFirstCourse() {
        $(".article-head__title").shouldHave(text("Обучение программированию на Java | Уроки с нуля"));
    }
}
