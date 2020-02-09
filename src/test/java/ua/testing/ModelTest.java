package ua.testing;

import org.junit.Test;


import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void setBoundsFirstBoundSmaller() {
        Model model = new Model();
        model.setBounds(1, 99);
        assertTrue(1 == model.getLowerBound() && 99 == model.getUpperBound());
    }

    @Test
    public void setBoundsFirstBoundBigger() {
        Model model = new Model();
        model.setBounds(99, 1);
        assertTrue(1 == model.getLowerBound() && 99 == model.getUpperBound());
    }

    @Test
    public void setBoundsEqual() {
        Model model = new Model();
        model.setBounds(1, 1);
        assertTrue(1 == model.getLowerBound() && 1 == model.getUpperBound());
    }

    @Test
    public void compareNumberDifferent() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(4);
        assertFalse(model.compareNumber(3));

    }
    @Test
    public void compareNumberEqual() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(3);
        assertTrue(model.compareNumber(3));
    }

    @Test
    public void generateNumber() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.generateNumber();
        boolean numberFound = false;
        for(int i=1; i<=99;i++){
            if(model.compareNumber(i)) {
                numberFound = true;
                break;
            }
        }
        assertTrue(numberFound);
    }
    @Test
    public void generateNumberEqualBounds() {
        Model model = new Model();
        model.setBounds(1, 1);
        model.generateNumber();
        assertTrue(model.compareNumber(1));
    }

    @Test
    public void updateBoundsUpperBound() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(33);
        model.updateBounds(44);
        assertTrue(1 == model.getLowerBound() && 43 == model.getUpperBound());

    }
    @Test
    public void updateBoundsLowerBound() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(44);
        model.updateBounds(33);
        assertTrue((34 == model.getLowerBound()) && (99 == model.getUpperBound()));
    }
    @Test
    public void updateBoundsWithCorrectNumber() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(44);
        model.updateBounds(44);
        assertTrue(44 == model.getLowerBound() && 44 == model.getUpperBound());
    }

    @Test
    public void isNumberInInterval() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(44);
        assertTrue(model.isNumberInInterval(54));
    }
    @Test
    public void isNumberInIntervalLowerBound() {
        Model model = new Model();
        model.setBounds(1, 99);
        assertTrue(model.isNumberInInterval(1));
    }
    @Test
    public void isNumberInIntervalUpperBound() {
        Model model = new Model();
        model.setBounds(1, 99);
        assertTrue(model.isNumberInInterval(99));
    }
    @Test
    public void isNumberInIntervalFalse1() {
        Model model = new Model();
        model.setBounds(1, 99);
        assertFalse(model.isNumberInInterval(0));
    }
    @Test
    public void isNumberInIntervalFalse2() {
        Model model = new Model();
        model.setBounds(1, 99);
        assertFalse(model.isNumberInInterval(100));
    }

    @Test
    public void moreOrLessMore() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(23);
        assertEquals(model.moreOrLess(33), GlobalConstants.LESS);
    }
    @Test
    public void moreOrLessLess() {
        Model model = new Model();
        model.setBounds(1, 99);
        model.setNumber(45);
        assertEquals(model.moreOrLess(33), GlobalConstants.MORE);
    }

}