package pl.dwolkowski.day08;

import pl.dwolkowski.InputFileReader;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day08/input.txt");
        List<String> list = file.loadStringList();

        answerOne(list);
        answerTwo(list);
    }

    private static void answerOne(List<String> list) {
        List<String> values;

        int sum = 0;
        for (String line : list) {
            values = Arrays.stream((line.split(" \\| ")[1]).split(" ")).toList();
            for (String value : values) {
                switch (value.length()) {
                    case 2, 3, 4, 7 -> sum++;
                }
            }
        }
        System.out.println("Part 1: " + sum);
    }

    private static void answerTwo(List<String> list) {

        String[] splitLine;
        List<String> values;
        List<String> templates;

        String zero = "", one = "", two = "", three = "", four = "",
                five = "", six = "", seven = "", eight = "", nine = "";

        Set<Character> numberLetters;
        HashMap<Set<Character>, Integer> dictionary = new HashMap<>();

        List<Integer> results = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (String line : list) {
            splitLine = line.split(" \\| ");
            templates = Arrays.stream(splitLine[0].split("\\s+")).toList();
            values = Arrays.stream(splitLine[1].split("\\s+")).toList();

            // Find one, four, seven, eight
            for (String template : templates) {
                switch (template.length()) {
                    case 2 -> one = template;
                    case 3 -> seven = template;
                    case 4 -> four = template;
                    case 7 -> eight = template;
                }
            }

            // Find six, nine, three
            for (String template : templates) {

                // Possible digits while length=5:{ 2,3,5 }
                if (template.length() == 5) {
                    // If intersection of template and one returns size=2 => its 3
                    numberLetters = one.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                    numberLetters.retainAll(template.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
                    if (numberLetters.size() == 2)
                        three = template;
                }

                // Possible digits while length=6:{ 0,6,9 }
                else if (template.length() == 6) {
                    // If intersection of template and one returns size=1 => its 6
                    numberLetters = one.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                    numberLetters.retainAll(template.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
                    if (numberLetters.size() == 1)
                        six = template;

                    // If intersection of template and four returns size=4 => its 9
                    numberLetters = four.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                    numberLetters.retainAll(template.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
                    if (numberLetters.size() == 4)
                        nine = template;
                }
            }

            // Find five
            for (String template : templates) {
                if (template.length() == 5) {
                    // If intersection of template and six returns size=5 => its 5
                    numberLetters = six.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                    numberLetters.retainAll(template.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
                    if (numberLetters.size() == 5)
                        five = template;
                }
            }

            // Find two, zero
            for (String template : templates) {
                // If length=5 AND its not five and three => its two
                if (template.length() == 5 && !template.equals(five) && !template.equals(three))
                    two = template;

                    // If length=6 AND its not six and nine => its zero
                else if (template.length() == 6 && !template.equals(six) && !template.equals(nine))
                    zero = template;
            }

            dictionary.put(getLetterSet(zero), 0);
            dictionary.put(getLetterSet(one), 1);
            dictionary.put(getLetterSet(two), 2);
            dictionary.put(getLetterSet(three), 3);
            dictionary.put(getLetterSet(four), 4);
            dictionary.put(getLetterSet(five), 5);
            dictionary.put(getLetterSet(six), 6);
            dictionary.put(getLetterSet(seven), 7);
            dictionary.put(getLetterSet(eight), 8);
            dictionary.put(getLetterSet(nine), 9);

            for (String value : values)
                result.append(dictionary.get(getLetterSet(value)));

            results.add(Integer.parseInt(String.valueOf(result)));
            result.delete(0, result.length());
        }

        int sum = results.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Part 2: " + sum);
    }

    private static Set<Character> getLetterSet(String line) {
        return line.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

}
