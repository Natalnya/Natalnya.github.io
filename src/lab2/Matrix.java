package lab2;

import lab2.exceptions.divisionByNull;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.Math.floor;

public class Matrix {
    private double[][] arr;

    public static Logger logger;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Natalnya\\IdeaProjects\\labs\\src\\lab2\\log.config")) {
            LogManager.getLogManager().readConfiguration(fileInputStream);
            logger = Logger.getLogger(Matrix.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Создаёт и заполняет матрицу случайными числами от -N до N
    public Matrix(int n) {
        Random rand = new Random();
        arr = new double[n][n];
        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++) {
                arr[i][j] = -n + (int)(Math.random()*((n+n)+1));
            }
        }
    }

    //Запись матрицы в файл
    public void printMatrix(File fileName) throws IOException {
        int n = arr.length;
        FileWriter writer = new FileWriter(fileName, true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] =  floor(arr[i][j] * 100)/100;
                writer.write(String.valueOf(arr[i][j]) + ' ');
            }
            writer.write('\n');
        }
        writer.write("\n-------------\n");
        writer.close();
    }

    //Поворачивает матрицу на 90 градусов
    public void rotateMatrix() {
        int n = arr.length;
        double[][] tempArr = new double[n][n];
        for(int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                tempArr[i][j] = arr[j][n - i - 1];
            }
        }
        arr = tempArr;
    }

    public void divideMatrix () throws divisionByNull {
        int n = arr.length;
        double divider = 0;
        double[][] tempArr = new double[n][n];
        for(int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0.0) {
                    divider = arr[i][j+1];
                }
                else if (j==n-1) {
                    divider = arr[i][j - 1];
                }
                else {
                    divider = arr[i][j-1] + arr[i][j+1];
                }
                if (divider == 0.0) {
                    logger.log(Level.WARNING, "Problem element in the matrix: " + (i + 1) + " row, " + (j + 1) + " column.\n");
                    throw new divisionByNull("Деление на ноль!");

                }
                tempArr[i][j] = arr[i][j]/divider;
            }
        }
        arr = tempArr;
    }
}
