package com.careerdevs;

import java.util.ArrayList;

public class Letter {

    private char letter;
    private boolean isDisplayed;

    public static ArrayList<Character> alreadyGuessed = new ArrayList<Character>();

    Letter(char letter) {

        this.letter = letter;

    }

    public boolean wasCharPreviouslyGuessed (char userInput){

        for (int index = 0; index < alreadyGuessed.size(); index++){
            if (userInput == alreadyGuessed.get(index)){
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
