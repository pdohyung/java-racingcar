package racingcar.view;

import racingcar.domain.Car;

import java.util.Map;

import static java.text.MessageFormat.*;

public class OutputView {
    private static final String PRINT_START_RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_RACE_RESULT_FORMAT = "{0} : {1}";
    private static final String PRINT_WINNERS_FORMAT = "최종 우승자 : {0}";

    public void printStartResult() {
        System.out.println(PRINT_START_RESULT_MESSAGE);
    }

    public void printRaceResult(Map<Car, String> raceResult) {
        for (Car car : raceResult.keySet()) {
            System.out.println(format(PRINT_RACE_RESULT_FORMAT, car.getName(), raceResult.get(car)));
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println(format(PRINT_WINNERS_FORMAT, winners));
    }
}
