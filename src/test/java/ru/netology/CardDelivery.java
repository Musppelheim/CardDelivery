package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDelivery {

    @Test
    void shouldSuccessForm () {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue("Барнаул");
        form.$("[data-test-id=date] input").setValue("05.10.2020");
        form.$("[data-test-id=name] input").setValue("Нэя Сика");
        form.$("[data-test-id=phone] input").setValue("+79134568520");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(withText("Успешно!")).waitUntil(Condition.exist,15000);

    }

}
