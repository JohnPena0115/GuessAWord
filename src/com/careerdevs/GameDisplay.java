package com.careerdevs;

import java.util.ArrayList;

public class GameDisplay {

    public static void initialFrame(ArrayList<Letter> hiddenLetters, int uniqueLetters) {

        System.out.println("Welcome, the word you are tasked with guessing will appear shortly.\n");
        System.out.println("It has a total of " + hiddenLetters.size() + " letters, " +
                uniqueLetters + " of which are unique.\n");
        System.out.println("Loading all the letters... \n");

        GuessAWord.wait(3);

        for (int index = 0; index < hiddenLetters.size(); index++){

            System.out.print("_ ");

            GuessAWord.wait(1);
        }
    }


    public static void subsequentFrames(ArrayList<Letter> letterObjects) {


    }


    public static void currentState(ArrayList<Letter> letters, boolean guessedCorrectly) {

        for (int index = 0; index < letters.size(); index++) {

            boolean isLetterDisplayed = letters.get(index).getIsDisplayed();

            char letter = letters.get(index).getValue();

            if (guessedCorrectly) {

                if (isLetterDisplayed) {

                    System.out.print(letter + " ");
                    GuessAWord.wait(1);

                } else {

                    System.out.print("_ ");
                    GuessAWord.wait(1);
                }

            } else {

                if (isLetterDisplayed) {

                    System.out.print(letter + " ");

                } else {

                    System.out.print("_ ");

                }
            }

            if (index == letters.size() - 1) {

                System.out.println("");
            }
        }
    }
}
