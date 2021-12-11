package pl.dwolkowski.day11;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {
    static int[][] map = new int[10][10];
    static boolean[][] flashed;

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day11/input.txt");
        List<String> list = file.loadStringList();

        for (int i = 0; i < 10; i++) {
            String line = list.get(i);
            for (int j = 0; j < 10; j++)
                map[i][j] = Character.getNumericValue(line.charAt(j));
        }

        answer();

    }

    private static void answer() {
        int sum = 0;
        int step = 0;
        int size = 10;

        boolean found = false;
        boolean allFlashes;
        int allFlashesStep = 0;

        while (!found) {
            step++;

            flashed = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j]++;
                    if (map[i][j] >= 10)
                        flash(i, j);
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (flashed[i][j]) {
                        map[i][j] = 0;
                        if (step <= 100)
                            sum++;
                    }
                }
            }

            allFlashes = true;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!flashed[i][j]) {
                        allFlashes = false;
                        break;
                    }
                }
            }

            if (allFlashes) {
                allFlashesStep = step;
                found = true;
            }
        }

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + allFlashesStep);

    }

    private static void flash(int i, int j) {
        flashed[i][j] = true;
        map[i][j] = 0;

        // TOP
        if (i - 1 >= 0) {

            // TOP
            map[i - 1][j]++;
            if (map[i - 1][j] >= 10 && !flashed[i - 1][j])
                flash(i - 1, j);

            // LEFT
            if (j - 1 >= 0) {
                map[i - 1][j - 1]++;
                if (map[i - 1][j - 1] >= 10 && !flashed[i - 1][j - 1])
                    flash(i - 1, j - 1);
            }

            // RIGHT
            if (j + 1 < 10) {
                map[i - 1][j + 1]++;
                if (map[i - 1][j + 1] >= 10 && !flashed[i - 1][j + 1])
                    flash(i - 1, j + 1);
            }
        }

        // BOT
        if (i + 1 < 10) {
            // BOT
            map[i + 1][j]++;
            if (map[i + 1][j] >= 10 && !flashed[i + 1][j])
                flash(i + 1, j);

            // LEFT
            if (j - 1 >= 0) {
                map[i + 1][j - 1]++;
                if (map[i + 1][j - 1] >= 10 && !flashed[i + 1][j - 1])
                    flash(i + 1, j - 1);
            }

            // RIGHT
            if (j + 1 < 10) {
                map[i + 1][j + 1]++;
                if (map[i + 1][j + 1] >= 10 && !flashed[i + 1][j + 1])
                    flash(i + 1, j + 1);
            }
        }

        // LEFT
        if (j - 1 >= 0) {
            map[i][j - 1]++;
            if (map[i][j - 1] >= 10 && !flashed[i][j - 1])
                flash(i, j - 1);
        }

        // RIGHT
        if (j + 1 < 10) {
            map[i][j + 1]++;
            if (map[i][j + 1] >= 10 && !flashed[i][j + 1])
                flash(i, j + 1);
        }

    }


}
