package br.univali.kob.model;

import java.util.Objects;

/**
 * Class to represent the Hash Object.
 * @param <K>: type of Key on the hash.
 * @param <V>: type of Value on the hash.
 */
public class Hash<K, V> {
    private K key;
    private V value;
    private Hash<K, V> next;

    /**
     * Default class constructor.
     * @param key: K value for the Key that will be inserted on the class.
     * @param value: V value for the Value that will be inserted on the class.
     */
    public Hash(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get key.
     * @return K with the value of the Key in the Hash class.
     */
    public K getKey() { return this.key; }

    /**
     * Get value.
     * @return V with the value of the Value in the Hash class.
     */
    public V getValue() { return this.value; }

    /**
     * Get next.
     * @return Hash<K, V> with the value of the next element on the group (null if the current is the last).
     */
    public Hash<K, V> getNext() { return this.next; }

    /**
     * Set value for Value attribute on the Hash class.
     * @param value: V with the value that will inserted on the Value attribute of the class.
     */
    public void setValue(V value) { this.value = value; }

    /**
     * Set value for the next attribute on the Hash class.
     * @param next: Hash<K, V> with the value that will be inserted on the next attribute of the class.
     */
    public void setNext(Hash<K, V> next) {this.next = next; }

    /**
     * Print hash.
     */
    public void print() {
        System.out.print("[Key -> " + this.key + "]" + " / [Value -> " + this.value);
    }

    @Override
    public String toString() {
        return "Hash{" +
                "key=" + this.key +
                ", value=" + this.value +
                ", next=" + this.next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hash)) return false;
        Hash<?, ?> hash = (Hash<?, ?>) o;
        return Objects.equals(this.key, hash.key) &&
                Objects.equals(this.value, hash.value) &&
                Objects.equals(this.next, hash.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.value, this.next);
    }
}
