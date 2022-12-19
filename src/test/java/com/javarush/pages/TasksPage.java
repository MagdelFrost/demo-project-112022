package com.javarush.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TasksPage {
    @Step("Проверка страницы задач")
    public void checkTask(String title) {
        $(".task-card__container").shouldHave(text(title));
    }
}
