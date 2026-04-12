package com.zipcodewilmington.scientificcalculator;

/**
 * Created by leon on 2/9/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        Console.println("Welcome to my calculator!");
        
        double startingValue = Console.getDoubleInput("Please enter a starting value:");
        calculator.setCurrentValue(startingValue);
    }
}
