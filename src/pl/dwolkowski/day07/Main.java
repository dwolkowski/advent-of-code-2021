package pl.dwolkowski.day07;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day07/input.txt");
        List<String> list = file.loadStringList();

        System.out.print("Part 1: ");
            answer(list, false);
        System.out.print("Part 2: ");
            answer(list, true);

    }

    private static void answer(List<String> list, boolean partTwo) {
        List<Integer> positions = new ArrayList<>(Arrays.stream(list.get(0).split(",")).map(Integer::parseInt).toList());
        int maxPosition = positions.stream().mapToInt(Integer::intValue).max().getAsInt();

        // For first iteration bestFuelUsage amount must be as high as possible.
        int bestFuelUsage = Integer.MAX_VALUE;
        int currentFuelUsage;
        int distance;

        for (int position = 0; position < maxPosition; position++) {
            currentFuelUsage = 0;

            for (int crabPosition : positions) {
                distance = Math.abs(crabPosition - position);
                if (partTwo)
                    // For Part 2 fuelUsage we need: Sum of an arithmetic sequence 1+2+3+4+...+distance
                    currentFuelUsage += ((distance+1) / 2.0 * distance);
                else
                    currentFuelUsage += distance;
            }

            if (currentFuelUsage < bestFuelUsage)
                bestFuelUsage = currentFuelUsage;
        }

        System.out.println(bestFuelUsage);
    }
}
