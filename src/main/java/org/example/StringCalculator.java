package org.example;

public class StringCalculator {

    public Integer add(String string) {
        if(string.isEmpty()){
            return 0;
        }

        return Integer.valueOf(string);
    }
}
