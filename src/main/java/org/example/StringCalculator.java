package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public Integer add(String input) {
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

        return extractIntegers(numbers).stream().reduce(0, Integer::sum);
    }

    private List<Integer> extractIntegers(String[] numbers){
        return Arrays.stream(numbers).map(String::trim).filter(str -> !str.isEmpty()).map(Integer::parseInt).toList();
    }
}
