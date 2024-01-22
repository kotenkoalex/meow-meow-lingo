package com.meow.lingo.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReaderTestData {
    private static List<String> lines;
    public static List<String> readData() {
        if (lines == null) {
            lines = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/main/resources/testdata.txt"))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lines;
    }
}
