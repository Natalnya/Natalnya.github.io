package lab2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Main {
    public static void main(String[] args) {

        int n = 0;
        File file = new File("C:\\Users\\Natalnya\\IdeaProjects\\labs\\src\\lab2\\file.txt");
        File output = new File("C:\\Users\\Natalnya\\IdeaProjects\\labs\\src\\lab2\\output");
        try {
            FileFun.cleanFile(output);
            n = FileFun.readN(file);
            Matrix matrix = new Matrix(n);
            matrix.printMatrix(output);
            for (int i = 0; i < 3; i++) {
                matrix.rotateMatrix();
                matrix.printMatrix(output);
                matrix.divideMatrix();
                matrix.printMatrix(output);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
        }

    }
}
