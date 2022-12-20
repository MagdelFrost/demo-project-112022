package com.javarush.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TasksPage {
    @Step("Поиск по странице Задачи")
    public TasksPage searchTask(String search) {
        $(".form-control.ng-untouched.ng-pristine.ng-valid")
                .setValue(search);
        $(".button.button--search.button--sm.ng-star-inserted").click();

        return this;
    }

    @Step("Проверка результата поиска")
    public void checkSearchResult(String title) {
        $(".task-card__title").shouldHave(text(("С каждым разом огромнее")));
    }

    @Step("Проверка страницы задач")
    public void checkTask(String title) {
        $(".task-card__container").shouldHave(text(title));
    }
}
