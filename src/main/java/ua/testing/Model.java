package ua.testing;

import java.util.Random;

public class Model {

    private int lowerBound;
    private int upperBound;
    private int number;

    public int getLowerBound() {
        return lowerBound;
    }
    public int getUpperBound() {
        return upperBound;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void setBounds(int firstBound, int secondBound) {
        if(firstBound<secondBound){
            this.lowerBound = firstBound;
            this.upperBound = secondBound;
        } else {
            this.lowerBound = secondBound;
            this.upperBound = firstBound;
        }
    }

    public void generateNumber() {
        this.number = new Random().nextInt(upperBound)+lowerBound;
    }

    public boolean compareNumber(int number){
        return this.number == number;
    }

    public void updateBounds(int newBound){
        if (number > newBound) {
            lowerBound = newBound + 1;
        }
        else if(number < newBound) {
            upperBound = newBound - 1;
        }
        else{
            lowerBound = newBound;
            upperBound = newBound;
        }

    }
    public boolean isNumberInInterval(int number){
        return number<=upperBound && number>=lowerBound;
    }
    public String moreOrLess(int number){
        if (this.number > number) {
            return GlobalConstants.MORE;
        }
        else {
            return GlobalConstants.LESS;
        }
    }
}
