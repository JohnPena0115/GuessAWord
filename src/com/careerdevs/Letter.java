package com.careerdevs;

public class Letter {

    private char letter;
    private boolean isDisplayed;

    Letter(char letter) {

        this.letter = letter;

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

    public void setIsDisplayed(boolean displayed) {

        isDisplayed = displayed;

    }




}
