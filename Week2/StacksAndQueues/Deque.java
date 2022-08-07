import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item data;
        Node prev;
        Node next;
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkForNull(item);
        Node firstNode = new Node();
        firstNode.data = item;
        firstNode.prev = null;
        if (isEmpty()) {
            firstNode.next = null;
            first = firstNode;
            last = firstNode;
        } else if (size == 1) {
            last.prev = firstNode;
            firstNode.next = last;
            first = firstNode;
        } else {
            firstNode.next = first;
            first.prev = firstNode;
            first = firstNode;
        }
        size++;
    }

    public void addLast(Item item) {
        checkForNull(item);
        Node lastNode = new Node();
        lastNode.data = item;
        lastNode.next = null;
        if (isEmpty()) {
            lastNode.prev = null;
            last = lastNode;
            first = lastNode;
        } else if (size == 1) {
            first.next = lastNode;
            lastNode.prev = first;
            last = lastNode;
        } else {
            lastNode.prev = last;
            last.next = lastNode;
            last = lastNode;
        }
        size++;
    }

    private void checkForNull(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null arguments are not allowed!");
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }
        Node removedFirstNode = first;
        first = first.next;
        size--;
        return removedFirstNode.data;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }
        Node removedLastNode = last;
        last = last.prev;
        size--;
        return removedLastNode.data;
    }

    private class ListIterator implements Iterator<Item> {

        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("Cannot iterate to the next empty element!");
            }
            Item item = current.data;
            current = current.next;
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
        Deque<Integer> myDeque = new Deque<>();
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.addFirst(4);
        for (Integer item: myDeque) {
            System.out.println(myDeque.removeLast());
        }
    }
}
