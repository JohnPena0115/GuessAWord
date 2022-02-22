package com.careerdevs;


public class GuessAWord {

    public static void main(String[] args) {



    }

    private static void welcome() {

        String word = getWord();



    }

    private static String getWord() {

        String[] wordList = new String[14];
        wordList[0] = "Object";
        wordList[1] = "Encapsulation";
        wordList[2] = "Assign";
        wordList[3] = "Primitive";
        wordList[4] = "Method";
        wordList[5] = "Declaration";
        wordList[6] = "Parameter";
        wordList[7] = "Polymorphism";
        wordList[8] = "Class";
        wordList[9] = "Constructor";
        wordList[10] = "Abstraction";
        wordList[11] = "Initialize";
        wordList[12] = "Instantiate";
        wordList[13] = "Inheritance";

        int selectedIndex = (int)(Math.random() * wordList.length);

        String selectedWord = wordList[selectedIndex];

        return selectedWord;

    }

}
