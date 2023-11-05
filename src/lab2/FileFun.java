package lab2;

import lab2.exceptions.bigArgument;
import lab2.exceptions.fileNotExist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardOpenOption;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileFun {

    public static void cleanFile(File file) throws IOException {
        try (BufferedWriter br = Files.newBufferedWriter(file.toPath(),
                StandardOpenOption.TRUNCATE_EXISTING)) {
        } catch (NoSuchFileException | FileNotFoundException e) {
            throw new fileNotExist("Очищаемый файл не существует или недоступен");
        }
    }
    public static int readN(File file) throws fileNotExist {
        try (Scanner input = new Scanner(file)) {
            if (input.hasNextInt()) {
                int result = input.nextInt();
                if (result <= 1_000_000) {
                    return result;
                } else {
                    throw new bigArgument("Слишком большое число N");
                }
            } else {
                throw new NoSuchElementException("Недопустимые занчения в файле");
            }
        } catch (FileNotFoundException e) {
            throw new fileNotExist("Входной файл не найден");
        }
    }
}
