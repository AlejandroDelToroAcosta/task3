package benchmark.multiplication;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import matrix.multiplication.ParallelMatrixMultiplication;
import matrix.utils.MatrixGenerator;
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3)

public class ParallelMultiplicationBenchmark {
    private double[][] matrixA;
    private double [][] matrixB;
    @Param({"100", "500", "1024"})
    private int size;

    @Param({"2", "4", "8"})
    private int threadCount;

    @Setup(Level.Iteration)
    public void setup() {
        matrixA = MatrixGenerator.generateMatrix(size, size);
        matrixB = MatrixGenerator.generateMatrix(size, size);
    }

    @Benchmark
    public double[][] multiply() throws Exception {
            return ParallelMatrixMultiplication.multiply(matrixA, matrixB, threadCount);
    }
}
