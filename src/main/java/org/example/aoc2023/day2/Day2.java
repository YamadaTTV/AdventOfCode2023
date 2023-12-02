package org.example.aoc2023.day2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day2 {


    public static void part1(List<String> input){
        int redCubeLimit = 12;
        int greenCubeLimit = 13;
        int blueCubeLimit = 14;
        int res = 0;
        input = Collections.emptyList();
        try {
            input = Files.readAllLines(Paths.get("src/main/resources/input2.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < input.size(); i++){
            String list = input.get(i);
            String[] split = list.split(":");
            String idNumber = split[0].replace("Game", "").trim();
            String[] game = split[1].trim().split(";");
            boolean isPossible = true;
            for(int j = 0; j < game.length; j++){
                String test = game[j].trim();
                String[] cubes = test.split(", ");
                for(int k = 0; k < cubes.length; k++){
                    String entries = cubes[k];
                    String[] numbersAndColors = entries.split(" ");
                    if(numbersAndColors[1].equals("blue")){
                        if(Integer.parseInt(numbersAndColors[0]) > blueCubeLimit){
                            isPossible = false;
                            break;
                        }
                    } else if(numbersAndColors[1].equals("red")){
                        if(Integer.parseInt(numbersAndColors[0]) > redCubeLimit){
                            isPossible = false;
                            break;
                        }
                    } else if(numbersAndColors[1].equals("green")){
                        if(Integer.parseInt(numbersAndColors[0]) > greenCubeLimit){
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            if(isPossible){
                res += Integer.parseInt(idNumber);
            }
        }
        System.out.println(res);
    }

    private static void part2(List<String> input){
        int res = 0;
        int power = 0;
        input = Collections.emptyList();
        try {
            input = Files.readAllLines(Paths.get("src/main/resources/input2.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < input.size(); i++){
            int currentBlue = 0;
            int currentRed = 0;
            int currentGreen = 0;
            String list = input.get(i);
            String[] split = list.split(":");
            String[] game = split[1].trim().split(";");
            for(int j = 0; j < game.length; j++){
                String test = game[j].trim();
                String[] cubes = test.split(", ");
                for(int k = 0; k < cubes.length; k++){
                    String entries = cubes[k];
                    String[] numbersAndColors = entries.split(" ");
                    if(numbersAndColors[1].equals("blue")){
                        if(Integer.parseInt(numbersAndColors[0]) >= currentBlue){
                            currentBlue = Integer.parseInt(numbersAndColors[0]);
                        }
                    } else if(numbersAndColors[1].equals("green")){
                        if(Integer.parseInt(numbersAndColors[0]) >= currentGreen){
                            currentGreen = Integer.parseInt(numbersAndColors[0]);
                        }
                    } else if(numbersAndColors[1].equals("red")){
                        if(Integer.parseInt(numbersAndColors[0]) >= currentRed){
                            currentRed = Integer.parseInt(numbersAndColors[0]);
                        }
                    }
                }
            }
            power = currentRed * currentGreen * currentBlue;
            res += power;
        }
        System.out.println(res);
    }

    public static void main(String[] args){
        List<String> input = new ArrayList<>();
        part1(input);
        part2(input);
    }
}
