package cop2805;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path inputPath = Paths.get("./.idea/data.txt");
        Path outputPath = Paths.get("data-sorted.txt");
        List<Double> numbers = ReadFile(inputPath.toString());

        if (numbers != null) {
            Collections.sort(numbers);
            WriteFile(numbers, outputPath.toString());
        }
    }

    public static List<Double> ReadFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            List<Double> numbers = new ArrayList<>();

            for (String line : lines) {
                numbers.add(Double.parseDouble(line));
            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void WriteFile(List<Double> numbers, String filePath) {
        List<String> lines = new ArrayList<>();

        for (Double number : numbers) {
            lines.add(number.toString());
        }
        try {
            Files.write(Path.of(filePath), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
