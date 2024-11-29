package matrix.multiplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMatrixMultiplication {
    public static double[][] parallelMultiply(double[][] A, double[][] B, int threads) throws Exception {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        double[][] result = new double[rowsA][colsB];
        ExecutorService executor = Executors.newFixedThreadPool(threads);
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

        for (Future<?> future : futures) {
            future.get(); // Espera a que termine cada tarea
        }
        executor.shutdown();
        return result;
    }
}
