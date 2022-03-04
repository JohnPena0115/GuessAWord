package com.careerdevs;

import java.util.Scanner;

public class UI {

    private static final Scanner read = new Scanner(System.in);

    public static int readInt(String question, int min, int max) {

        System.out.print(question);
        System.out.print("\nSelection(" + min + " - " + max + "): ");

        while (true) {

            try {

                int optionSelected = Integer.parseInt(read.nextLine());
                if (optionSelected >= min && optionSelected <= max) {

                    return optionSelected;
                }

                System.out.print("\nNumber outside of the valid range, please try again: ");


            } catch (NumberFormatException e) {
                System.out.print("\nPlease only enter a valid integer: ");
            }
        }
    }

    public static char confirmAlphabeticChar(String question) {

        System.out.print("\n" + question);

        String preValidatedChar = read.nextLine().trim().toLowerCase();


        while (true) {

            //Filters for null input
            if (preValidatedChar.length() == 0) {
                System.out.println("\nYou many have pressed the enter button without typing in a letter.");
                System.out.print("Try again: ");
                preValidatedChar = read.nextLine().trim().toLowerCase();
                System.out.println("");
                continue;
            }

            //Filters for input that consists of more than one character
            if (preValidatedChar.length() > 1) {
                System.out.print("\nPlease type in only one character: ");
                preValidatedChar = read.nextLine().trim().toLowerCase();
                System.out.println("");
                continue;
            }


            //Filters for non-alphabetic characters
            char potentialLetter = preValidatedChar.charAt(0);

            if (!(potentialLetter >= 'a' &&  potentialLetter <= 'z')) {
                System.out.print("Please only type in a letter:");
                preValidatedChar = read.nextLine().trim().toLowerCase();
                System.out.println("");
                continue;
            }

            char validatedLetter = potentialLetter;

            return validatedLetter;

        }
    }
}
