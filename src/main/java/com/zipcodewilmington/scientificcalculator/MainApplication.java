package com.zipcodewilmington.scientificcalculator;

/**
 * Created by leon on 2/9/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        boolean isRunning = true;

        Console.println("Welcome to my calculator! I hope it works... If it doesn't, it's not my code, it's your fault.");
        double startingValue = Console.getDoubleInput("Please enter a starting value:");
        calculator.setCurrentValue(startingValue);

        while(isRunning) {
            Console.println("Current value: %s", calculator.getCurrentValue());
            Console.println("Please select an operation:");
            Console.println("1. Add");
            Console.println("2. Subtract");
            Console.println("3. Multiply");
            Console.println("4. Divide");
            Console.println("5. Square");
            Console.println("6. Square Root");
            Console.println("7. Power");
            Console.println("8. Inverse");
            Console.println("9. Switch Sign");
            Console.println("10. Clear");
            Console.println("11. Set Current Value");
            Console.println("12. Switch Display Mode");
            Console.println("13. Memory Add");
            Console.println("14. Memory Clear");
            Console.println("15. Memory Recall");
            Console.println("16. Sine");
            Console.println("17. Cosine");
            Console.println("18. Tangent");
            Console.println("19. Inverse Sine");
            Console.println("20. Inverse Cosine");
            Console.println("21. Inverse Tangent");
            Console.println("22. Switch Units Mode");
            Console.println("23. Logarithm");
            Console.println("24. Inverse Logarithm");
            Console.println("25. Natural Logarithm");
            Console.println("26. Inverse Natural Logarithm");
            Console.println("27. Factorial");
            Console.println("28. Cube");
            Console.println("29. Percentage");
            Console.println("30. Exit");

            int choice = Console.getIntegerInput("");

            switch (choice) {
                case 1:
                    double addValue = Console.getDoubleInput("Enter a value to add:");
                    calculator.add(addValue);
                    break;
                case 2:
                    double subtractValue = Console.getDoubleInput("Enter a value to subtract:");
                    calculator.subtract(subtractValue);
                    break;
                case 3:
                    double multiplyValue = Console.getDoubleInput("Enter a value to multiply:");
                    calculator.multiply(multiplyValue);
                    break;
                case 4:
                    double divideValue = Console.getDoubleInput("Enter a value to divide:");
                    calculator.divide(divideValue);
                    break;
                case 5:
                    calculator.square();
                    break;
                case 6:
                    calculator.squareRoot();
                    break;
                case 7:
                    double exponent = Console.getDoubleInput("Enter an exponent:");
                    calculator.power(exponent);
                    break;
                case 8:
                    calculator.inverse();
                    break;
                case 9:
                    calculator.switchSign();
                    break;
                case 10:
                    calculator.clear();
                    break;
                case 11:
                    double currentValue = Console.getDoubleInput("Enter a new current value:");
                    calculator.setCurrentValue(currentValue);
                    break;
                case 12:
                    calculator.switchDisplayMode();
                    break;
                case 13:
                    calculator.memoryAdd();
                    break;
                case 14:
                    calculator.memoryClear();
                    break;
                case 15:
                    calculator.memoryRecall();
                    break;
                case 16:
                    calculator.sine();
                    break;
                case 17:
                    calculator.cosine();
                    break;
                case 18:
                    calculator.tangent();
                    break;
                case 19:
                    calculator.inverseSine();
                    break;
                case 20:
                    calculator.inverseCosine();
                    break;
                case 21:
                    calculator.inverseTangent();
                    break;
                case 22:
                    calculator.switchUnitsMode();
                    break;
                case 23:
                    calculator.logarithm();
                    break;
                case 24:
                    calculator.inverseLogarithm(); 
                    break;
                case 25:
                    calculator.naturalLogarithm();
                    break;
                case 26:
                    calculator.inverseNaturalLogarithm();
                    break;
                case 27:
                    calculator.factorial();
                    break;
                case 28:
                    calculator.cube();
                    break;
                case 29:
                    calculator.percent();
                    break;
                case 30:
                    isRunning = false;
                    Console.println("adieux!");
                    break;
                default:
                    Console.println("Invalid choice. Please try again.");  
            }
    }
}
}

