package hashing;

import java.util.LinkedList;

public class CustomHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashTable() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;

        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = 2 * buckets.length;
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = hash(entry.key, newCapacity);
                    LinkedList<Entry<K, V>> newBucket = newBuckets[index];

                    if (newBucket == null) {
                        newBucket = new LinkedList<>();
                        newBuckets[index] = newBucket;
                    }

                    newBucket.add(entry);
                }
            }
        }

        buckets = newBuckets;
    }

    private int hash(K key) {
        return hash(key, buckets.length);
    }

    private int hash(K key, int capacity) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
}
