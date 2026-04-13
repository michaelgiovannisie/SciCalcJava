package com.zipcodewilmington.scientificcalculator;

public class MainApplication {

    private static String trigMode = "Degrees";
    private static String displayMode = "Decimal";

    public static void main(String[] args) {

        ScientificCalculator calc = new ScientificCalculator();
        boolean running = true;

        System.out.println("\n========================================");
        System.out.println("Welcome to Michael and Prachi's Calculator");
        System.out.println("If you find any bugs, you're probably higher than the Empire State.");
        System.out.println("========================================");
        
        double startingValue = Console.getDoubleInput("\n \n Please enter a starting value:");
        calc.setCurrentValue(startingValue);

        while (running) {
            System.out.println("\n \n========================================");
            if (calc.isError()) {
                Console.println(" Current Value: Error");
                    } else {
                Console.println(" Current Value: " + calc.getCurrentValue());
                    }
            printMenu();
            int choice = Console.getIntegerInput("Select option: ");

            if (choice == 0) {
                System.out.println("Adieux!");
                break;
            }

            // MEMORY & SETTINGS (NO INPUT)
            if (isNoInputOption(choice)) {
                handleNoInputChoice(choice, calc);
                printDisplay(calc);
            }

            // NORMAL OPERATIONS
            else {
                if (needsSecondNumber(choice)) {
                    double second = Console.getDoubleInput("Enter your second number: ");
                    handleBinaryChoice(choice, second, calc);
                } else {
                    handleUnaryChoice(choice, calc);
                }
                printDisplay(calc);
            }

            // CONTINUE?

            System.out.print("\nDo you want to continue? (yes/no): ");
            String answer = Console.getStringInput("").trim().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("y")) {
                if (answer.equals("no") || answer.equals("n")) {
                    System.out.println("Goodbye!");
                    running = false;
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    // CHECKS

    private static boolean needsSecondNumber(int choice) {
        return choice == 1 || choice == 2 || choice == 3
            || choice == 4 || choice == 7 || choice == 11;
    }

    private static boolean isNoInputOption(int choice) {
        return choice == 10 || choice == 12 || choice == 13 || choice == 14 || choice == 15
             || choice == 22;
    }

    // MEMORY & SETTINGS

    private static void handleNoInputChoice(int choice, ScientificCalculator calc) {

        switch (choice) {
            case 10:calc.clear(); break;
            case 12:
                calc.switchDisplayMode();
                displayMode = nextDisplayMode(displayMode);
                System.out.println("Display mode changed to: " + displayMode);
                break;
            case 13: // M+
                double before = calc.getCurrentValue();
                calc.memoryAdd();
                System.out.println(" Memory Add Successful!");
                System.out.println("Added value: " + before);
                System.out.println("New memory value: " + calc.getCurrentValue());
                break;

            case 14: // MC
                calc.memoryClear();
                System.out.println(" Memory Cleared Successfully! Memory is now 0.");
                break;

            case 15: // MRC
                calc.memoryRecall();
                System.out.println("Memory Recalled Successfully!");
                System.out.println("Value loaded from memory: " + calc.getCurrentValue());
                break;

            case 22:
                calc.switchUnitsMode();
                trigMode = trigMode.equals("Degrees") ? "Radians" : "Degrees";
                System.out.println("Trig mode changed to: " + trigMode);
                break;

            
        }
    }

    // TWO NUMBER OPERATIONS

    private static void handleBinaryChoice(int choice, double second, ScientificCalculator calc) {

        switch (choice) {
            case 1: calc.add(second); break;
            case 2: calc.subtract(second); break;
            case 3: calc.multiply(second); break;
            case 4: calc.divide(second); break;
            case 7: calc.power(second); break;
            case 11: calc.setCurrentValue(second); break;
        }
    }

    // ONE NUMBER OPERATIONS

    private static void handleUnaryChoice(int choice, ScientificCalculator calc) {

        switch (choice) {
            case 5: calc.square(); break;
            case 6: calc.squareRoot(); break;
            case 8: calc.inverse(); break;
            case 9: 
                calc.switchSign();
                if (calc.getCurrentValue() == -0.0) {
                    calc.setCurrentValue(0.0);
                } 
                break;
            case 16: calc.sine(); break;
            case 17: calc.cosine(); break;
            case 18: calc.tangent(); break;
            case 19: calc.inverseSine(); break;
            case 20: calc.inverseCosine(); break;
            case 21: calc.inverseTangent(); break;
            case 23: calc.logarithm(); break;
            case 24: calc.inverseLogarithm(); break;
            case 25: calc.naturalLogarithm(); break;
            case 26: calc.inverseNaturalLogarithm(); break;
            case 27: calc.factorial(); break;
            case 28: calc.cube(); break;
            case 29: calc.percent(); break;
            default:
                System.out.println("Invalid option.");
            
        }
    }

    // DISPLAY

    private static void printDisplay(ScientificCalculator calc) {

        if (calc.isError()) {
                System.out.println("Err. Please clear the calculator to continue.");
                return;
        }

        double val = calc.getCurrentValue();

        System.out.print("\n>>> Value: [" + displayMode + "]: ");

        switch (displayMode) {
            case "Binary":
                System.out.println(Long.toBinaryString((long) val));
                break;

            case "Octal":
                System.out.println(Long.toOctalString((long) val));
                break;

            case "Hexadecimal":
                System.out.println(Long.toHexString((long) val).toUpperCase());
                break;

            default:
                System.out.println(val);
        }
    }

    // MENU

    private static void printMenu() {
        System.out.println("========================================");
        System.out.println("Scientific Calculator | Trig: " + trigMode + " | Display: " + displayMode);
        System.out.println("========================================");

        System.out.println("1. Add        2.  Subtract     3. Multiply            4. Divide");
        System.out.println("5. Square     6.  SquareRoot   7. Power               8. Inverse");
        System.out.println("9. +/-        10. Clear");
        System.out.println("11. Set current value         12. Switch Display Mode");
        System.out.println("13. M+        14. MC          15. MRC");
        System.out.println("16. Sin       17. Cos         18. Tan");
        System.out.println("19. asin      20. acos        21. atan");
        System.out.println("22. Toggle Deg/Rad");
        System.out.println("23. log(x)    24. 10^x        25. ln(x)              26. e^x");
        System.out.println("27. Factorial 28. x^3         29. %                   0. Exit");
    }

    private static String nextDisplayMode(String current) {
        switch (current) {
            case "Decimal": return "Hexadecimal";
            case "Hexadecimal": return "Binary";
            case "Binary": return "Octal";
            default: return "Decimal";
        }
    }
}