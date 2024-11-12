import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path filePath = fileChooser.getSelectedFile().toPath();
            System.out.println("File chosen: " + filePath);

            try {
                List<String> lines = Files.readAllLines(filePath);
                int lineCount = lines.size();
                int wordCount = 0;
                int charCount = 0;

                for (String line : lines) {
                    System.out.println(line);
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                // Summary report
                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + filePath.getFileName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
