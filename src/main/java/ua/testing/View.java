package ua.testing;

import java.util.Arrays;
import java.util.List;

public class View {

    public static final String WRONG_INPUT_INT_DATA = "Wrong input data";
    public static final String INPUT_MESSAGE = "Guess number in ";
    public static final String WIN_MESSAGE = "You have won!";
    public static final String NUMBER_NOT_IN_INTERVAL = "Number not in interval";

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printStatistics(List<Integer> statistics){
        System.out.println(statistics);
    }

}
