package multiplication.benchmark;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import org.jblas.DoubleMatrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@BenchmarkMode(Mode.AverageTime) // Mide el tiempo promedio de ejecución
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Salida en milisegundos
@State(Scope.Thread) // Cada hilo tiene su propia instancia
public class MatrixMultiplicationBenchmark {


}
