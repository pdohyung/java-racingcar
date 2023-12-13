package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식 입력이 아닙니다.";

    public static List<Car> validateInputCarNames(String input) {
        return splitInputByComma(input);
    }

    public static int validateInputNumberRaces(String input) {
        return convertStringToInteger(input);
    }

    private static List<Car> splitInputByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }

    private static int convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }
}
