package org.example;

import java.util.Arrays;

public class StringCalculator {

    public Integer add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.replace('\n', ',')
                .split(",");
        return Arrays.stream(numbers).map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
