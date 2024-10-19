package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void shouldReturnZeroWhenGivenEmptyString(){
        Integer result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void shouldGiveSumWhenGivenSingleNumber(){
        Integer result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void shouldGiveSumAsTwoWhenGivenTwoAsSingleNumber(){
        Integer result = stringCalculator.add("2");

        assertEquals(2, result);
    }
}