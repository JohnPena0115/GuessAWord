package com.careerdevs;

import java.util.Locale;
import java.util.Scanner;

public class UI {

    private static Scanner read = new Scanner(System.in);

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

        //Filters for null input

        while (true) {

            if (preValidatedChar.length() > 0) {

                break;

            } else {

                System.out.println("Try again. You many have pressed the enter button without typing in a letter.");

            }
        }

        //Filters for input that consists of more than one character
        while (true) {

            if (preValidatedChar.length() > 1) {

                System.out.println("Please type in only one character.");

            } else {

                break;
            }
        }

        //Filters non-alphabetic characters
        char potentialLetter = preValidatedChar.charAt(0);

        while (true) {

            if (!(potentialLetter >= 'a' &&  potentialLetter <= 'z')){

                System.out.print("Please only type in a letter:");

                preValidatedChar = read.nextLine().trim().toLowerCase();

                continue;


            } else {

                break;
            }
        }

        char validatedLetter = potentialLetter;

        return validatedLetter;

    }

}
