package com.javarush.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CoursePage {
    @Step("Проверка наличия курса")
    public void checkJavaCourse(String courseTitle) {
        $$(".quest-card__title")
                .filter(Condition.text(courseTitle))
                .shouldHave(CollectionCondition.size(1));
    }

    @Step("Проверка страницы курса после регистрации")
    public void checkTitle(String title) {
        $(".article-head__info").shouldHave(text(title));
    }
}
