package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public static List<String> validateInputCarNames(String input) {
        return splitInputByComma(input);
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }
}
