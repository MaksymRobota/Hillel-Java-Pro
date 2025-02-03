package app.parser_h11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class BookTextParser {
    public void run() {
        UserInputHandler inputHandler = new UserInputHandler();
        String bookName = inputHandler.getBookNameFromUser();

        if (!bookName.replaceAll("\\s", "").matches("^[a-zA-Z0-9._-]+$")) {
            System.err.println("Invalid book name. Please use only alphanumeric characters, dots, underscores, or hyphens.");
            return;
        }

        Path bookPath = Paths.get("src/app/parser_h11/resources/" + bookName);
        if (!Files.exists(bookPath)) {
            System.out.println("The book " + bookName + " does not exist in the src/app/parser_h11/resources directory.");
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(bookPath.toFile())) {
            String content = new String(fileInputStream.readAllBytes());

            TextAnalyzer analyzer = new TextAnalyzer();
            Map<String, Integer> wordFrequency = analyzer.analyzeText(content);

            List<Map.Entry<String, Integer>> topWords = analyzer.getTopWords(wordFrequency, 10);
            long uniqueWordCount = analyzer.countUniqueWords(wordFrequency);

            StatisticsHandler statisticsHandler = new StatisticsHandler();
            statisticsHandler.displayStatistics(topWords, uniqueWordCount);
            statisticsHandler.saveStatisticsToFile(bookName, topWords, uniqueWordCount);

        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file. Please check if the file is accessible and not corrupted.");
            System.err.println("Error details: " + e.getMessage());
        }
    }
}
