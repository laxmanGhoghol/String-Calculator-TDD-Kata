package org.example;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public Integer add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        String formattedInput = input;
        if(input.startsWith("//")){
            StringBuilder stringBuilder = new StringBuilder(input);
            int indexOfNewLine = stringBuilder.indexOf("\n");
            delimiter = Pattern.quote(stringBuilder.substring(2, indexOfNewLine));
            stringBuilder.delete(0, indexOfNewLine+1);
            formattedInput = stringBuilder.toString();
        }

        String[] numbers = formattedInput.replace('\n', ',')
                .split(delimiter);

        return Arrays.stream(numbers).map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
