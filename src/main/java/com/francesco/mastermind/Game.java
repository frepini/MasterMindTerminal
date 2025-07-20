package com.francesco.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final private ColorSequence correct;
    final private List<Attempt> attempts;
    private int count;

    public Game() {
        this.correct = ColorSequence.getRandomColorSequence();
        attempts = new ArrayList<>();
    }

    public Attempt makeAttempt(ColorSequence guess) {
        int countRightColorRightPosition = correct.countRightColorRightPosition(guess);
        int countRightColorWrongPosition = correct.countRightColorWrongPosition(guess);
        Attempt attempt = new Attempt(guess, countRightColorRightPosition, countRightColorWrongPosition);
        attempts.add(attempt);
        return attempt;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public boolean isCorrect(ColorSequence guess) {
        return this.correct.equals(guess);
    }
}
