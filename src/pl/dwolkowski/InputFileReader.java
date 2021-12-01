package pl.dwolkowski;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFileReader {
    private BufferedReader reader;

    public InputFileReader(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
    }

    public List<Integer> loadIntegerList() {
        if (reader == null)
            return new ArrayList<>();
        return reader.lines().map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<String> loadStringList() {
        if (reader == null)
            return new ArrayList<>();
        return reader.lines().collect(Collectors.toList());
    }

}
