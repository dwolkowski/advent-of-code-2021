package pl.dwolkowski.day06;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day06/input.txt");
        List<String> list = file.loadStringList();

        System.out.print("Part 1: ");
            answer(list, 80);
        System.out.print("Part 2: ");
            answer(list, 256);

    }

    private static void answer(List<String> list, int days) {
        List<Integer> fishes = new ArrayList<>(Arrays.stream(list.get(0).split(",")).map(Integer::parseInt).toList());

        long[] fishTable = new long[9];
        for (int fish : fishes)
            fishTable[fish]++;

        for (int i = 0; i < days; i++) {
            long[] tempTable = new long[9];

            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    tempTable[6] += fishTable[0];
                    tempTable[8] += fishTable[0];
                } else {
                    tempTable[j - 1] += fishTable[j];
                }
            }
            fishTable = tempTable;
        }

        System.out.println(Arrays.stream(fishTable).sum());
    }

}
