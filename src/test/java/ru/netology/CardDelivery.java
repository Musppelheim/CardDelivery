package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDelivery {

    @Test
    void shouldSuccessForm () {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue("Барнаул");
        String meetingDate = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        form.$("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        form.$("[placeholder='Дата встречи']").setValue(meetingDate);
        form.$("[data-test-id=name] input").setValue("Нэя Сика");
        form.$("[data-test-id=phone] input").setValue("+79134568520");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(withText("Успешно!")).waitUntil(Condition.visible,15000);
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.exactText("Встреча успешно забронирована на " + meetingDate));

    }

}
