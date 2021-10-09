package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        int matrixOrder = getMatrixOrder();
        int[][] matrix = getMatrix(matrixOrder);
        outputMatrix(matrix, matrixOrder);
    }

    public static int getMatrixOrder() {
        int matrixOrder = 0;
        String path = "E:\\ОАиП\\ЛР2\\Java\\LR2.3\\InputData.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            matrixOrder = Integer.parseInt(reader.readLine());
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } catch (IOException e) {
            e.getMessage();
        } catch (NumberFormatException e) {
            System.err.println("There's not a number in file");
        }
        return matrixOrder;
    }

    public static int[][] getMatrix(int n) {
        int maxCol = n - 1;
        int element = 1;
        int[][] matrix = null;
        try {
            matrix = new int[n][n];
        } catch (NegativeArraySizeException e) {
            System.err.println("Negative matrix size");
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = element;
                    element++;
                }
            } else {
                for (int j = maxCol; j > -1; j--) {
                    matrix[i][j] = element;
                    element++;
                }
            }
        }
        return matrix;
    }

    public static void outputMatrix(int[][] matrix, int matrixOrder) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("E:\\ОАиП\\ЛР2\\Java\\LR2.3\\OutputData.txt"));
            for (int i = 0; i < matrixOrder; i++) {
                for (int j = 0; j < matrixOrder; j++) {
                    System.out.printf("%3d", matrix[i][j]);
                    writer.write(matrix[i][j]);
                }
                writer.newLine();
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Output file is not found");
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
