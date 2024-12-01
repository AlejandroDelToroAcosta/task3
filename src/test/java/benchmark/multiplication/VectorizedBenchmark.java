package benchmark.multiplication;

import matrix.utils.MatrixGenerator;
import matrix.multiplication.VectorizedMatrixMultiplication;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3)
public class VectorizedBenchmark {

    private int[][] matrixA;
    private int[][] matrixB;
    private int size;

    @Param({"100", "500", "1024"})
    private int matrixSize;

    @Setup(Level.Iteration)
    public void setup() {
        matrixA = MatrixGenerator.generateIntMatrix(matrixSize, matrixSize);
        matrixB = MatrixGenerator.generateIntMatrix(matrixSize, matrixSize);
        size = matrixSize;
    }

    @Benchmark
    public int[][] multiply() {
        return VectorizedMatrixMultiplication.multiply(matrixA, matrixB);
    }
}