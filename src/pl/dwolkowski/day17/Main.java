package pl.dwolkowski.day17;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int maxX, minX, maxY, minY;

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day17/input.txt");
        String input = file.loadStringList().get(0);
        input = input.replaceAll("[^0-9 .-]", "").strip().replaceAll(" ", "..");
        List<Integer> target = new ArrayList<>(Arrays.stream(input.split("\\..")).map(Integer::parseInt).toList());
        int part1 = 0, part2 = 0;

        minX = target.get(0);
        maxX = target.get(1);
        maxY = target.get(2);
        minY = target.get(3);

        for (int vx = 0; vx <= maxX; vx++) {
            for (int vy = maxY; vy <= Math.abs(maxY); vy++) {
                int highestY = findValue(vx, vy);
                if (highestY != -1) {
                    part1 = Math.max(part1, highestY);
                    part2++;
                }
            }
        }

        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }

    private static int findValue(int vx, int vy) {
        int x = 0, y = 0, highestY = 0;
        boolean inTarget = false;

        while (!inTarget && y >= maxY) {
            x += vx;
            y += vy;
            highestY = Math.max(highestY, y);

            if (vx > 0)
                vx--;
            else if (vx < 0)
                vx++;
            vy--;

            inTarget = x >= minX && x <= maxX && y <= minY && y >= maxY;
        }
        return (inTarget ? highestY : -1);
    }

}