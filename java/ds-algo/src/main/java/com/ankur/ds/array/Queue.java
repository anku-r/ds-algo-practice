package com.ankur.ds.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Queue using Dynamic Array
 */
public class Queue<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] arr;

    private int size;

    private int iteratorIndex;

    /**
     * Initialize a queue with default capacity of 10
     */
    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize a queue with provided initial capacity
     * @param initialCapacity
     */
    public Queue(int initialCapacity) {
        arr = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Inserts an object at the end of the queue
     * @param data
     */
    public void enqueue(T data) {
        if (size == arr.length) {
            changeCapacity(arr.length + DEFAULT_CAPACITY);
        }
        arr[size++] = data;
    }

    /**
     * Deletes the object at the first position of the queue
     * @return Deleted object
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = (T) arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--size] = null;
        if (arr.length - size == DEFAULT_CAPACITY) {
            changeCapacity(size);
        }
        return element;
    }

    /**
     * @param index
     * @return object at given index of the queue
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Bad index " + index + " for queue having length " + size);
        }
        return (T) arr[index];
    }

    /**
     * @return size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * @return array output of the queue
     */
    public Object[] toArray() {
        return arr;
    }

    /**
     * Change capacity of the array with new length
     * @param newLength
     */
    private void changeCapacity(int newLength) {
        Object[] tempArr = new Object[newLength];
        for(int i = 0; i < size; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    /**
     * @return iterator to traverse through the queue
     */
    @Override
    public Iterator<T> iterator() {
        iteratorIndex = 0;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iteratorIndex < size;
            }

            @Override
            public T next() {
                return (T) arr[iteratorIndex++];
            }
        };
    }
}
