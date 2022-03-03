package com.careerdevs;

import java.util.ArrayList;

public class GameDisplay {

    public static void initialFrame(ArrayList<Letter> hiddenLetters, int uniqueLetters) {

        System.out.println("Welcome, the word you are tasked with guessing will appear shortly.\n");
        System.out.println("It has a total of " + hiddenLetters.size() + " words, \n" +
                uniqueLetters + " of which are unique.\n");
        System.out.println("Loading ... \n");

        GuessAWord.wait(3);

        for (int index = 0; index < hiddenLetters.size(); index++){

            System.out.print("_ ");

            GuessAWord.wait(1);
        }
    }


    public static void subsequentFrames(ArrayList<Letter> letterObjects) {


    }


}
