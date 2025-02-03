package app.parser_h11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class StatisticsHandler {
    public void displayStatistics(List<Map.Entry<String, Integer>> topWords, long uniqueWordCount) {
        System.out.println("Analysis Statistics:");
        for (Map.Entry<String, Integer> entry : topWords) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Total unique words: " + uniqueWordCount);
    }

    public void saveStatisticsToFile(String bookName, List<Map.Entry<String, Integer>> topWords, long uniqueWordCount) {
        Path outputFilePath = Paths.get("src/app/parser_h11/statistic_out", bookName.replaceAll("\\..*", "") + "_statistic.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath.toFile()))) {
            for (Map.Entry<String, Integer> entry : topWords) {
                writer.write(entry.getKey() + " -> " + entry.getValue());
                writer.newLine();
            }
            writer.write("Total unique words: " + uniqueWordCount);
            System.out.println("Statistics saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the statistics. Please check write permissions and available disk space.");
            System.err.println("Error details: " + e.getMessage());
        }
    }
}
