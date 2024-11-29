package matrix.multiplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMatrixMultiplication {
    public static double[][] multiply(double[][] A, double[][] B, int threadCount) throws Exception {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        if (colsA != B.length) {
            throw new IllegalArgumentException("Column count of A must match row count of B");
        }

        double[][] result = new double[rowsA][colsB];
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Dividir el trabajo entre los hilos
        Future<?>[] futures = new Future<?>[rowsA];
        for (int i = 0; i < rowsA; i++) {
            final int row = i;
            futures[i] = executor.submit(() -> {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[row][j] += A[row][k] * B[k][j];
                    }
                }
            });
        }

        // Esperar a que todas las tareas terminen
        for (Future<?> future : futures) {
            future.get();
        }

        executor.shutdown(); // Apagar el ExecutorService
        return result;
    }
}
