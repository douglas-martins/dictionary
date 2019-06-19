package br.univali.kob.model;

import java.util.Objects;

/**
 * Class to represent the Association Object.
 * @param <K>: type of Key on the hash.
 * @param <V>: type of Value on the hash.
 */
public class Association<K, V> {
    private K key;
    private V value;

    /**
     * Default class constructor.
     * @param key: K value for the Key that will be inserted on the class.
     * @param value: V value for the Value that will be inserted on the class.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get key.
     * @return K with the value of the Key in the Association class.
     */
    public K getKey() { return this.key; }

    /**
     * Get value.
     * @return V with the value of the Value in the Association class.
     */
    public V getValue() { return this.value; }

    /**
     * Set value for Value attribute on the Association class.
     * @param value: V with the value that will inserted on the Value attribute of the class.
     */
    public void setValue(V value) { this.value = value; }

    /**
     * Print hash.
     */
    public void print() {
        System.out.print("[Key: " + this.key + "]" + " / [Value: " + this.value);
    }

    @Override
    public String toString() {
        return "Association{" +
                "key=" + this.key +
                ", value=" + this.value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Association)) return false;
        Association<?, ?> association = (Association<?, ?>) o;
        return Objects.equals(this.key, association.key) &&
                Objects.equals(this.value, association.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }
}
