package pl.dwolkowski.day3;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day3/input.txt");
        List<String> list = file.loadStringList();

        answerOne(list);
        answerTwo(list);

    }

    // Part 1
    private static void answerOne(List<String> list){
        int[] bitArray = new int[ list.get(0).length() ];

        for (String line : list){
            for(int i=0; i < line.length(); i++)
                if(line.charAt(i) == '0')
                    bitArray[i]--;
                else
                    bitArray[i]++;
        }

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for(int value : bitArray){
            if(value < 0){
                gamma.append("0");
                epsilon.append("1");
            } else{
                gamma.append("1");
                epsilon.append("0");
            }
        }

        int gammaValue = Integer.parseInt(gamma.toString(), 2);
        int epsilonValue = Integer.parseInt(epsilon.toString(), 2);

        System.out.println("Part 1: " + (gammaValue * epsilonValue));
    }


    // Part 2
    private static void answerTwo(List<String> list){

        int oxygen = findValue(list, true);
        int co2 = findValue(list, false);

        System.out.println("Part 2: " + (oxygen * co2));
    }

    /**
     * @param mostCommon
     *    true - chooses the most common value, if equally common keep values with a 1
     *    false - chooses the least common value, if equally common keep values with a 0
    */
    private static int findValue(List<String> list, boolean mostCommon){
        List<String> resource = new ArrayList<>(list);
        int value;
        String pattern = "";

        for(int i=0; i < resource.get(0).length(); i++){
            value = 0;
            if(resource.size() != 1){
                for(String line : resource){
                    if(line.charAt(i) == '0')
                        value--;
                    else
                        value++;
                }

                if(value == 0)
                    pattern += mostCommon ? "1" : "0";
                else if (value > 0)
                    pattern += mostCommon ? "1" : "0";
                else
                    pattern += mostCommon ? "0" : "1";

                String finalPattern = pattern;
                resource.removeIf(s -> !(s.startsWith(finalPattern)));
            }
            else break;
        }

        return Integer.parseInt(resource.get(0), 2);
    }


}


