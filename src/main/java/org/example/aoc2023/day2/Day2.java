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
                    String[] testa = entries.split(" ");
                    System.out.println(Arrays.toString(testa));
                    if(testa[1].equals("blue")){
                        if(Integer.parseInt(testa[0]) > blueCubeLimit){
                            isPossible = false;
                            break;
                        }
                    } else if(testa[1].equals("red")){
                        if(Integer.parseInt(testa[0]) > redCubeLimit){
                            isPossible = false;
                            break;
                        }
                    } else if(testa[1].equals("green")){
                        if(Integer.parseInt(testa[0]) > greenCubeLimit){
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

    public static void main(String[] args){
        List<String> input = new ArrayList<>();
        part1(input);
    }
}
