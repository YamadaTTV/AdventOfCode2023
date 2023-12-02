package org.example.aoc2023.day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day1 {

    private static void part1(List<String> input){
        String digits;
        Character first = null;
        Character last = null;
        int total = 0;
        int calibrationValue = 0;
        input = Collections.emptyList();
        try {
            input = Files.readAllLines(Paths.get("src/main/resources/input1.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(String s: input){
            first = null;
            last = null;
            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i))){
                    if(first == null){
                        first = s.charAt(i);
                    }
                    last = s.charAt(i);
                }

            }
            calibrationValue = Integer.parseInt(first.toString() + last.toString());
            total += calibrationValue;
        }
        System.out.println(total);
    }

    private static void part2(List<String> input){
        input = Collections.emptyList();
        int total = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        try {
            input = Files.readAllLines(Paths.get("src/main/resources/input1.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(String s: input){
            TreeMap<Integer, Integer> numbersFound = new TreeMap<>();
            for(String number: map.keySet()){
                int first = s.indexOf(number);
                int last = s.lastIndexOf(number);
                //int last = s.lastIndexOf(number, first)
                if(first != -1){
                    numbersFound.put(first, map.get(number));
                }
                if(last != -1 && last != first){
                    numbersFound.put(last, map.get(number));
                }
            }
            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i))){
                    numbersFound.put(i, Character.getNumericValue(s.charAt(i)));
                }
            }
            Integer firstNumber = numbersFound.firstEntry().getValue();
            Integer lastNumber = numbersFound.lastEntry().getValue();
            String res = "" + firstNumber + lastNumber;
            total += Integer.parseInt(res);
        }
        System.out.println(total);
    }

    public static void main(String[] args){
        List<String> input = new ArrayList<>();
        //part1(input);
        // Answer is too high (54608)
        part2(input);
    }
}
