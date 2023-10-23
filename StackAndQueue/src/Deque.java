import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;

        public Node() {
            this.item = null;
        }

        public Node(Item item) {
            this.item = item;
        }
    }
    private Node head;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {
        head = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        size++;
        if(isEmpty()) {
            head = new Node(item);
            last = head;
            return;
        }
        Node new_head = new Node(item);
        head.prev = new_head;
        new_head.next = head;
        head = new_head;
        head.prev = null;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        size++;
        if(isEmpty()) {
            last = new Node(item);
            head = last;
            return;
        }
        Node new_last = new Node(item);
        last.next = new_last;
        new_last.prev = last;
        last = new_last;
        last.next = null;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("There is no element to remove");
        }

        if(size() == 1) {
            Item res = head.item;
            head = null;
            last = null;
            size--;
            return res;
        }
        Item res = head.item;
        head = head.next;
        head.prev = null;
        size--;
        return res;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("There is no element to remove");
        }

        if(size() == 1) {
            Item res = last.item;
            head = null;
            last = null;
            size--;
            return res;
        }
        Node old_last = last;
        last = last.prev;
        last.next = null;
        size--;
        return old_last.item;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        System.out.println(deque.isEmpty());
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        System.out.println(deque.removeFirst());
        deque.addLast(10);
        System.out.println(deque.removeFirst());
    }
}