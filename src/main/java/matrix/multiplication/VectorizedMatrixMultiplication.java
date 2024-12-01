package matrix.multiplication;
public class VectorizedMatrixMultiplication {
        public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
            if (matrixA[0].length != matrixB.length) {
                throw new IllegalArgumentException("Matrix multiplication not possible with given matrices.");
            }

            int[][] result = new int[matrixA.length][matrixB[0].length];

            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixB[0].length; j++) {
                    result[i][j] = vectorizedDotProduct(matrixA[i], getColumn(matrixB, j));
                }
            }
            return result;
        }

        private static int vectorizedDotProduct(int[] row, int[] column) {
            int sum = 0;
            for (int k = 0; k < row.length; k++) {
                sum += row[k] * column[k];
            }
            return sum;
        }

        private static int[] getColumn(int[][] matrix, int colIndex) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][colIndex];
            }
            return column;
        }
    }

