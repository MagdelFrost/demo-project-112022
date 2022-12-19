package com.javarush.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UserPage {

    @Step("Фильтруем пользователей по уровню")
    public UserPage filterUsersLevel(String level) {
        $(".ng-tns-c98-2.dropdown-select-control.ng-star-inserted").click();
        $$(".ng-tns-c98-2.no-border.ng-star-inserted").find(text(String.format(" %s ", level))).click();

        return this;
    }

    @Step("Проверка уровня пользователей")
    public void checkUsersLevel() {
        $(".users-list__item.ng-star-inserted").shouldHave(text("Продвинутый"));
    }
}
