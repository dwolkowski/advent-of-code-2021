package pl.dwolkowski.day4;

import pl.dwolkowski.InputFileReader;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day4/input.txt");
        List<String> list = file.loadStringList();

        answerOne(list);
        answerTwo(list);

    }

    // Part 1
    private static void answerOne(List<String> list) {
        List<Integer> numbersQueue = Arrays.stream(list.get(0).split(",")).map(Integer::parseInt).toList();
        Set<Integer> numbers = new HashSet<>();

        list.remove(0);
        list.removeIf(s -> s.equals(""));

        Map<Integer, List<Integer>> bingoBoard = new HashMap<>();
        List<Integer> setLista = new ArrayList<>();

        int sum = 0;
        int[] row;

        for (int currentNumber : numbersQueue) {
            numbers.add(currentNumber);

            for (int i = 0; i < list.size(); i += 5) {
                for (int j = 0; j < 5; j++) {

                    // Add rows to bingo board
                    row = Arrays.stream(list.get(i + j).trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                    bingoBoard.put(j, Arrays.stream(row).boxed().collect(Collectors.toList()));

                    // Add columns to bingo board
                    for (int k = 5; k < 10; k++) {

                        if (bingoBoard.containsKey(k))
                            setLista = bingoBoard.get(k);
                        else
                            setLista = new ArrayList<>();

                        setLista.add(row[k - 5]);

                        bingoBoard.put(k, setLista);

                    }
                }

                if (isWin( bingoBoard, numbers)) {
                    List<Integer> values;
                    for (int x = 0; x < 5; x++) {
                        values = bingoBoard.get(x);
                        for (int value : values)
                            if (!numbers.contains(value))
                                sum += value;
                    }

                    System.out.println("Part 1: " + sum * currentNumber);
                    return;
                }

                setLista.clear();
                bingoBoard.clear();
            }
        }
    }

    // Check if any row/col wins
    private static boolean isWin(Map<Integer,List<Integer>> bingoBoard, Set<Integer> numbers){
        for (List<Integer> values : bingoBoard.values()) {
            if (numbers.containsAll(values))
                return true;
        }
        return false;
    }


    // Part 2
    private static void answerTwo(List<String> list) {

        System.out.println("Part 2: ");
    }
}