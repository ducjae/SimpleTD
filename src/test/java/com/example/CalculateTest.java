package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    private Calculate calculate;

    @BeforeEach
    public void setUp() {
        calculate = new Calculate();
    }

    @Test
    public void testPlus() {
        assertEquals(5, calculate.plus(2, 3));
        assertEquals(-1, calculate.plus(-2, 1));
        assertEquals(0, calculate.plus(0, 0));
    }

    @Test
    public void testMinus() {
        assertEquals(1, calculate.minus(3, 2));
        assertEquals(-3, calculate.minus(-2, 1));
        assertEquals(0, calculate.minus(0, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculate.multiply(2, 3));
        assertEquals(-2, calculate.multiply(-2, 1));
        assertEquals(0, calculate.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculate.divide(6, 3));
        assertEquals(-2, calculate.divide(-4, 2));
        assertEquals(0, calculate.divide(0, 1));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculate.divide(1, 0));
    }
}
