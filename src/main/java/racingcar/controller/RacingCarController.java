package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Car> cars = inputView.inputCarNames();
        int numberRaces = inputView.inputNumberRaces();
        Map<Car, String> raceCars = initRaceCar(cars);
        outputView.printStartResult();
        for (int i = 0; i < numberRaces; i++) {
            outputView.printRaceResult(race(raceCars));
        }
        outputView.printWinners(determineWinners(raceCars));
    }

    public Map<Car, String> race(Map<Car, String> raceCars) {
        raceCars.forEach((car, currentProgress) -> {
            int randomNumber = randomNumber();
            if (isForward(randomNumber)) {
                raceCars.put(car, currentProgress + "-");
            }
        });
        return raceCars;
    }

    public String determineWinners(Map<Car, String> raceCars) {
        String winnerResult = raceCars.values().stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(IllegalArgumentException::new);

        return raceCars.entrySet().stream()
                .filter(entry -> entry.getValue().equals(winnerResult))
                .map(entry -> entry.getKey().getName())
                .collect(Collectors.joining(","));
    }

    private Map<Car, String> initRaceCar(List<Car> cars) {
        Map<Car, String> raceCars = new LinkedHashMap<>();
        for (Car car : cars) {
            raceCars.put(car, "");
        }
        return raceCars;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}