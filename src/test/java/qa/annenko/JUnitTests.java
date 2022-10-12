package qa.annenko;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class JUnitTests {

    static Stream<Arguments> nameOfTest() {
        return  Stream.of(
                Arguments.of("Аргумент1", "Аргумент2"),
                Arguments.of("Аргумент1", "Аргумент2")
        );
    }

    @ValueSource(strings = {})
    @MethodSource("nameOfTest")

    @ParameterizedTest(name = "Проверка для элемента {0}")
    void Test(String testData) {

    }
}
