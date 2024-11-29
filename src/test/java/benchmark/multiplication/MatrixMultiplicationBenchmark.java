package benchmark.multiplication;

import matrix.utils.MatrixGenerator;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

import matrix.multiplication.MatrixMultiplication;
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MatrixMultiplicationBenchmark {

    private double[][] matrixA;
    private double[][] matrixB;

    @Param({"100", "500", "1024"})
    private int size;

    @Setup(Level.Iteration)
    public void setup() {
        matrixA = MatrixGenerator.generateMatrix(size, size);
        matrixB = MatrixGenerator.generateMatrix(size, size);
    }

    @Benchmark
    public double[][] multiply() {
        return MatrixMultiplication.basicMultiply(matrixA, matrixB);
    }
}
