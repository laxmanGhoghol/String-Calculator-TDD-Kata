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

    @Test
    void shouldGiveZeroWhenGivenNullInput(){
        Integer result = stringCalculator.add(null);

        assertEquals(0, result);
    }

    @Test
    void shouldGiveSumOfGivenTwoNumbers(){
        Integer result = stringCalculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void shouldGiveSumOfMultipleNumbersWithNewLinesBetweenAsSeparator(){
        Integer result = stringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void shouldSupportGivenDelimitersInInput(){
        Integer result = stringCalculator.add("//;\n1;2");

        assertEquals(3, result);
    }

    @Test
    void shouldSupportDifferentDelimiterPeriodGivenInInput(){
        Integer result = stringCalculator.add("//.\n2.2");

        assertEquals(4, result);
    }

    @Test
    void shouldGiveErrorWhenGivenNegativeNumbers(){
        assertThrows(NegativeNumberException.class, ()->{
            stringCalculator.add("//,\n-2,4");
        });
    }

    @Test
    void shouldGiveErrorMessageWithGivenNegativeNumbers(){
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> {
            stringCalculator.add("//,\n-2,4");
        });

        assertEquals("negative numbers not allowed [-2]", negativeNumberException.getMessage());
    }

    @Test
    void shouldGiveErrorMessageWithGivenMultipleNegativeNumbers(){
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> {
            stringCalculator.add("//,\n-2,-4,1,-3,5");
        });

        assertEquals("negative numbers not allowed [-2, -4, -3]", negativeNumberException.getMessage());
    }

}