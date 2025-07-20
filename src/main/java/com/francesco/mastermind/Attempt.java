package com.francesco.mastermind;

public class Attempt {
    final private ColorSequence sequence;
    final private int countRightColorRightPosition;
    final private int countRightColorWrongPosition;

    public Attempt(ColorSequence sequence, int countRightColorRightPosition, int countRightColorWrongPosition) {
        this.sequence = sequence;
        this.countRightColorRightPosition = countRightColorRightPosition;
        this.countRightColorWrongPosition = countRightColorWrongPosition;
    }

    public ColorSequence getSequence() {
        return sequence;
    }

    public int getCountRightColorRightPosition() {
        return countRightColorRightPosition;
    }

    public int getCountRightColorWrongPosition() {
        return countRightColorWrongPosition;
    }
}
