package ua.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        List<Integer> statisics = new ArrayList<>();

        model.setBounds(GlobalConstants.LOWER_BOUND, GlobalConstants.UPPER_BOUND);
        model.generateNumber();

        boolean guessed = false;
        while (!guessed) {

            int guessedNumber = inputNumberWithScanner(sc);

            while (!model.isNumberInInterval(guessedNumber)) {
                view.printMessage(View.NUMBER_NOT_IN_INTERVAL);
                guessedNumber = inputNumberWithScanner(sc);
            }

            guessed = model.compareNumber(guessedNumber);
            if (!guessed) {
                model.updateBounds(guessedNumber);
                statisics.add(guessedNumber);
                view.printMessage(model.moreOrLess(guessedNumber));
            }
        }
        view.printStatistics(statisics);
        view.printMessage(View.WIN_MESSAGE);
    }

    public int inputNumberWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_MESSAGE
                + View.LEFT_BRACKET
                + model.getLowerBound()
                + View.INTERVAL_DIVIDER
                + model.getUpperBound()
                + View.RIGHT_BRACKET);

        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();

    }
}
