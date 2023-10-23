import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] RQueue;

    // construct an empty randomized queue
    public RandomizedQueue() {
        RQueue = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(size == RQueue.length) resize(2 * RQueue.length);
        RQueue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int pos = StdRandom.uniformInt(size);
        Item res = RQueue[pos];
        if(pos != size - 1) {
            RQueue[pos] = RQueue[size - 1];
        }
        RQueue[size - 1] = null;
        size--;
        if(size > 0 && size <= RQueue.length / 4) {
            resize(RQueue.length / 2);
        }
        return res;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int pos = StdRandom.uniformInt(size);
        return RQueue[pos];
    }

    private class RQueueIterator implements Iterator<Item> {
        private Item[] RQueueCopy = (Item[]) new Object[RQueue.length];
        private int copySize = size;
        public RQueueIterator(){
            for (int i = 0; i < RQueue.length; i++){
                RQueueCopy[i] = RQueue[i];
            }
        }
        @Override
        public boolean hasNext() {
            return copySize > 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int pos = StdRandom.uniformInt(copySize);
            Item res = RQueueCopy[pos];
            if(pos != copySize - 1) {
                RQueueCopy[pos] = RQueueCopy[copySize - 1];
            }
            RQueueCopy[copySize - 1] = null;
            copySize--;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RQueueIterator();
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] copy = (Item[]) new Object[capacity];
        if (size >= 0) System.arraycopy(RQueue, 0, copy, 0, size);
        RQueue = copy;
        copy = null;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> myrq = new RandomizedQueue<Integer>();
        myrq.enqueue(2);
        myrq.enqueue(1);
        myrq.enqueue(3);
        myrq.enqueue(10);

        for(int x : myrq) System.out.println(x);
    }
}