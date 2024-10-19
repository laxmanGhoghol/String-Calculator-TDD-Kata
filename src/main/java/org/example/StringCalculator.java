package org.example;

public class StringCalculator {

    public Integer add(String string) {
        if(string == null || string.isEmpty()){
            return 0;
        }

        return Integer.valueOf(string);
    }
}
