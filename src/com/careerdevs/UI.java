package com.careerdevs;

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

        System.out.println("\n" + question);

        String preValidatedChar = read.nextLine().trim();

        //Filters for null input
        while (true) {

            if (preValidatedChar.length() > 0) {

                break;

            } else {

                System.out.println("Try again. You many have pressed the enter button without typing in a letter.");

            }
        }

        //Filters for non-char input exclusive of null
        while (true) {

            if (preValidatedChar.length() > 1) {

                System.out.println("Please type in only one character.");

            } else {

                break;
            }
        }

        while (true) {


        }

    }

}
