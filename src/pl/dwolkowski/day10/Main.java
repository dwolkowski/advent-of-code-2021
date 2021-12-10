package pl.dwolkowski.day10;

import pl.dwolkowski.InputFileReader;

import java.util.*;

public class Main {
    static HashMap<Character, Character> brackets = new HashMap<>();

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day10/input.txt");
        List<String> list = file.loadStringList();

        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('<', '>');

        answer(list);

    }

    private static void answer(List<String> list) {
        int partOneResult = 0;
        List<Long> results = new ArrayList<>();

        for (String line : list) {
            List<Character> queue = new ArrayList<>();
            boolean incomplete = true;

            for (char c : line.toCharArray()) {
                // If its left bracket -> Add to queue
                if (brackets.containsKey(c))
                    queue.add(c);
                // If its right bracket
                else {
                    // If its recently opened bracket -> Delete from queue
                    if (c == brackets.get(queue.get(queue.size() - 1)))
                        queue.remove(queue.size() - 1);

                    // Else => its a corrupted line -> Add to sum and go to the next line
                    else {
                        switch (c) {
                            case ')' -> partOneResult += 3;
                            case ']' -> partOneResult += 57;
                            case '}' -> partOneResult += 1197;
                            case '>' -> partOneResult += 25137;
                        }
                        incomplete = false;
                        break;
                    }
                }
            }

            // If line is incomplete
            if (incomplete && queue.size() != 0) {
                long sum = 0;
                Collections.reverse(queue);

                for (char c : queue) {
                    sum *= 5;
                    switch (brackets.get(c)) {
                        case ')' -> sum += 1;
                        case ']' -> sum += 2;
                        case '}' -> sum += 3;
                        case '>' -> sum += 4;
                    }
                }
                results.add(sum);
            }
        }

        results.sort(Comparator.naturalOrder());
        long partTwoResult = results.get((results.size() / 2));


        System.out.println("Part 1: " + partOneResult);
        System.out.println("Part 2: " + partTwoResult);


    }


}
