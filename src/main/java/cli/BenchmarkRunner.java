package cli;

import algorithms.MaxHeap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000};
        String csvFile = "heap_benchmark.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write("n,insert_time_ms,extract_time_ms\n");
            for (int n : sizes) {
                Random rand = new Random();
                int[] data = new int[n];
                for (int i = 0; i < n; i++) data[i] = rand.nextInt(1000000);

                MaxHeap heap = new MaxHeap(n);
                long start = System.nanoTime();
                for (int x : data) heap.insert(x);
                long insertTime = System.nanoTime() - start;

                start = System.nanoTime();
                while (true) {
                    try {
                        heap.extractMax();
                    } catch (Exception e) { break; }
                }
                long extractTime = System.nanoTime() - start;

                writer.write(n + "," + insertTime/1e6 + "," + extractTime/1e6 + "\n");
                System.out.printf("n=%d | insert=%.3fms | extract=%.3fms%n",
                        n, insertTime/1e6, extractTime/1e6);
            }
            System.out.println("Results saved to " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
