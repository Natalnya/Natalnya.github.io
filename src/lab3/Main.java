package lab3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
        public static void main(String[] args) {
                String dictionaryPath = "C:\\Users\\Natalnya\\IdeaProjects\\labs\\src\\lab3\\dictionary.txt";
                String inputPath = "C:\\Users\\Natalnya\\IdeaProjects\\labs\\src\\lab3\\test";
                Translator translator = new Translator(dictionaryPath);
                String translation = translator.translate(inputPath);
                System.out.println(translation);
        }
}
