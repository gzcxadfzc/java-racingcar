package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @ParameterizedTest
    @DisplayName("리스트 원소들이 모두 5글자 이하이면 true를 반환하는지 확인한다")
    @MethodSource("generateNames")
    void isValidNames(List<String> inputNames, boolean expected) {
        //given
        boolean actual = validator.isValidNames(inputNames);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("name1", "name2", "name33"), false),
                Arguments.of(Arrays.asList("name1", "name2", "name3"), true)
        );
    }
}