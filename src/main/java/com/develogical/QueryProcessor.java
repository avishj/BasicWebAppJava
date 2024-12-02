package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("plus")) {
            String[] numbers = input.split(" plus ");
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            return num1 + num2 + "";
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