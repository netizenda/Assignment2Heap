package algorithms;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size++] = value;
        heapifyUp(size - 1);
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return max;
    }

    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        if (newValue < heap[index]) throw new IllegalArgumentException("New value smaller");
        heap[index] = newValue;
        heapifyUp(index);
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        while (left(i) < size) {
            int larger = left(i);
            if (right(i) < size && heap[right(i)] > heap[larger]) larger = right(i);
            if (heap[i] >= heap[larger]) break;
            swap(i, larger);
            i = larger;
        }
    }

    private void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    private void ensureCapacity() {
        if (size == heap.length)
            heap = Arrays.copyOf(heap, heap.length * 2 + 1);
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public void printHeap() {
        for (int i = 0; i < size; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }
}
