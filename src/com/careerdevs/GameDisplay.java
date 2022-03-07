package com.careerdevs;

import java.util.ArrayList;

public class GameDisplay {

    public static void initialFrame(ArrayList<Letter> hiddenLetters, int uniqueLetters) {

       // printBorder();
        System.out.println("\nWelcome, the word you are tasked with guessing will appear shortly.\n");
        GuessAWord.wait(3);
        System.out.println("It has a total of " + hiddenLetters.size() + " letters, " +
                uniqueLetters + " of which are unique.\n");
        GuessAWord.wait(3);

        System.out.println("Loading all the letters... \n");

        GuessAWord.wait(2);

        for (int index = 0; index < hiddenLetters.size(); index++){
            System.out.print("_ ");
            GuessAWord.wait(1);

        }
        //printBorder();
    }

    //Figure out if you are going to use this ... *******
    public static void subsequentFrames(ArrayList<Letter> letterObjects) {


    }


    public static void currentState(ArrayList<Letter> letters, boolean guessedCorrectly) {

        for (int index = 0; index < letters.size(); index++) {

            boolean isLetterDisplayed = letters.get(index).getIsDisplayed();
            char letter = letters.get(index).getValue();

            //Sequence for correctly guessed letter
            //Used in conjunction with "unveiling" statement
            if (guessedCorrectly) {
                if (isLetterDisplayed) {
                    System.out.print(letter + " ");
                    GuessAWord.wait(1);
                } else {
                    System.out.print("_ ");
                    GuessAWord.wait(1);
                }
            }

            //Sequence for an incorrect guess
            //Since state has not changed, no need to use
            //wait() to unveil position of a correctly guessed letter
            else {
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

    //Delineates one frame from the next
    public static void printBorder(int dashes){

        if (dashes == 100){
            System.out.println("");
        }


        while(dashes > 0) {
            System.out.print("-");
            dashes--;
        }

        System.out.println("");
    }


}
