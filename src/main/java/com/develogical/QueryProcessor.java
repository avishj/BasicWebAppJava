package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    private static int[] extractNumbers(String text) {
        String[] numbers = text.replaceAll("[^0-9]+", " ").trim().split(" ");
        
        if (numbers[0].isEmpty()) {
            return new int[0];
        }
        
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    public String process(String query) {

        if (query.toLowerCase().contains("plus")) {
            int[] numbers = extractNumbers(query);
            return Arrays.stream(numbers).sum() + "";
        }

        if (query.toLowerCase().contains("largest")) {
            int[] numbers = extractNumbers(query);
            return Arrays.stream(numbers).max().getAsInt() + "";
        }

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.contains("your name")) {
            return "Avish, Anila, Ramya, Prahanya";
        }

        return "";
    }

}