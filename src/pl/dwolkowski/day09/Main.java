package pl.dwolkowski.day09;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static List<List<Integer>> map = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day09/input.txt");

        for (String line : file.loadStringList()) {
            List<Integer> mapRow = new ArrayList<>();
            for (char c : line.toCharArray()) {
                mapRow.add(Character.getNumericValue(c));
            }
            map.add(mapRow);
        }

        visited = new boolean[map.size()][map.get(0).size()];

        answer(false);
        answer(true);

    }

    private static void answer(boolean partTwo) {
        List<Integer> results = new ArrayList<>();
        boolean top, bot, left, right;
        int sum = 0;

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(0).size(); j++) {
                top = (i == 0 || map.get(i).get(j) < map.get(i - 1).get(j));
                bot = (i == map.size() - 1 || map.get(i).get(j) < map.get(i + 1).get(j));
                left = (j == 0 || map.get(i).get(j) < map.get(i).get(j - 1));
                right = (j == map.get(0).size() - 1 || map.get(i).get(j) < map.get(i).get(j + 1));

                if (top && bot && left && right){
                    if(partTwo)
                        results.add(countBasin(i,j));
                    else
                        sum += map.get(i).get(j) + 1;
                }
            }
        }

        if(partTwo){
            results.sort(Comparator.reverseOrder());
            System.out.println("Part 2: " + (results.get(0) * results.get(1) * results.get(2)));
        } else
            System.out.println("Part 1: " + sum);

    }

    private static int countBasin(int i, int j){
        int sum = 1;
        visited[i][j] = true;

        // Top
        if( i-1>=0 && map.get(i-1).get(j) != 9 && !visited[i - 1][j])
            sum+=countBasin(i-1, j);

        // Bot
        if(i+1<map.size() - 1 && map.get(i+1).get(j) != 9 && !visited[i + 1][j])
            sum+=countBasin(i+1, j);

        // Left
        if(j-1>=0 && map.get(i).get(j-1) != 9 && !visited[i][j-1])
            sum+=countBasin(i, j-1);


        // Right
        if(j+1<map.get(0).size() - 1 && map.get(i).get(j+1) !=9 && !visited[i][j+1])
            sum+=countBasin(i,j+1);

        return sum;
    }

}
