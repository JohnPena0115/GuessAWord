package com.careerdevs;

import java.util.concurrent.TimeUnit;


public class GuessAWord {

    public static void main(String[] args) {

        mainMenu();



    }


    //mainMenu either calls instructions or ends the program
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

    //Introduces user to game layout
    private static void instructions() {

        String word = getWord();

        System.out.println("\nExcellent. At the beginning of the game the word you are tasked\n" +
                "with guessing will appear as a series of dashes. Each dash will\n" +
                "correspond with one letter in that word.\n" +
                "" +
                "\nFor example, if the secret word was 'Apple' you would see _ _ _ _ _\n" +
                "at the beginning of the game.\n" +
                "\n" +
                "If you then selected 'p' as your first letter, after you pressed entered\n" +
                "you would see _ p p _ _ on your screen.\n" +
                "\n");

//                wait(15);

        System.out.println("Let's begin!");

//        wait(2);

        game(word);
    }

    //Pauses execution of the program to allow user to read instructions
    public static void wait(int seconds) {

        try{
            TimeUnit.SECONDS.sleep(seconds);

        } catch (InterruptedException ex) {

            Thread.currentThread().interrupt();
        }

    }

    private static void game(String selectedWord){

        //testing UI.confirmAlphabeticChar
        char letterTyped = UI.confirmAlphabeticChar("Pick a letter: ");
        System.out.println(letterTyped);


        /*
        *
        * Next steps
        *   Consider making each letter of the selected word
        *   an object and giving it a boolean field ... you could
        *   use this field to simplify the decision to eiter
        *   display the letter or hide it ...
        *
        */



    }

}
