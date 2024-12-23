package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void shouldReturnZeroWhenGivenEmptyString(){
        Integer result = stringCalculator.add("", null, null);

        assertEquals(0, result);
    }

    @Test
    void shouldGiveSumWhenGivenSingleNumber(){
        Integer result = stringCalculator.add("1", null, null);

        assertEquals(1, result);
    }

    @Test
    void shouldGiveSumAsTwoWhenGivenTwoAsSingleNumber(){
        Integer result = stringCalculator.add("2", null, null);

        assertEquals(2, result);
    }

    @Test
    void shouldGiveZeroWhenGivenNullInput(){
        Integer result = stringCalculator.add(null, null, null);

        assertEquals(0, result);
    }

    @Test
    void shouldGiveSumOfGivenTwoNumbers(){
        Integer result = stringCalculator.add("1,2", null, null);

        assertEquals(3, result);
    }

    @Test
    void shouldGiveSumOfMultipleNumbersWithNewLinesBetweenAsSeparator(){
        Integer result = stringCalculator.add("1\n2,3", null, null);

        assertEquals(6, result);
    }

    @Test
    void shouldSupportGivenDelimitersInInput(){
        Integer result = stringCalculator.add("//;\n1;2", null, null);

        assertEquals(3, result);
    }

    @Test
    void shouldSupportDifferentDelimiterPeriodGivenInInput(){
        Integer result = stringCalculator.add("//.\n2.2", null, null);

        assertEquals(4, result);
    }

    @Test
    void shouldGiveErrorWhenGivenNegativeNumbers(){
        assertThrows(NegativeNumberException.class, ()-> stringCalculator.add("//,\n-2,4", null, null));
    }

    @Test
    void shouldGiveErrorMessageWithGivenNegativeNumbers(){
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> stringCalculator.add("//,\n-2,4", null, null));

        assertEquals("negative numbers not allowed [-2]", negativeNumberException.getMessage());
    }

    @Test
    void shouldGiveErrorMessageWithGivenMultipleNegativeNumbers(){
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> stringCalculator.add("//,\n-2,-4,1,-3,5", null, null));

        assertEquals("negative numbers not allowed [-2, -4, -3]", negativeNumberException.getMessage());
    }

    @Test
    void shouldIgnoreWhiteSpacesBetween(){
        Integer result = stringCalculator.add("  2  ,  3 \n 4", null, null);

        assertEquals(9, result);
    }

    @Test
    void shouldIgnoreWhiteSpacesAfterDelimiter(){
        Integer result = stringCalculator.add("3, 4, , ,  ", null, null);

        assertEquals(7, result);
    }

    @Test
    void shouldGiveMultipliedNumberWhenGivenDelimitterIsAsterik(){
        Integer result = stringCalculator.add("//*\n2*4", null, null);

        assertEquals(8, result);

    }

    //todo: expected os tjat user should be able to pass start and end value (10 - 20)
    // "1, 2, 3, 4, 5, 11, 12, 13, 17, 18, 29, 30, 31"
    @Test
    void shouldAllowOnlyValuesBetweenTheProvidedRange(){
        int startValue = 10;
        int endValue = 20;

        Integer result = stringCalculator.add("1, 2, 3, 4, 5, 11, 12, 13, 17, 18, 29, 30, 31", startValue, endValue);

        assertEquals(71, result);
    }

}