package pl.dwolkowski.day14;

import pl.dwolkowski.InputFileReader;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day14/input.txt");
        List<String> list = file.loadStringList();

        String template = list.get(0);
        list.remove(0);
        list.remove(0);

        Map<String, String> dictionary = new HashMap<>();
        String[] splitLine;

        for (String line : list) {
            splitLine = line.split(" -> ");
            dictionary.put(splitLine[0], splitLine[1]);
        }

        System.out.println("Part 1: " + answer(template, dictionary, 10));
        System.out.println("Part 2: " + answer(template, dictionary, 40));
    }

    private static long answer(String template, Map<String, String> dictionary, int steps) {

        Map<String, Long> pairs = new HashMap<>();
        for(int i=0; i<template.length()-1; i++){
            String pair = template.substring(i,i+2);
            pairs.putIfAbsent(pair, 0L);
            pairs.put(pair, pairs.get(pair)+1);
        }

        Map<Character, Long> letters = new HashMap<>();
        for (Character c : template.toCharArray()) {
            letters.putIfAbsent(c, 0L);
            letters.put(c, letters.get(c) + 1);
        }

        for (int step = 0; step < steps; step++) {
            Map<String, Long> newPairs = new HashMap<>();
            for(String pair : pairs.keySet()){

                String left = pair.charAt(0) + dictionary.get(pair);
                String right = dictionary.get(pair) + pair.charAt(1);

                newPairs.putIfAbsent(left ,0L);
                newPairs.putIfAbsent(right ,0L);
                newPairs.put(left, newPairs.get(left) + pairs.get(pair));
                newPairs.put(right, newPairs.get(right) + pairs.get(pair));

                letters.putIfAbsent(dictionary.get(pair).charAt(0), 0L);
                letters.put(dictionary.get(pair).charAt(0), letters.get(dictionary.get(pair).charAt(0)) + pairs.get(pair));

            }
            pairs = newPairs;
        }

        long min = Collections.min(letters.values());
        long max = Collections.max(letters.values());

        return (max - min);
    }

}