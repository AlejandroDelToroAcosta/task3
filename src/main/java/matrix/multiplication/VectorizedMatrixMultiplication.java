package matrix.multiplication;

import org.jblas.DoubleMatrix;

import java.util.ArrayList;

public class VectorizedMatrixMultiplication {
    public static DoubleMatrix vectorizedMultiply(DoubleMatrix A, DoubleMatrix B) {
        return A.mmul(B);

    }
}
