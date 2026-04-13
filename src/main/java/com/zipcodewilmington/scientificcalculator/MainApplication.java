package com.zipcodewilmington.scientificcalculator;

public class MainApplication {

    private static String trigMode = "Degrees";
    private static String displayMode = "Decimal";
    private static double displayValue = 0.0;

    public static void main(String[] args) {

        ScientificCalculator calc = new ScientificCalculator();

        System.out.println("========================================");
        System.out.println("      Welcome to Scientific Calculator  ");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            printMenu();
            int choice = Console.getIntegerInput("Select option: ");

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }


            if (isNoInputOption(choice)) {
                handleNoInputChoice(choice, calc);
                printDisplay(calc);
            }

            else {
                calc.clear();

                double first = Console.getDoubleInput("Enter your first number: ");
                calc.setCurrentValue(first);

                if (needsSecondNumber(choice)) {
                    double second = Console.getDoubleInput("Enter your second number: ");
                    handleBinaryChoice(choice, second, calc);
                } else {
                    handleUnaryChoice(choice, calc);
                }

                printDisplay(calc);
            }


            System.out.print("\nDo you want to continue? (yes/no): ");
            String answer = Console.getStringInput("").trim().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("y")) {
                running = false;
                System.out.println("Goodbye!");
            }
        }
    }


    private static boolean needsSecondNumber(int choice) {
        return choice == 1 || choice == 2 || choice == 3
            || choice == 4 || choice == 8 || choice == 29;
    }

    private static boolean isNoInputOption(int choice) {
        return choice == 19
        || choice == 24 || choice == 25 || choice == 26
        || choice == 27
        || choice == 31;
    }


    private static void handleNoInputChoice(int choice, ScientificCalculator calc) {

        switch (choice) {
            case 31:                      
                calc.clear();
                displayValue = 0.0;
                System.out.println("Display cleared. Value is now 0.");
                break;

            case 24: // M+
                double before = calc.getCurrentValue();
                calc.memoryAdd();
                System.out.println(" Memory Add Successful!");
                System.out.println("Added value: " + before);
                System.out.println("New memory value: " + calc.getCurrentValue());
                break;

            case 25: // MC
                calc.memoryClear();
                System.out.println(" Memory Cleared Successfully! Memory is now 0.");
                break;

            case 26: // MRC
                calc.memoryRecall();
                System.out.println("Memory Recalled Successfully!");
                System.out.println("Value loaded from memory: " + calc.getCurrentValue());
                break;

            case 27:
                calc.switchDisplayMode();
                displayMode = nextDisplayMode(displayMode);
                System.out.println("Display mode changed to: " + displayMode);
                break;

            case 19:
                calc.switchUnitsMode();
                trigMode = trigMode.equals("Degrees") ? "Radians" : "Degrees";
                System.out.println("Trig mode changed to: " + trigMode);
                break;
        }
    }


    private static void handleBinaryChoice(int choice, double second, ScientificCalculator calc) {

        switch (choice) {
            case 1: calc.add(second); break;
            case 2: calc.subtract(second); break;
            case 3: calc.multiply(second); break;
            case 4: calc.divide(second); break;
            case 8: calc.power(second); break;

            case 29:
                if (second == 0) {
                    System.out.println(" Error: modulo by zero.");
                } else {
                    calc.setCurrentValue(calc.getCurrentValue() % second);
                }
                break;
        }
    }


    private static void handleUnaryChoice(int choice, ScientificCalculator calc) {

        switch (choice) {
            case 5: calc.square(); break;
            case 6: calc.squareRoot(); break;
            case 7: calc.cube(); break;
            case 9: calc.inverse(); break;
            case 10: calc.switchSign(); break;
            case 11: calc.percentage(); break;
            case 12: calc.factorial(); break;

            case 13: calc.sine(); break;
            case 14: calc.cosine(); break;
            case 15: calc.tangent(); break;
            case 16: calc.inverseSine(); break;
            case 17: calc.inverseCosine(); break;
            case 18: calc.inverseTangent(); break;

            case 20: calc.logarithm(); break;
            case 21: calc.inverseLogarithm(); break;
            case 22: calc.naturalLogarithm(); break;
            case 23: calc.inverseNaturalLogarithm(); break;

            case 28:
                calc.setCurrentValue(Math.abs(calc.getCurrentValue()));
                break;
            case 30:                        
                displayValue = calc.getCurrentValue();
                System.out.println("Display set to: " + displayValue);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }


    private static void printDisplay(ScientificCalculator calc) {

        double val = calc.getCurrentValue();

       displayValue = calc.getCurrentValue();     
       System.out.print("\n>>> Display [" + displayMode + "]: ");

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


    private static void printMenu() {

        System.out.println("\n========================================");
        System.out.println("Scientific Calculator | Trig: " + trigMode + " | Display: " + displayMode);
        System.out.println("========================================");

        System.out.println("1. Add        2. Subtract     3. Multiply     4. Divide");
        System.out.println("5. Square     6. SquareRoot   7. Cube         8. Power");
        System.out.println("9. Inverse    10. +/-         11. %            12. Factorial");

        System.out.println("13. Sine       14. Cosine      15. Tangent");
        System.out.println("16. arcsine   17. arccosine   18. arctangent");
        System.out.println("19. Toggle Deg/Rad");

        System.out.println("20. log       21. Inverse log        22. Natural Logarithm          23. e^x");

        System.out.println("24. M+        25. MC          26. MRC");
        System.out.println("27. Change Display Mode");
        System.out.println("28. Absolute Value");
        System.out.println("Current value: " + displayValue);  


        System.out.println("29. Mod");                       
        System.out.println("30. Set Value ");   
        System.out.println("31. Clear Display");
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