package com.careerdevs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Letter {

    private char letter;
    private boolean isDisplayed;

    public static Set<Character> alreadyGuessed = new HashSet<Character>();

    Letter(char letter) {

        this.letter = letter;

    }

    public static boolean wasCharPreviouslyGuessed(char userInput){

        for (Character letter : alreadyGuessed) {

            if (userInput == letter) {

                return true;
            }
        }

        return false;
    }

    public char getValue() {

        return letter;
    }

    //Don't seem to be using this right now *****
    public void setLetter (char letter) {

        this.letter = letter;

    }

    public boolean getIsDisplayed() {

        return isDisplayed;
    }

    public static void setIsDisplayed(Letter correctlyGuessed) {

        correctlyGuessed.isDisplayed = true;
        alreadyGuessed.add(correctlyGuessed.getValue());

    }




}
