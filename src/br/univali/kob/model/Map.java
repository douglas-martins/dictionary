package br.univali.kob.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to represent a object of Map.
 * @param <K>: Type of key on the Map.
 * @param <V>: Type of value on the Map.
 */
public class Map<K, V> {
    private List<Hash<K, V>> chains;

    public Map() {
        this.chains = new ArrayList<>();
    }

    /**
     * Check if the Map is empty or not
     * @return boolean with true if the Map is empty and false if not.
     */
    public boolean isEmpty() { return (this.chains == null); }

    /**
     * Insert a object on the Key group on the Map.
     * @param key: K with the value Key of the Object that will be inserted on the Map.
     * @param value: K with the Value of the Object that will be inserted on the Map.
     */
    public void insert(K key, V value) {
        // Find head of chain for given key
        int group = hash(key);
        Hash<K, V> head = this.chains.get(group);

        // Check if key is already present
        while (head != null) {
            if (head.getKey().equals(key)) { // find group
                setKeyValueOnChain(key, value, head);
                return;
            }
            head = head.getNext();
        }

        // Insert key in chain (create group)
        head = this.chains.get(group);
        Hash<K, V> newElement = new Hash<>(key, value);
        newElement.setNext(head);
        this.chains.set(group, newElement);
    }

    /**
     * Remove a object on the Key group on the Map.
     * @param key: K with the value Key of the Object that will be removed.
     * @return V with the value of element that was removed.
     */
    public V remove(K key) {
        // Apply hash function to find index for given key
        int group = hash(key);
        Hash<K, V> head =  this.chains.get(group);
        Hash<K, V> previous =  null;

        // Search key
        while (head != null) {
            // If key found (for the value that will be removed)
            if (head.getKey().equals(key)) { break; }

            // Else keep looking for
            previous = head;
            head = head.getNext();
        }

        // Object not found
        if (head == null) { return null; }

        // If previous is null, remove key from the List
        if (previous != null) {
            previous.setNext(head.getNext());
        } else {
            this.chains.set(group, head.getNext());
        }

        return head.getValue();
    }

    /**
     * Get the value for the given key.
     * @param key: K with the value o key for the Object value that will be returned
     * @return Hash<K, V> value of the Object for the K key passed.
     */
    public Hash<K, V> get(K key) {
        int group = hash(key);
        Hash<K, V> head = this.chains.get(group);

        while (head != null) {
            if (head.getKey().equals(key)) { return head; }
            head = head.getNext();
        }

        // If not founded
        return null;
    }

    /**
     * Print the Map.
     */
    public void print() {
        for (Hash<K, V> hash : this.chains) {
            if (hash != null) {
                Hash<K, V> next = hash.getNext();
                hash.print();
                while (next != null) {
                    System.out.print(" => ");
                    System.out.print("Value -> " + next.getValue());
                    next = next.getNext();
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    private void initChains() {
        if (this.chains == null) { this.chains = new ArrayList<>(); }

        for (int i = 0; i < 10; i++) {
            this.chains.add(null);
        }
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        if (this.chains.size() <= 0) { initChains(); }
        return hashCode % 10;
    }

    private void setKeyValueOnChain(K key, V value, Hash<K, V> head) {
        Hash<K, V> insideHash = head;
        Hash<K, V> previous = null;
        while (insideHash != null) {
            previous = insideHash;
            insideHash = insideHash.getNext();
        }
        Objects.requireNonNull(previous).setNext(new Hash<>(key, value));
    }
}
