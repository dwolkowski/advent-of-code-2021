package pl.dwolkowski.day13;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // map with dots
    static String[][] map;
    // fold lines
    static List<String> folds = new ArrayList<>();

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day13/input.txt");
        List<String> list = file.loadStringList();

        String[] splitLine;
        int xMax = 0, yMax = 0;
        int x, y;

        // Search for the highest indexes
        for (String line : list) {
            if (line.equals("")) break;

            splitLine = line.split(",");
            x = Integer.parseInt(splitLine[0]);
            y = Integer.parseInt(splitLine[1]);

            if (x > xMax)
                xMax = x;

            if (y > yMax)
                yMax = y;
        }

        map = new String[yMax + 1][xMax + 1];

        for (String line : list) {
            if(line.equals("")) continue;

            if (line.startsWith("fold")) {
                folds.add(line);
            } else {
                splitLine = line.split(",");
                x = Integer.parseInt(splitLine[0]);
                y = Integer.parseInt(splitLine[1]);
                map[y][x] = "#";
            }
        }

        answer();

    }

    private static void answer() {

        for (String line : folds) {
            String[] fold = line.replace("fold along", "").split("=");

            if (fold[0].strip().equalsIgnoreCase("x")) {
                int xFold = Integer.parseInt(fold[1]);
                for (int i = 0; i < map.length; i++) {
                    for (int j = xFold; j < map[0].length; j++) {
                        if (map[i][j] != null) {
                            map[i][xFold - (j - xFold)] = "#";
                            map[i][j] = null;
                        }
                    }
                }
            } else if (fold[0].strip().equalsIgnoreCase("y")) {
                int yFold = Integer.parseInt(fold[1]);
                for (int i = yFold; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j] != null) {
                            map[yFold - (i - yFold)][j] = "#";
                            map[i][j] = null;
                        }
                    }
                }
            }

            if (line.equals(folds.get(0)))
                System.out.println("Part 1: " + sum());
        }

        System.out.print("Part 2: ");
        mapToString();
    }

    // Sum of dots for part 1
    private static int sum() {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != null)
                    sum++;
            }
        }

        return sum;
    }

    // Printing key word
    private static void mapToString() {
        int xMax = 0, yMax = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != null) {
                    xMax = j;
                    yMax = i;
                }
            }
        }

        for (int i = 0; i <= yMax; i++) {
            System.out.println();
            for (int j = 0; j <= xMax; j++) {
                if (map[i][j] != null)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
        }
    }

}

