package org.example;

public class StringCalculator {

    public Integer add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(",");
        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            sum += parsedNumber;
        }
        return sum;
    }
}
