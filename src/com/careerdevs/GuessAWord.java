package com.careerdevs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class GuessAWord {

    public static void main(String[] args) {

      mainMenu();

      //Consider renaming GameDisplay "Display Utilities" ...
        // wait() implemented in seconds seems really jittery
        // try to implement it in milliseconds to see if the transition
        // can be smoother
        // Once you do this, consider constructing a method that makes the
        // words appear one at a time. This method is more likely to engage
        // the user but it will also clean up your code.


    }


    //mainMenu either calls the instructions() method or ends the program
    private static void mainMenu() {

        String mainMenu = "\nMain Menu";
        System.out.println(mainMenu);
        GameDisplay.printBorder(mainMenu.length());

        int userSelection = UI.readInt("\nWelcome to 'Guess That Word'.\nWould you like to ...\n\n" +
                "1) Play\n" +
                "2) Exit\n" , 1, 2 );

        switch(userSelection) {

            case 1:
                instructions();
                break;

            case 2:
                GameDisplay.printBorder(100);
                wait(1);
                System.out.println("Closing down the program ...");
                wait(2);
                GameDisplay.printBorder(100);
                System.exit(0);

        }
    }

    //Randomly selects and returns a word from wordList Array
    //Remember, eventually you want to have a wordBank array from which *****
    //wordList is derived ... this will come into play when the user *****
    //can replay the game *****

    //Consider putting getWord() in the GameDisplay class ... or maybe even *****
    //create a class for word retrieval ... once you introduce the 3 other *****
    //word banks it's going to muddy up GuessAWord ... *****
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
    //Calls game(word) to start the game
    //When you introduce "Easy", "Java" and "Hard" instructions will *****
    //get pushed back a step *****
    private static void instructions() {

        String word = getWord();

        GameDisplay.printBorder(100);

        //wait(1);
        System.out.println("\nExcellent. At the beginning of the game the word you are tasked\n" +
                "with guessing will appear as a series of dashes. Each dash will\n" +
                "correspond to one letter.\n");
        wait(8);
        System.out.println("\nFor example, if the secret word is 'Apple' you will see\n\n");
        wait(4);
        System.out.println("_ _ _ _ _\n\n");
        wait(1);
        System.out.println("at the beginning of the game.\n");
        wait(2);
        GameDisplay.printBorder(100);

        wait(2);
        System.out.println("\nIf you then select 'p' as your first letter, you will see\n\n");
        wait(4);
        System.out.println("_ p p _ _\n\n");
        wait(2);
        System.out.println("on your screen.");
        wait(1);
        GameDisplay.printBorder(100);
        System.out.println("\nLet's begin!");


        wait(1);
        GameDisplay.printBorder(100);
        wait(2);

        System.out.println("\nLoading game ... ");
        wait(2);
        GameDisplay.printBorder(100);

        wait(2);

        game(word);
    }

    //Pauses execution of the program
    public static void wait(int seconds) {

        try{
            TimeUnit.SECONDS.sleep(seconds);

        } catch (InterruptedException ex) {

            Thread.currentThread().interrupt();
        }

    }


    private static void game(String selectedWord){

        //Creating the necessary components for the initial game state
        ArrayList<Letter> letters = new ArrayList<>();
        Set<Character> uniqueLetters = new HashSet<Character>();

        //Populates the letters arraylist and the uniqueLetters hashset
        for(int index = 0; index < selectedWord.length(); index++) {

            Letter hiddenLetter = new Letter(selectedWord.charAt(index));
            letters.add(hiddenLetter);

            uniqueLetters.add(selectedWord.charAt(index));
        }

        //I wonder if I could make this int final for each
        //iteration of the game ********
        int minimalNumberOfGuesses = uniqueLetters.size();

        //Displays the first frame of the game
        GameDisplay.initialFrame(letters, minimalNumberOfGuesses);

        //Asks the user for a letter and verifies that a letter was indeed inputted
        //If a non-alphabetic char is typed, reprompts user for an alphabetic char
        char letterGuessed = UI.confirmAlphabeticChar("\nPick your first letter: ");

        int correctGuesses = 0;
        int letterFrequency = 0;


        //Runs until the number of correct guesses equals the number of necessary guesses
        //to win the game
        while ( correctGuesses < minimalNumberOfGuesses) {

            //Checks if the current character being processed was already typed
            //in by the user. If so, it reprompts the user to type in another
            //letter
             if (Letter.wasCharPreviouslyGuessed(letterGuessed)){

                 System.out.println("It seems you have already typed in " + letterGuessed + ".");
                 letterGuessed = UI.confirmAlphabeticChar("Please pick another letter: ");
                 continue;
             }

            //Iterates through each object in letters, comparing the
            //user input with each object's 'letter' field
            for (int letter = 0; letter < letters.size(); letter++){

                if (letterGuessed == letters.get(letter).getValue()) {
                    Letter.setIsDisplayed(letters.get(letter));
                    letterFrequency++;
                }
            }


            //Sequence for an incorrect guess
            if (letterFrequency == 0) {

                System.out.print("\nSorry, the letter '" + letterGuessed + "' was not found.\n\n");
                Letter.alreadyGuessed.add(letterGuessed);
                GameDisplay.currentState(letters, false);



                letterGuessed = UI.confirmAlphabeticChar("Please try again: ");
                continue;

            }

            //Sequenced for correctly guessed letter
            //Insures that if a user picks a letter that is duplicated in a word,
            //correctGuesses is only incremented by one.
            if (letterFrequency > 1) {
                correctGuesses = correctGuesses + (letterFrequency - (letterFrequency -1));
                System.out.println("\nCongratulations, the letter " + letterGuessed + " was found.\n");
                System.out.println("'" + letterGuessed + "'" + " appears more than once");
                Letter.alreadyGuessed.add(letterGuessed);
            } else {
                correctGuesses++;
            }

            //Resets letterFrequency to zero after each user input
            letterFrequency = 0;

            wait(1);
            System.out.println("\nUnveiling " + Character.toUpperCase(letterGuessed) + " ...\n");
            wait(2);
            GameDisplay.currentState(letters, true);
            letterGuessed = UI.confirmAlphabeticChar("Pick again: ");


        }
    }

}
