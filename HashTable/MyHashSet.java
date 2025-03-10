package HashTable;

import java.util.ArrayList;

public class MyHashSet {
    private final int SIZE = 1000;
    private ArrayList<Integer> myBuckets[];
    MyHashSet() {
        myBuckets = new ArrayList[SIZE];
        for(int i = 0; i < myBuckets.length; i++) {
            myBuckets[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hashValue = hashFunction(key);
        var bucket = myBuckets[hashValue];
        int keyIndex = bucket.indexOf(key);
        if(keyIndex < 0) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hashValue = hashFunction(key);
        var bucket = myBuckets[hashValue];
        int keyIndex = bucket.indexOf(key);
        if(keyIndex >= 0) {
            bucket.remove(keyIndex);
        }
    }

    public boolean contains(int key) {
        int hashValue = hashFunction(key);
        var bucket = myBuckets[hashValue];
        int keyIndex = bucket.indexOf(key);
        return keyIndex >= 0;
    }

    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();
        mySet.add(2);
        mySet.add(2);
        mySet.add(1000000);
        System.out.println("mySet.contains(4): " + mySet.contains(1000000));
        mySet.remove(1000000);
        System.out.println("mySet.contains(4): " + mySet.contains(1000000));
    }
}
