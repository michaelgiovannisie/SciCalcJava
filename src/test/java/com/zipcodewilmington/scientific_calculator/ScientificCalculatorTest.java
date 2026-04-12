package com.zipcodewilmington.scientific_calculator;
import com.zipcodewilmington.scientificcalculator.ScientificCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {

    @Test // 1
    public void testAddition() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7349);
        calculator.add(2364);
        assertEquals(9713, calculator.getCurrentValue(), 0.001);
    }

    @Test // 2
    public void testSubtraction() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(23674);
        calculator.subtract(24837);
        assertEquals(-1163, calculator.getCurrentValue(), 0.001);
    }

    @Test // 3
    public void testMultiplication() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7349);
        calculator.multiply(2364);
        assertEquals(17382516, calculator.getCurrentValue(), 0.001);
    }

    @Test // 4
    public void testDivision() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(84327);
        calculator.divide(8347);
        assertEquals(10.102072601, calculator.getCurrentValue(), 0.001);
    }

    @Test // 4.1
    public void testDivisionByZero() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7436);
        calculator.divide(0);
        assertTrue(calculator.isError());
    }

    @Test // 5
    public void testSquare() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(1436);
        calculator.square();
        assertEquals(2062096, calculator.getCurrentValue(), 0.001);
    }

    @Test // 6
    public void testSquareRoot() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(2062096);
        calculator.squareRoot();
        assertEquals(1436, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 6.1
    public void testSquareRootOfNegative() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(-234);
        calculator.squareRoot();
        assertTrue(calculator.isError());   
    }

    @Test // 7
    public void testDoubleExponent() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(734);
        calculator.power(2);
        assertEquals(538756, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 8
    public void testInverse() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(2342);
        calculator.inverse();
        assertEquals(0.000426985, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 8.1
    public void testInverseOfZero() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(0);
        calculator.inverse();
        assertTrue(calculator.isError());   
    }

    @Test // 9
    public void testSwitchSign() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(2543);
        calculator.switchSign();
        assertEquals(-2543, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 10
    public void testClear() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(2873);
        calculator.clear();
        assertEquals(0, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 11
    public void testsetCurrentValue() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7349);
        assertEquals(7349, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 12
    public void testSwitchDisplayMode() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(8172);
        calculator.switchDisplayMode();
        assertEquals(8172, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 13 & 15
    public void testmemoryFunctions() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7349);
        calculator.memoryAdd();
        calculator.memoryRecall();
        assertEquals(7349, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 13.1
    public void testMemoryFunctions() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(7349);
        calculator.memoryAdd();
        calculator.memoryClear();
        calculator.memoryRecall();
        assertEquals(0, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 14
    public void testMemoryClear() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(3453);
        calculator.memoryAdd();
        calculator.memoryClear();
        calculator.memoryRecall();
        assertEquals(0, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 16
    public void testSine() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(30);
        calculator.sine();
        assertEquals(0.5, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 17
    public void testCosine() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(60);
        calculator.cosine();
        assertEquals(0.5, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 18
    public void testTangent() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(45);
        calculator.tangent();
        assertEquals(1, calculator.getCurrentValue(), 0.001);   
    }   

    @Test // 19
    public void testInverseSine() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(0.5);
        calculator.inverseSine();
        assertEquals(30, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 19.1
    public void testInverseSineOutOfRange() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(53);
        calculator.inverseSine();
        assertTrue(calculator.isError());
    }

    @Test // 20
    public void testInverseCosine() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(0.5);
        calculator.inverseCosine();
        assertEquals(60, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 20.1
    public void testInverseCosineOutOfRange() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(-65);
        calculator.inverseCosine();
        assertTrue(calculator.isError());
    }

    @Test // 21
    public void testInverseTangent() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(1);
        calculator.inverseTangent();
        assertEquals(45, calculator.getCurrentValue(), 0.001);   
    }

    @Test // 22
    public void testSwitchTrigMode() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(30);
        calculator.switchTrigMode();
        calculator.sine();
        assertEquals(0.5, calculator.getCurrentValue(), 0.001);
    }

    @Test // 23
    public void testLogarithm() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(10000);
        calculator.logarithm();
        assertEquals(4, calculator.getCurrentValue(), 0.001);
    }

    @Test // 23.1
    public void testLogarithmOfNegative() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(-10000);
        calculator.logarithm();
        assertTrue(calculator.isError());
    }

    @Test // 24
    public void testInverseLogarithm() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(4);
        calculator.inverseLogarithm();
        assertEquals(10000, calculator.getCurrentValue(), 0.001);
    } 

    @Test // 25
    public void testNaturalLogarithm() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(Math.E);
        calculator.naturalLogarithm();
        assertEquals(1, calculator.getCurrentValue(), 0.001);
    }       

    @Test // 25.1
    public void testNaturalLogarithmOfNegative() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(-Math.E);
        calculator.naturalLogarithm();
        assertTrue(calculator.isError());
    }

    @Test // 26
    public void testInverseNaturalLogarithm() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(1);
        calculator.inverseNaturalLogarithm();
        assertEquals(Math.E, calculator.getCurrentValue(), 0.001);
    }

    @Test // 27
    public void testFactorial() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(5);
        calculator.factorial();
        assertEquals(120, calculator.getCurrentValue(), 0.001);
    }  

    @Test // 27.1
    public void testFactorialOfNegative() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(-5);
        calculator.factorial();
        assertTrue(calculator.isError());
    }  

    @Test // 27.2
    public void testFactorialOfNonInteger() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(5.5);
        calculator.factorial();
        assertTrue(calculator.isError());
    }   

    @Test // 28
    public void testCube() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(3);
        calculator.cube();
        assertEquals(27, calculator.getCurrentValue(), 0.001);
    } 

    @Test // 29
    public void testPercentage() {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.setCurrentValue(50);
        calculator.percent();
        assertEquals(0.5, calculator.getCurrentValue(), 0.001);
    }
}   