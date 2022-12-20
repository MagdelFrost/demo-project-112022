package com.javarush.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
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

    @Step("Смена цвета темы")
    public MainPage themeChange() {
        $(".site-header__theme-switcher.svelte-1teipfl").click();
        return this;
    }

    @Step("Проверка цвета темы")
    public void checkTheme() {
        $(By.xpath("//div[text()='Темная тема']"))
                .should(exist);
    }

    @Step("Переходим на станицу")
    public void goTo(String target) {
        $(String.format("[data-site-tour-target='%s']", target)).click();

    }

    @Step("Проверка языка страницы")
    public void checkLanguage() {
        $(".hero-section__container").shouldHave(text("Learn Java Online"));
    }
}
