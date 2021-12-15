package pl.dwolkowski.day15;

import pl.dwolkowski.InputFileReader;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day15/input.txt");
        List<String> list = file.loadStringList();

        int[][] mapPartOne = new int[list.size()][list.get(0).length()];
        int[][] mapPartTwo = new int[list.size() * 5][list.get(0).length() * 5];


        for(int i=0; i < list.size(); i++){
            for(int j=0; j < list.get(0).length(); j++){
                // Part One Array
                mapPartOne[i][j] = Character.getNumericValue(list.get(i).charAt(j));

                // Part Two Array
                for(int k=0; k<5; k++){
                    for(int l=0; l<5; l++){
                        int newValue = Character.getNumericValue(list.get(i).charAt(j)) + k + l;
                        if(newValue >= 10)
                            newValue -= 9;

                        mapPartTwo[i+list.size() * k][j+list.get(0).length()*l] = newValue;
                    }
                }

            }
        }

        System.out.println("Part 1: " + answer(mapPartOne));
        System.out.println("Part 2: " + answer(mapPartTwo));
    }

    private static int answer(int[][] map) {
        // 0 - Right, 1 - Left, 2 - Top, 3 - Bot
        int[] xAxis = {1, -1, 0, 0};
        int[] yAxis = {0, 0, 1, -1};

        int[][] visited = new int[map.length][map[0].length];
        for(int i=0; i < map.length; i++)
            for(int j=0; j < map[0].length; j++)
                visited[i][j] = Integer.MAX_VALUE;

        Queue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0,0,0));

        while(!queue.isEmpty()){
            Point node = queue.poll();

            if(node.getX() == map.length-1 && node.getY() == map[0].length-1)
                return node.getCost();

            for(int i=0; i<4; i++) {
                int tempX = node.getX() + xAxis[i];
                int tempY = node.getY() + yAxis[i];

                if (tempX >= 0 && tempX < map[0].length && tempY >= 0 && tempY < map.length) {
                    int newCost = node.getCost() + map[tempY][tempX];
                    if (visited[tempY][tempX] > newCost) {
                        visited[tempY][tempX] = newCost;
                        queue.add(new Point(tempX, tempY, newCost));
                    }
                }
            }

        }

        return 0;
    }
}

record Point(int x, int y, int risk) implements Comparable<Point> {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return risk;
    }

    @Override
    public int compareTo(Point o) {
        return this.risk > o.risk ? 1 : -1;
    }
}

