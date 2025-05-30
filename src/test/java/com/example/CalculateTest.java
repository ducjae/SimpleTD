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
        assertEquals(0, calculate.plus(-2, 2));
        assertEquals(-5, calculate.plus(-2, -3));
    }

    @Test
    public void testMinus() {
        assertEquals(-1, calculate.minus(2, 3));
        assertEquals(-4, calculate.minus(-2, 2));
        assertEquals(1, calculate.minus(-2, -3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculate.multiply(2, 3));
        assertEquals(-4, calculate.multiply(-2, 2));
        assertEquals(6, calculate.multiply(-2, -3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculate.divide(6, 3));
        assertEquals(-1, calculate.divide(-2, 2));
        assertEquals(1, calculate.divide(-3, -3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculate.divide(1, 0));
    }
}
