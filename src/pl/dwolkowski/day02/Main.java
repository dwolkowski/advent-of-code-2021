package pl.dwolkowski.day02;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args){
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day02/input.txt");
        List<String> list = file.loadStringList();

        answerOne(list);
        answerTwo(list);

    }

    // Part 1
    private static void answerOne(List<String> list){
        String[] splitLine;
        int depth = 0;
        int horizontal = 0;

        int value;
        for(String line : list){
            splitLine = line.split(" ");
            value = Integer.parseInt(splitLine[1]);

            switch (splitLine[0]){
                case "up" -> depth -= value;
                case "down" -> depth += value;
                case "forward" -> horizontal += value;
            }
        }

        System.out.println("Part 1: " + (depth * horizontal));
    }

    // Part 2
    private static void answerTwo(List<String> list){
        String[] splitLine;
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        int value;
        for(String line : list){
            splitLine = line.split(" ");
            value = Integer.parseInt(splitLine[1]);

            switch (splitLine[0]){
                case "up" -> aim -= value;
                case "down" -> aim += value;
                case "forward" -> {
                    horizontal += value;
                    depth += (value * aim);
                }
            }
        }

        System.out.println("Part 2: " + (depth * horizontal));
    }

}


