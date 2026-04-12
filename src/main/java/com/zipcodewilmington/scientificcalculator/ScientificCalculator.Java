package com.zipcodewilmington.scientificcalculator;

public class ScientificCalculator {

    private double currentValue = 0.0;
    private double currentMemory = 0;
    private String currentTrigMode = "Degrees";
    private String currentDisplayMode = "Decimal";
    private boolean isError = false;



// Get current number on the display
    public double getCurrentValue() {
        return currentValue;
    }

// Change the number on the display
    public void setCurrentValue(double value) {
        this.currentValue = value;
        this.isError = false; // reset error when new value is set
    }

    public void clear() {
        this.currentValue = 0.0;
        this.isError = false; // also clear error state
    }


    public String getDisplay() {
        return isError ? "Err" : String.valueOf(currentValue);
    }

    

    private void setError(String message) {
        System.out.println(message);
        isError = true;
    }



    public void add(double value) {
        if (isError) return;
        currentValue += value;
    }

    public void subtract(double value) {
        if (isError) return;
        currentValue -= value;
    }

    public void multiply(double value) {
        if (isError) return;
        currentValue *= value;
    }

    public void divide(double value) {
        if (isError) return;
        if (value == 0) {
            setError("Error: cannot divide by zero.");
        } else {
            currentValue /= value;
        }
    }

    // ===== POWER / ROOT =====

    public void square() {
        if (isError) return;
        currentValue = currentValue * currentValue;
    }

    public void cube() {
        if (isError) return;
        currentValue = Math.pow(currentValue, 3);
    }

    public void squareRoot() {
        if (isError) return;
        if (currentValue < 0) {
            setError("Error: cannot take square root of a negative number.");
        } else {
            currentValue = Math.sqrt(currentValue);
        }
    }

    public void power(double exponent) {
        if (isError) return;
        currentValue = Math.pow(currentValue, exponent);
    }

    public void inverse() {
        if (isError) return;
        if (currentValue == 0) {
            setError("Error: cannot take inverse of zero.");
        } else {
            currentValue = 1 / currentValue;
        }
    }

    // ===== SIGN / PERCENT =====

    public void switchSign() {
        if (isError) return;
        currentValue = -currentValue;
    }

    public void percentage() {
        if (isError) return;
        currentValue /= 100;
    }

    // ===== FACTORIAL =====

    public void factorial() {
        if (isError) return;
        if (currentValue < 0 || currentValue != Math.floor(currentValue)) {
            setError("Error: factorial requires a non-negative whole number.");
        } else {
            double result = 1;
            for (int i = 1; i <= (int) currentValue; i++) {
                result *= i;
            }
            currentValue = result;
        }
    }

    // ===== MEMORY =====

    public void memoryAdd() {
        if (isError) return;
        currentMemory += currentValue;
        currentValue = currentMemory;
    }

    public void memoryClear() {
        currentMemory = 0;
    }

    public void memoryRecall() {
        if (isError) return;
        currentValue = currentMemory;
    }

    // ===== TRIG =====

    public String getCurrentTrigMode() {
        return currentTrigMode;
    }

    public void switchUnitsMode() {
        currentTrigMode = currentTrigMode.equals("Degrees") ? "Radians" : "Degrees";
    }

    private double toRadians(double value) {
        return currentTrigMode.equals("Degrees") ? Math.toRadians(value) : value;
    }

    public void sine() {
        if (isError) return;
        currentValue = Math.sin(toRadians(currentValue));
    }

    public void cosine() {
        if (isError) return;
        currentValue = Math.cos(toRadians(currentValue));
    }

    public void tangent() {
        if (isError) return;
        currentValue = Math.tan(toRadians(currentValue));
    }

    public void inverseSine() {
        if (isError) return;
        if (currentValue < -1 || currentValue > 1) {
            setError("Error: asin input must be between -1 and 1.");
        } else {
            double radians = Math.asin(currentValue);
            currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
        }
    }

    public void inverseCosine() {
        if (isError) return;
        if (currentValue < -1 || currentValue > 1) {
            setError("Error: acos input must be between -1 and 1.");
        } else {
            double radians = Math.acos(currentValue);
            currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
        }
    }

    public void inverseTangent() {
        if (isError) return;
        double radians = Math.atan(currentValue);
        currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
    }

    // ===== LOGS =====

    public void logarithm() {
        if (isError) return;
        if (currentValue <= 0) {
            setError("Error: log requires a positive number.");
        } else {
            currentValue = Math.log10(currentValue);
        }
    }

    public void inverseLogarithm() {
        if (isError) return;
        currentValue = Math.pow(10, currentValue);
    }

    public void naturalLogarithm() {
        if (isError) return;
        if (currentValue <= 0) {
            setError("Error: ln requires a positive number.");
        } else {
            currentValue = Math.log(currentValue);
        }
    }

    public void inverseNaturalLogarithm() {
        if (isError) return;
        currentValue = Math.exp(currentValue);
    }

    // ===== DISPLAY MODE =====

    public String getCurrentDisplayMode() {
        return currentDisplayMode;
    }

    public void switchDisplayMode() {
        switch (currentDisplayMode) {
            case "Decimal": currentDisplayMode = "Hexadecimal"; break;
            case "Hexadecimal": currentDisplayMode = "Binary"; break;
            case "Binary": currentDisplayMode = "Octal"; break;
            default: currentDisplayMode = "Decimal"; break;
        }
    }
}