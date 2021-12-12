package pl.dwolkowski.day12;

import pl.dwolkowski.InputFileReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    // map (Point , Adjacent Points)
    static HashMap<String, Set<String>> map = new HashMap<>();
    // visited (Point, Number of visits)
    static HashMap<String, Integer> visited = new HashMap<>();

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day12/input.txt");
        List<String> list = file.loadStringList();

        String[] splitLine;
        for (String line : list) {
            splitLine = line.split("-");

            if (!map.containsKey(splitLine[0]))
                map.put(splitLine[0], new HashSet<>());

            if (!map.containsKey(splitLine[1]))
                map.put(splitLine[1], new HashSet<>());

            map.get(splitLine[0]).add(splitLine[1]);
            map.get(splitLine[1]).add(splitLine[0]);
        }

        map.keySet().forEach( k -> visited.put(k,0));
        visited.put("start", 2);

        System.out.println("Part 1: " + findPath("start", false));
        System.out.println("Part 2: " + findPath("start", true));

    }

    private static int findPath(String point, boolean partTwo) {
        int sum = 0;
        if (point.equals("end"))
            return 1;

        int limit = partTwo ? 2 : 1;

        for (String nextPoint : map.get(point)) {
            if (visited.get(nextPoint) + 1 <= (nextPoint.toLowerCase().equals(nextPoint) ? limit : Integer.MAX_VALUE)) {
                visited.put(nextPoint, visited.get(nextPoint) + 1);

                if(nextPoint.toLowerCase().equals(nextPoint) && visited.get(nextPoint) == 2)
                    sum += findPath(nextPoint, false);
                else
                    sum += findPath(nextPoint, partTwo);

                visited.put(nextPoint, visited.get(nextPoint) - 1);
            }
        }
        return sum;
    }
}