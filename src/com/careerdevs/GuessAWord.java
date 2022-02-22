package com.careerdevs;


public class GuessAWord {

    public static void main(String[] args) {

        mainMenu();



    }



    private static void mainMenu() {

        System.out.println("\nMain Menu");
        System.out.println("----------");

        int userSelection = UI.readInt("Welcome to Word Guess.\nWould you like to ...\n\n" +
                "1) Play\n" +
                "2) Exit\n" , 1, 2 );

        switch(userSelection) {

            case 1:
                instructions();
                break;

            case 2:
                 System.exit(0);

        }

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

        int randomIndex = (int)(Math.random() * wordList.length);

        String selectedWord = wordList[randomIndex];

        return selectedWord;

    }

    private static void instructions() {

        String word = getWord();

        System.out.println("\nExcellent. At the beginning of the game the word you are tasked\n" +
                "with guessing will appear as a series of dashes. Each dash will\n" +
                "correspond with one letter in that word.\n" +
                "" +
                "\nType in a letter. If the letter is present, the dash that letter corresponds\n" +
                "with will disappear and the letter will take its place.");


    }

    private static void game(String selectedWord){


    }

}
