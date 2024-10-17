package com.itschool.spring_boot_app.Concurrency;

import java.util.Scanner;

public class JavaConcurrency {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul de linii pentru matricea A: ");
        int m = scanner.nextInt();
        System.out.println("Introduceti numarul ce coloane pentru matricea A: ");
        int n = scanner.nextInt();

        System.out.println("Introduceți numărul de linii pentru matricea B: ");
        int p = scanner.nextInt();
        System.out.println("Introduceti numarul ce coloane pentru matricea B: ");
        int k = scanner.nextInt();

        if (n != p) {
            System.out.println("Înmulțirea matricelor nu este posibilă.");

        }

        int[][] A = new int[m][n];
        int[][] B = new int[n][k];
        int[][] C = new int[m][k];

        System.out.println("Introduceti elementele din matricea A: ");

        inputMatrix(A, scanner);

        System.out.println("Introduceti elementele din matricea B: ");
        inputMatrix(B, scanner);

        System.out.println("Matricea A: ");
        printMatrix(A);
        System.out.println("Matricea B: ");
        printMatrix(B);

        // Înmulțirea matricelor într-un singur fir de execuție
        long startSingleThread = System.currentTimeMillis();
        multiplySingleThreaded(A, B, C);
        long endSingleThread = System.currentTimeMillis();
        System.out.println("Matricea rezultată C (single-threaded): ");
        printMatrix(C);

        System.out.println();

        System.out.println("Timp de execuție (single-threaded): " + (endSingleThread - startSingleThread) + " ms");

        // Înmulțirea matricelor într-un mod multithreaded
        int[][] D = new int[m][k];
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];
        int rowsPerThread = m / numThreads;

        long startMultiThread = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == numThreads - 1) ? m : (i + 1) * rowsPerThread;
            threads[i] = new MatrixMultiplicationThread(A, B, D, startRow, endRow);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endMultiThread = System.currentTimeMillis();
        System.out.println("Matricea rezultată D (multithreaded): ");
        printMatrix(D);
        System.out.println("Timp de execuție (multithreaded): " + (endMultiThread - startMultiThread) + " ms");
    }


    private static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    private static void multiplySingleThreaded(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int q = 0; q < A[0].length; q++) {
                    C[i][j] += A[i][q] * B[q][j];
                }
            }
        }
    }

    static class MatrixMultiplicationThread extends Thread {
        private final int[][] A, B, D;
        private final int startRow, endRow;

        public MatrixMultiplicationThread(int[][] A, int[][] B, int[][] D, int startRow, int endRow) {
            this.A = A;
            this.B = B;
            this.D = D;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public void run() {
            int n = B.length;
            int k = B[0].length;
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < k; j++) {
                    D[i][j] = 0;
                    for (int q = 0; q < n; q++) {
                        D[i][j] += A[i][q] * B[q][j];
                    }
                }
            }
        }
    }
}

