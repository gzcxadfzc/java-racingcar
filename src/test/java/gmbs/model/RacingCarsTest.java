package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarsTest {

    private final List<CarName> names = Arrays.asList(new CarName("레드불"), new CarName("페라리"), new CarName("메르세데스"));
    private final int[] generatedNumbers = {5, 6, 3};
    private final RacingCars cars = new RacingCars(names);
    private int index = 0;

    @Test
    @DisplayName("car position이 가장 큰 차의 이름을 반환한다")
    void getHeadPositionNames() {
        cars.updateStatus((any1, any2) -> generatedNumbers[index++]);
        List<String> expectedNames = Arrays.asList("레드불", "페라리");
        assertThat(cars.getHeadPositionNames()).isEqualTo(expectedNames);
    }
}
