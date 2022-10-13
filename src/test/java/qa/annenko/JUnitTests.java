package qa.annenko;

import org.assertj.core.error.ShouldHave;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitTests {

//    static Stream<Arguments> nameOfTest() {
//        return  Stream.of(
//                Arguments.of("Аргумент1", "Аргумент2"),
//                Arguments.of("Аргумент1", "Аргумент2")
//        );
//    }

//    @ValueSource(strings = {})
//    @MethodSource("nameOfTest")

//    @ParameterizedTest(name = "Проверка для элемента")
   @Test
    void nameOfTest() {
        open("https://goldapple.ru/");
        $(".header-city__i").click();
        $(".select-field__view-button").click();
        $(".select-field__option:first-child").click();
        $("#modal-content-41")
                .shouldHave(text("Москва"));
    }
}
