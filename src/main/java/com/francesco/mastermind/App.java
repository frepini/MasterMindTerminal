package com.francesco.mastermind;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Color> charColor = new HashMap<>(Map.of(
                'B', Color.BLUE,
                'F', Color.FUCHSIA,
                'G', Color.GREEN,
                'O', Color.ORANGE,
                'P', Color.PURPLE,
                'R', Color.RED,
                'W', Color.WHITE,
                'Y', Color.YELLOW
        ));

        /*Color[] allColors = Color.values() ;
        System.out.println("I colori disponibili sono " + Arrays.toString(allColors));
        ColorSequence correct = new ColorSequence();
        for (int i = 0; i < ColorSequence.SEQUENCE_LENGTH; i++) {
            correct.setColor(allColors[rnd.nextInt(0, allColors.length)], i);
        }*/
        /*ColorSequence correct = ColorSequence.getRandomColorSequence();
        System.out.println("CORRECT: " + correct);

        ColorSequence attempt = new ColorSequence();
        do {
            for (int i = 0; i < ColorSequence.SEQUENCE_LENGTH; i++) {
                System.out.println("""
                        Selezionare un colore tra:
                        (B) BLUE, (F) FUCHSIA, (G) GREEN, (O) ORANGE, (P) PURPLE, (R) RED, (W) WHITE, (Y) YELLOW""");
                //System.out.println("""
                //        Selezionare un colore tra:
                //        \u001B[34m(B) BLUE\u001B[0m, \u001B[35m(F) FUCHSIA\u001B[0m, \u001B[32m(G) GREEN\u001B[0m, (O) ORANGE, (P) PURPLE, \u001B[31m(R) RED\u001B[0m, \u001B[37m(W) WHITE\u001B[0m, \u001B[33m(Y) YELLOW\u001B[0m""");
                String scelta = scanner.next();
                while (!charColor.containsKey(scelta.toUpperCase().charAt(0))) {
                    System.out.println("La stringa o il carattere inserito non è valido in quanto non è tra quelli elencati, riprovare...");
                    scelta = scanner.next();
                }
                attempt.setColor(charColor.get(scelta.toUpperCase().charAt(0)), i);
            }
            System.out.println(attempt);
            int correctRightPosition = correct.countRightColorRightPosition(attempt);
            int correctWrongPosition = correct.countRightColorWrongPosition(attempt);
            if (attempt.equals(correct)) {
                System.out.println("Congratulazioni, hai indovinato la sequenza");
            } else {
                System.out.println("Non hai indovinato la sequenza, riprovare");
                System.out.println("Il numero di colori giusti nella posizione giusta è: " + correctRightPosition);
                System.out.println("Il numero di colori giusti nella posizione sbagliata è: " + correctWrongPosition);
            }
        } while (!attempt.equals(correct));*/

        Game g = new Game();
        ColorSequence guess = new ColorSequence();
        do {
            for (int i = 0; i < ColorSequence.SEQUENCE_LENGTH; i++) {
                System.out.println("""
                        Selezionare un colore tra:
                        (B) BLUE, (F) FUCHSIA, (G) GREEN, (O) ORANGE, (P) PURPLE, (R) RED, (W) WHITE, (Y) YELLOW""");
                //System.out.println("""
                //        Selezionare un colore tra:
                //        \u001B[34m(B) BLUE\u001B[0m, \u001B[35m(F) FUCHSIA\u001B[0m, \u001B[32m(G) GREEN\u001B[0m, (O) ORANGE, (P) PURPLE, \u001B[31m(R) RED\u001B[0m, \u001B[37m(W) WHITE\u001B[0m, \u001B[33m(Y) YELLOW\u001B[0m""");
                String scelta = scanner.next();
                while (!charColor.containsKey(scelta.toUpperCase().charAt(0))) {
                    System.out.println("La stringa o il carattere inserito non è valido in quanto non è tra quelli elencati, riprovare...");
                    scelta = scanner.next();
                }
                guess.setColor(charColor.get(scelta.toUpperCase().charAt(0)), i);
            }
            System.out.println(guess);
            Attempt current_attempt = g.makeAttempt(guess);
            if (g.isCorrect(guess)) {
                System.out.println("Congratulazioni hai indovinato la sequenza corretta!");
            }
            else {
                System.out.println("La sequenza non è corretta:");
                System.out.println("Numero di colori giusti nel posto giusto: " + current_attempt.getCountRightColorRightPosition());
                System.out.println("Numero di colori giusti nel posto sbagliato: " + current_attempt.getCountRightColorWrongPosition());
            }
        } while (!g.isCorrect(guess));
    }
}
