package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenGivenEmptyString(){
        StringCalculator stringCalculator = new StringCalculator();
        Integer result = stringCalculator.add("");

        assertEquals(0, result);
    }
}