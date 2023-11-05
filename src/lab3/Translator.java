package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> dictionary;

    public Translator(String dictionaryPath) {
        dictionary = new HashMap<>();
        loadDictionary(dictionaryPath);
    }

    private void loadDictionary(String dictionaryPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s*\\|\\s*");
                if (parts.length == 2) {
                    String word = parts[0].toLowerCase();
                    String translation = parts[1];
                    dictionary.put(word, translation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String translate(String inputPath) {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String lowercaseWord = word.toLowerCase();
                    String translation = dictionary.get(lowercaseWord);
                    if (translation != null) {
                        output.append(translation).append(" ");
                    } else {
                        output.append(word).append(" ");
                    }
                }
                output.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
