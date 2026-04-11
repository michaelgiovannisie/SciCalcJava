package com.zipcodewilmington.scientificcalculator;

/**
 * Created by Michael Sie on 4/11/26. 
 * I barely understands how to use a calculator, let alone a scientific one. 
 * But I have a dream of working in a big tech company.
 * I have no idea how to create a scientific calculator, but I wannt to learn. This is going to be a long journey for me.
 */


public class ScientificCalculator {
    private double currentValue = 0;
    private double currentMemory = 0;
    private String currentTrigMode = "Degrees";
    private String currentDisplayMode = "Decimal";
    private boolean isError= false;

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        if (isError) {
            return ;
        } 
        this.currentValue = currentValue;
    }   

    public void clear() {
        currentValue = 0;
        isError = false;
    }

    public void add(double value) {
        if (isError) {
            return ;
        } 
        currentValue += value;
    }

    public void subtract(double value) {
        if (isError) {
            return ;
        } 
        currentValue -= value;
    }

    public void multiply(double value) {
        if (isError) {
            return ;
        } 
        currentValue *= value;
    }

    public void divide(double value) {
        if (isError) {
            return ;
        } 
        if (value == 0) {
            isError = true;
        } else {
            currentValue /= value;
        }
    }

    public void square() {
        if (isError) {
            return ;
        } 
        currentValue *= currentValue;
    }

    public void squareRoot() {
        if (isError) {
            return ;
        } 
        if (currentValue < 0) {
            isError = true;
        } else {
            currentValue = Math.sqrt(currentValue);
        }
    }

    public void inverse() {
        if (isError) {
            return ;
        } 
        if (currentValue == 0) {
            isError = true;
        } else {
            currentValue = 1 / currentValue;
        }
    }

    public void switchSign() {
        if (isError) {
            return ;
        } 
        currentValue = -currentValue;
    }

    public void power(double exponent) {
        if (isError) {
            return ;
        } 
        currentValue = Math.pow(currentValue, exponent);
    }

    public void memoryAdd() {
        if (isError) {
            return ;
        } 
        currentMemory += currentValue;
        currentValue = currentMemory;
    }

    public void memoryClear() {
        currentMemory = 0;
    }

    public void memoryRecall() {
        if (isError) {
            return ;
        } 
        currentValue = currentMemory;
    }

    public void switchUnitsMode(String mode) {
        if (mode.equals("Degrees") || mode.equals("Radians")) {
            currentTrigMode = mode;
        }
    }

    public void switchUnitsMode() {
        if (currentTrigMode.equals("Degrees")) {
            currentTrigMode = "Radians";
        } else {
            currentTrigMode = "Degrees";
        }
    }

    public void switchDisplayMode(String mode) {
        if (mode.equals("Decimal") || mode.equals("Octal") || mode.equals("Binary") || mode.equals("Hexadecimal")) {
            currentDisplayMode = mode;
        }
    }

    public void switchDisplayMode() {
        if (currentDisplayMode.equals("Decimal")) {
            currentDisplayMode = "Hexadecimal";
        } else if (currentDisplayMode.equals("Hexadecimal")) {
            currentDisplayMode = "Binary";
        } else if (currentDisplayMode.equals("Binary")) {
            currentDisplayMode = "Octal";
        } else {
            currentDisplayMode = "Decimal";
        }
    }

    public void sine() {
        if (isError) {
            return ;
        } 
        double radians = currentTrigMode.equals("Degrees") ? Math.toRadians(currentValue) : currentValue;
        currentValue = Math.sin(radians);
    }

    public void cosine() {
        if (isError) {
            return ;
        } 
        double radians = currentTrigMode.equals("Degrees") ? Math.toRadians(currentValue) : currentValue;
        currentValue = Math.cos(radians);
    }

    public void tangent() {
        if (isError) {
            return ;
        } 
        double radians = currentTrigMode.equals("Degrees") ? Math.toRadians(currentValue) : currentValue;
        currentValue = Math.tan(radians);
    }

    public void inverseSine() {
        if (isError) {
            return ;
        } if (currentValue < -1 || currentValue > 1) {
            isError = true;
            return ;
        } else {
        double radians = Math.asin(currentValue);
        currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
        }
    }

    public void inverseCosine() {
        if (isError) {
            return ;
        } 
        if (currentValue < -1 || currentValue > 1) {
            isError = true;
            return ;
        } else {
        double radians = Math.acos(currentValue);
        currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
        }
    }

    public void inverseTangent() {
        if (isError) {
            return ;
        } 
        double radians = Math.atan(currentValue);
        currentValue = currentTrigMode.equals("Degrees") ? Math.toDegrees(radians) : radians;
    }

    public void logarithm() {
        if (isError) {
            return ;
        } 
        if (currentValue <= 0) {
            isError = true;
        } else {
            currentValue = Math.log10(currentValue);
        }
    }

    public void inverseLogarithm() {
        if (isError) {
            return ;
        } 
        currentValue = Math.pow(10, currentValue);
    }

    public void naturalLogarithm() {
        if (isError) {
            return ;
        } 
        if (currentValue <= 0) {
            isError = true;
        } else {
            currentValue = Math.log(currentValue);
        }
    }

    public void inverseNaturalLogarithm() {
        if (isError) {
            return ;
        } 
        currentValue = Math.exp(currentValue);
    }

    public void factorial() {
        if (isError) {
            return ;
        } 
        if (currentValue < 0 || currentValue != Math.floor(currentValue)) {
            isError = true;
        } else {
            double result = 1;
            for (int i = 1; i <= (int)currentValue; i++) {
                result *= i;
            }
            currentValue = result;
        }
    }

    public void cube() {
        if (isError) {
            return ;
        } 
        currentValue *= currentValue * currentValue;
    }

    public void percentage() {
        if (isError) {
            return ;
        } 
        currentValue /= 100;
    }
}
