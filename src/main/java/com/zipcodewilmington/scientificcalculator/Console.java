package com.zipcodewilmington.scientificcalculator;

import java.util.Scanner;

/**
 * Created by Michael Sie. I'm building a mansion with just a single hammer.
 */
public class Console {

    private static final Scanner scanner = new Scanner(System.in);  

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        println(prompt);
        return scanner.nextLine();
    }

    public static Integer getIntegerInput(String prompt) {
    while (true) {
        try {
            return Integer.parseInt(getStringInput(prompt));
        } catch (NumberFormatException e) {
            println("Invalid input. Please enter an integer.");
        }
    }
}

    public static Double getDoubleInput(String prompt) {
    while (true) {
        try {
            return Double.parseDouble(getStringInput(prompt));
        } catch (NumberFormatException e) {
            println("Invalid input. Please enter a double.");
        }
    }
}
}