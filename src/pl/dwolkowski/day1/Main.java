package pl.dwolkowski.day1;

import pl.dwolkowski.InputFileReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day1/input.txt");
        List<Integer> list = file.loadIntegerList();

        answerOne(list);
        answerTwo(list);

    }

    // Part 1
    private static void answerOne(List<Integer> list){
        int result = 0;
        for(int i=1; i<list.size(); i++){
            if(list.get(i) > list.get(i-1))
                result++;
        }

        System.out.println("Part 1: " + result);
    }

    // Part 2
    private static void answerTwo(List<Integer> list){
        int result = 0;
        int sumGroupA, sumGroupB;

        for(int i=0; i<list.size()-3; i++){
            sumGroupA = list.get(i) + list.get(i+1) + list.get(i+2);
            sumGroupB = list.get(i+1) + list.get(i+2) + list.get(i+3);

            if(sumGroupB > sumGroupA)
                result++;
        }

        System.out.println("Part 2: " + result);
    }
}
