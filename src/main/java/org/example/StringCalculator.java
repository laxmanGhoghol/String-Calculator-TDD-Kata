package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public Integer add(String input, Integer startValue, Integer endValue) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        String formattedInput = input;
        if(input.startsWith("//")){
            int indexOfNewLine = input.indexOf("\n");
            delimiter = Pattern.quote(input.substring(2, indexOfNewLine));
            formattedInput = input.substring(indexOfNewLine+1);
        }

        String[] numbers = formattedInput.replace('\n', ',')
                .split(delimiter);

        List<Integer> negativeNumbers = extractIntegers(numbers).stream().filter(num -> num < 0).toList();

        if(!negativeNumbers.isEmpty()){
            throw new NegativeNumberException("negative numbers not allowed " + negativeNumbers);
        }

        if(delimiter.equals(Pattern.quote("*"))){
            return extractIntegers(numbers).stream().reduce(1, (a, b) -> a * b);
        }

        if(startValue != null && endValue != null){
            return extractIntegers(numbers).stream().filter((num) -> (num < endValue && num > startValue)).reduce(0, Integer::sum);
        }

        return extractIntegers(numbers).stream().reduce(0, Integer::sum);
    }

    private List<Integer> extractIntegers(String[] numbers){
        return Arrays.stream(numbers).map(String::trim).filter(str -> !str.isEmpty()).map(Integer::parseInt).toList();
    }

}
