package HashTable;

import java.util.ArrayList;

public class MyHashMap {
    private final int SIZE = 1000;
    private ArrayList<Data> myBuckets[];
    MyHashMap() {
        myBuckets = new ArrayList[SIZE];
        for(int i = 0; i < myBuckets.length; i++) {
            myBuckets[i] = new ArrayList<>();
        }
    }

    private class Data {
        int key;
        int value;
        Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Data) {
                return ((Data)obj).key == this.key;
            }
            return false;
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hashValue = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashValue];
        Data newData = new Data(key, value);
        int index = bucket.indexOf(newData);
        if(index >= 0) {
            bucket.get(index).value = value;
        } else {
            bucket.add(newData);
        }
    }

    public void remove(int key) {
        int hashValue = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashValue];
        Data tmp = new Data(key, 0);
        bucket.remove(tmp);
    }

    public int get(int key) {
        int hashValue = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashValue];
        return bucket.get(bucket.indexOf(new Data(key, 0))).value;
    }
}
