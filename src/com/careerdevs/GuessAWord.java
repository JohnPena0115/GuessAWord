package com.careerdevs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class GuessAWord {

    public static void main(String[] args) {

//        mainMenu();






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

        String selectedWord = wordList[randomIndex].toLowerCase();

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

        System.out.println("Starting up the game!");

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

        //Establishing initial state of game
        //Creating an array list of Letter objects with char and boolean
        //fields of "letter" and "hidden" respectively
        ArrayList<Letter> letters = new ArrayList<>();
        Set<Character> uniqueLetters = new HashSet<Character>();

        for(int index = 0; index < selectedWord.length(); index++) {

            Letter hiddenLetter = new Letter(selectedWord.charAt(index));
            letters.add(hiddenLetter);

            uniqueLetters.add(selectedWord.charAt(index));
        }

        //Asks the user for a letter and verifies that a letter was indeed inputted
        //If a non-alphabetic letter is typed, reprompts user for a letter
        char letterGuessed = UI.confirmAlphabeticChar("Pick a letter: ");

        int correctGuesses = 0;
        int necessaryGuesses = uniqueLetters.size();
        int potentialDuplicate = 0;


        //Runs until the number of correct guesses equals the number of necessary guesses
        //to win the game
        while ( correctGuesses < necessaryGuesses) {




            //Iterates through the letters array list looking for a match between
            //the char field in each object and the letter typed in by user
            for (int index = 0; index < letters.size(); index++){

                Letter currentLetter = letters.get(index);

                if (letterGuessed == currentLetter.getValue()) {

                    currentLetter.setDisplayed(true);
                    potentialDuplicate++;
                }
            }

            //Insures that if a user picks a letter that is duplicated in a word,
            //correctGuesses is only incremented by one.
            if (potentialDuplicate > 1) {
                correctGuesses = correctGuesses + (potentialDuplicate - (potentialDuplicate -1));
            } else {
                correctGuesses++;
            }
            potentialDuplicate = 0;


        }









    }

}
