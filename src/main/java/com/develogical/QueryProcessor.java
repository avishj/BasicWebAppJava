package com.develogical;

import java.util.*;
import java.util.stream.*;

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

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    
    private static boolean isPerfectCube(int num) {
        int cbrt = (int) Math.cbrt(num);
        return cbrt * cbrt * cbrt == num;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public String process(String query) {

        if (query.toLowerCase().contains("primes")) {
            int[] numbers = extractNumbers(query);
            return Arrays.stream(numbers)
                 .filter(n -> isPrime(n))
                 .mapToObj(String::valueOf)
                 .collect(Collectors.joining(", "));

        }

        if (query.toLowerCase().contains("minus")) {
            int[] numbers = extractNumbers(query);
            System.out.println(query);
            System.out.println((numbers[0] - numbers[1]) + "");
            return (numbers[0] - numbers[1]) + "";
        }

        if (query.toLowerCase().contains("multiplied")) {
            int[] numbers = extractNumbers(query);
            int mult = 1;
            for (int num: numbers) {
                mult *= num;
            }
            return mult + "";
        }

        if (query.toLowerCase().contains("cube") && query.toLowerCase().contains("square")) {
            int[] numbers = extractNumbers(query);
            for (int num : numbers) {
                if (isPerfectSquare(num) && isPerfectCube(num)) {
                    return num + "";
                }
            }
            return -1 + "";
        }

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