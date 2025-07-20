package com.francesco.mastermind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.random.RandomGenerator;

public class ColorSequence extends Sequence {
    public static final int SEQUENCE_LENGTH = 4;
    final private Color[] sequence;

    public ColorSequence() {
        this.sequence = new Color[SEQUENCE_LENGTH];
    }

    public void setColor(Color c, int index) {
        try {
            checkIndex(sequence.length, index);
            sequence[index] = c;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Errore: l'indice inserito non è valido");
        }
    }

    public Color getColor(int index) {
        try {
            checkIndex(sequence.length, index);
            return sequence[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Errore: l'indice inserito non è valido");
            return null;
        }
    }

    public int countRightColorRightPosition(ColorSequence guess) {
        int count = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if (guess.getColor(i).equals(this.getColor(i))) {
                count++;
            }
        }
        return count;
    }

    public int countRightColorWrongPosition(ColorSequence guess) {
        Map<Color, Integer> secretColorCounts = new HashMap<>();
        Map<Color, Integer> guessColorCounts = new HashMap<>();

        /*
        First step: we ignore the colors in the right position
         */
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            Color secretColor = this.getColor(i);
            Color guessColor = guess.getColor(i);

            if (secretColor != guessColor) {
                secretColorCounts.put(secretColor, secretColorCounts.getOrDefault(secretColor, 0) + 1);
                guessColorCounts.put(guessColor, guessColorCounts.getOrDefault(guessColor, 0) + 1);
            }
        }

        /*
        Second step: confront the maps
         */
        int count = 0;
        for (Color color : guessColorCounts.keySet()) {
            if (secretColorCounts.containsKey(color)) {
                count += Math.min(secretColorCounts.get(color), guessColorCounts.get(color));
            }
        }

        return count;
    }

    public static ColorSequence getRandomColorSequence() {
        RandomGenerator rnd = RandomGenerator.getDefault();
        Color[] allColors = Color.values() ;
        ColorSequence sequence = new ColorSequence();
        for (int i = 0; i < ColorSequence.SEQUENCE_LENGTH; i++) {
            sequence.setColor(allColors[rnd.nextInt(0, allColors.length)], i);
        }
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ColorSequence that = (ColorSequence) o;
        return Objects.deepEquals(sequence, that.sequence);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sequence);
    }

    @Override
    public String toString() {
        return "ColorSequence{" +
                "sequence=" + Arrays.toString(sequence) +
                '}';
    }
}
