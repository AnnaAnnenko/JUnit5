package qa.annenko;

import com.codeborne.selenide.CollectionCondition;
import org.assertj.core.error.ShouldHave;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitTests {

    static Stream<Arguments> nameOfTest() {
        return  Stream.of(
                Arguments.of(2, "Минск Гомель Брест"),
                Arguments.of(1, "Москва Екатеринбург Санкт-Петербург Новосибирск Казань")
                );
    }
//    @ValueSource(strings = {})

    @MethodSource("nameOfTest")
    @ParameterizedTest(name = "Проверка для элемента")
    void nameOfTest(int numberInList, String cityName) {
        open("https://goldapple.ru/");
        $(".header-city__i").click();
        $(".select-field__view-button").click();
        $(".select-field__option:nth-child(" + numberInList + ")").click();
        $$(".city-selector__list")
                .shouldHave(CollectionCondition.texts(cityName));
    }
}
