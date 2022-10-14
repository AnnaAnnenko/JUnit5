package qa.annenko;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests {

    static Stream<Arguments> checkCityInCountry() {
        return  Stream.of(
                Arguments.of(3, "Алматы Астана Актобе Шымкент Караганда Тараз"),
                Arguments.of(2, "Минск Гомель Брест Гродно Витебск Могилёв"),
                Arguments.of(1, "Москва Екатеринбург Санкт-Петербург Новосибирск Казань")
                );
    }
    @MethodSource("checkCityInCountry")
    @ParameterizedTest(name = "Проверка для элемента {0}")
    void checkCityInCountry(int numberInList, String cityName) {
        open("https://goldapple.ru/");
        $(".header-city__i").click();
        $(".select-field__view-button").click();
        $(".select-field__option:nth-child(" + numberInList + ")").click();
        $$(".city-selector__list")
                .shouldHave(CollectionCondition.texts(cityName));
    }

    @ValueSource(strings = {"Оренбург", "Уфа"})
    @ParameterizedTest(name = "Проверка для элемента {0}")
    void searchForCity(String testData) {
        open("https://goldapple.ru/");
        $(".header-city__i").click();
        $(".city-selector__input").setValue(testData);
        $(".city-selector__item:first-child").shouldHave(text(testData));
    }

    @CsvSource(value = {
            "3, Вы можете выбрать более 100 населённых пунктов по всей республике Казахстан.",
            "2, Вы можете выбрать более 100 населённых пунктов по всей республике Беларусь.",
            "1, Вы можете выбрать более 150 000 населённых пунктов по всей Российской Федерации."
    })
    @ParameterizedTest(name = "Проверка для элемента {0}")
    void checkTextMatchCountry(int numberOfCountry, String expectedText) {
        open("https://goldapple.ru/");
        $(".header-city__i").click();
        $(".select-field__view-button").click();
        $(".select-field__option:nth-child(" + numberOfCountry + ")").click();
        $(".city-selector__cities")
                .shouldHave(text(expectedText));
    }
}
