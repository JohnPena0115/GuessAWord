package com.careerdevs;

import java.util.Scanner;

public class UI {

    private static Scanner read = new Scanner(System.in);

    public static int readInt (String question, int min, int max) {

        System.out.print(question);
        System.out.print("\nSelection(" + min + " - " + max + "): ");

        while(true){

            try{

                int optionSelected = Integer.parseInt(read.nextLine());
                if(optionSelected >= min && optionSelected<= max){

                    return optionSelected;
                }

                System.out.print("\nNumber outside of the valid range, please try again: ");


            }catch(NumberFormatException e){

                System.out.print("\nPlease only enter a valid integer: ");

            }
        }
    }
}
