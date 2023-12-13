package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식 입력이 아닙니다.";

    public static List<String> validateInputCarNames(String input) {
        return splitInputByComma(input);
    }

    public static int validateInputNumberRaces(String input) {
        return convertStringToInteger(input);
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(","))
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
