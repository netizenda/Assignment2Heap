package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    @Test
    void testInsertAndPeek() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        assertEquals(20, heap.peek());
    }

    @Test
    void testExtractMax() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(40);
        heap.insert(20);
        assertEquals(40, heap.extractMax());
    }

    @Test
    void testIncreaseKey() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.increaseKey(2, 25);
        assertEquals(25, heap.peek());
    }
}
