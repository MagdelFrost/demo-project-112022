package com.javarush.pages;

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

    @Step("Переходим на станицу курсов") //TODO: Все в один собрать;
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

    @Step("Проверка языка страницы")
    public void checkLanguage() {
        $(".hero-section__container").shouldHave(text("Learn Java Online"));
    }
}
