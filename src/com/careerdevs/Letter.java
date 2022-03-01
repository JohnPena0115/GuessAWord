package com.careerdevs;

public class Letter {

    private char letter;
    private boolean hidden;

    Letter(char letter) {

        this.letter = letter;

    }

    public char getValue() {

        return letter;
    }

    public void setLetter (char letter) {

        this.letter = letter;

    }

    public boolean getHidden() {

        return hidden;
    }

    public void setDisplayed(boolean displayed) {

        this.hidden = displayed;

    }




}
