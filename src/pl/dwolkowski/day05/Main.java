package pl.dwolkowski.day05;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day05/input.txt");
        List<String> list = file.loadStringList();

        answer(list, false);
        answer(list, true);

    }

    private static void answer(List<String> list, boolean partTwo) {
        String[] splitLine;
        int startX, startY, finishX, finishY;
        int[][] map = new int[1000][1000];
        int xSign, ySign;

        for (String line : list) {
            splitLine = line.split(" -> ");

            startX = Integer.parseInt(splitLine[0].split(",")[0]);
            startY = Integer.parseInt(splitLine[0].split(",")[1]);
            finishX = Integer.parseInt(splitLine[1].split(",")[0]);
            finishY = Integer.parseInt(splitLine[1].split(",")[1]);

            // Check if line is vertical or horizontal; else its diagonal
            if (startX == finishX || startY == finishY) {
                for (int x = Math.min(startX, finishX); x <= Math.max(startX, finishX); x++)
                    for (int y = Math.min(startY, finishY); y <= Math.max(startY, finishY); y++)
                        map[x][y] += 1;
            } else if (partTwo) {
                xSign = (startX < finishX ? 1 : -1);
                ySign = (startY < finishY ? 1 : -1);
                for (int i = 0; i <= Math.abs(startX - finishX); i++)
                    map[(xSign * i) + startX][(ySign * i) + startY] += 1;
            }
        }

        if (!partTwo)
            System.out.println("Part 1: " + summarize(map));
        else
            System.out.println("Part 2: " + summarize(map));
    }

    private static int summarize(int[][] map) {
        int sum = 0;
        for (int x = 0; x < map.length; x++)
            for (int y = 0; y < map.length; y++)
                if (map[x][y] > 1)
                    sum++;

        return sum;
    }

}
