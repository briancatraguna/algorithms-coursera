import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int arraySize;
    private int queueSize;

    public RandomizedQueue() {
        arraySize = 1;
        array = (Item[]) new Object[arraySize];
        queueSize = 0;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public int size() {
        return queueSize;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue a null element!");
        }
        array[queueSize] = item;
        queueSize++;
        if (queueSize == arraySize) {
            resizeArray(arraySize * 2);
        }
    }

    private void resizeArray(int size) {
        Item[] newArray = (Item[]) new Object[size];
        for (int i = 0; i < queueSize; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        arraySize = size;
    }

    public Item dequeue() {
        checkIfEmpty();
        int randomIndex = StdRandom.uniform(queueSize);
        Item randomItem = array[randomIndex];
        array[randomIndex] = array[queueSize - 1];
        array[queueSize - 1] = null;
        queueSize--;

        if (queueSize <= (arraySize / 4)) {
            resizeArray(arraySize / 2);
        }
        return randomItem;
    }

    public Item sample() {
        checkIfEmpty();
        int randomIndex = StdRandom.uniform(queueSize - 1);
        Item randomItem = array[randomIndex];
        return randomItem;

    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve from an empty queue!");
        }
    }

    private class ListIterator implements Iterator<Item> {

        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return array[currentIndex] != null;
        }

        @Override
        public Item next() {
            if (array[currentIndex] == null) {
                throw new NoSuchElementException("Cannot iterate to the next empty element!");
            }
            Item item = array[currentIndex];
            currentIndex++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove from an iterator!");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> myRandomizedQueue = new RandomizedQueue<>();
        for (int i = 1; i <= 10; i++) {
            myRandomizedQueue.enqueue(i);
        }


        for (int i = 1; i <= 10; i++) {
            System.out.printf("Dequeueing %s\n", myRandomizedQueue.dequeue());
        }

        System.out.println(myRandomizedQueue.isEmpty());


    }
}
