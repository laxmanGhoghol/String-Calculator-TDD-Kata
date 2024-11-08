package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public Integer add(String input, Integer startValue, Integer endValue) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = extractDelimiter(input);
        List<Integer> integers = parseInput(input, delimiter);
        validateNegativeNumbers(integers);

        if(delimiter.equals(Pattern.quote("*"))){
            return integers.stream().reduce(1, (a, b) -> a * b);
        }

        if(startValue != null && endValue != null){
            return integers.stream().filter((num) -> (num < endValue && num > startValue)).reduce(0, Integer::sum);
        }

        return integers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> parseInput(String input, String delimiter){
        String formattedInput = input;
        if(!delimiter.equals(",")){
            int indexOfNewLine = input.indexOf("\n");
            formattedInput = input.substring(indexOfNewLine+1);
        }

        String[] numbers = formattedInput.replace('\n', ',')
                .split(delimiter);

        return extractIntegers(numbers);
    }

    private String extractDelimiter(String input){
        String delimiter = ",";
        if(input.startsWith("//")) {
            int indexOfNewLine = input.indexOf("\n");
            return Pattern.quote(input.substring(2, indexOfNewLine));
        }
        return  delimiter;
    }

    private void validateNegativeNumbers(List<Integer> integers) {
        List<Integer> negativeNumbers = integers.stream().filter(num -> num < 0).toList();

        if(!negativeNumbers.isEmpty()){
            throw new NegativeNumberException("negative numbers not allowed " + negativeNumbers);
        }
    }

    private List<Integer> extractIntegers(String[] numbers){
        return Arrays.stream(numbers).map(String::trim).filter(str -> !str.isEmpty()).map(Integer::parseInt).toList();
    }

}
