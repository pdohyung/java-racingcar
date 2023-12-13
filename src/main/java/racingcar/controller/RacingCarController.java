package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;
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
    }

    public Map<Car, String> race(Map<Car, String> raceCars) {
        for (Car car : raceCars.keySet()) {
            int randomNumber = randomNumber();
            if (isForward(randomNumber)) {
                String currentProgress = raceCars.getOrDefault(car, "");
                raceCars.put(car, currentProgress + "-");
            }
        }
        return raceCars;
    }

    private Map<Car, String> initRaceCar(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.toMap(car -> car, car -> ""));
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}