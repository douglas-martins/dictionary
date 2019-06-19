package br.univali.kob.model;

import java.util.LinkedList;
import java.util.function.Function;

/**
 * Class to represent a object of Dictionary.
 * @param <K>: Type of key on the Dictionary.
 * @param <V>: Type of value on the Dictionary.
 */
public class Dictionary<K, V> {
    private LinkedList<Association<K, V>>[] chains;
    private int total;
    private Function hash;

    /**
     *
     * @param size
     */
    public Dictionary(int size) {
        this.chains = new LinkedList[size];
        initChains();
    }

    public Dictionary(int size, Function hash) {
        this(size);
        this.hash = hash;
    }

    /**
     * Check if the Dictionary is empty or not
     * @return boolean with true if the Dictionary is empty and false if not.
     */
    public boolean isEmpty() { return (this.chains == null); }

    /**
     * Get Dictionary total of values.
     * @return int with the total of values on the Dictionary.
     */
    public int getTotal() { return this.total; }

    /**
     * Check if the association is inside the Dictionary.
     * @param association: Association<K, V> with the value of association that will be search that is inside on the Dictionary.
     * @return boolean with true if the association is inside the map or false if note.
     */
    public boolean isInside(Association<K, V> association) {
        int group = hash(association.getKey());
        LinkedList<Association<K, V>> chain = this.chains[group];

        for (Association<K, V> element : chain){
            if (element.getKey().equals(association.getKey())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the association position on the Dictionary.
     * @param association: Association<K, V> with the value of association that will be search the position on the Dictionary.
     * @return int with the value of position (-1 if not have position).
     */
    public int getAssociationPosition(Association<K, V> association) {
        int group = hash(association.getKey());
        LinkedList<Association<K, V>> chain = this.chains[group];

        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).getValue().equals(association.getValue())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the group position on the vector.
     * @param association: Association<K, V> with the value of association that will be search the position on the Dictionary.
     * @return int with the value of position (-1 if not have position).
     */
    public int getGroupPosition(Association<K, V> association) {
        return hash(association.getKey());
    }

    /**
     * Insert a object on the Key group on the Dictionary.
     * @param key: K with the value Key of the Object that will be inserted on the Dictionary.
     * @param value: K with the Value of the Object that will be inserted on the Dictionary.
     */
    public void insert(K key, V value) {
        int group = hash(key);
        LinkedList<Association<K, V>> chain = this.chains[group];

        for (Association<K, V> element : chain) {
            if (element.getValue().equals(value)) {
                return;
            }
        }

        chain.add(new Association<>(key, value));
        this.total++;
    }

    /**
     * Remove a object on the Key group on the Dictionary.
     * @param key: K with the value Key of the Object that will be removed.
     */
    public V remove(K key) {
        int group = hash(key);
        LinkedList<Association<K, V>> chain = this.chains[group];

        for (Association<K, V> element : chain) {
            if (element.getKey().equals(key)) {
                V value = element.getValue();
                chain.remove(element);
                this.total--;
                return value;
            }
        }

        // adicionar quando não encontra
        return null;
    }

    /**
     * Get the value for the given key.
     * @param key: K with the value o key for the Object value that will be returned
     * @return Association<K, V> value of the Object for the K key passed.
     */
    public Association<K, V> get(K key) {
        int group = hash(key);
        LinkedList<Association<K, V>> chain = this.chains[group];

        for (Association<K, V> element : chain) {
            if (element.getKey().equals(key)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Get the group that the key belongs to.
     * @param key: K with the value of key that will be calculate.
     * @return int with the value of the hash.
     */
    public int hash(K key) {
        return (Integer) this.hash.apply(key);
    }

    /**
     * Print the Dictionary.
     */
    public void print() {
        for (LinkedList<Association<K, V>> chain : this.chains) {
            if (chain.size() > 0) {
                System.out.print("[Key: " + hash(chain.getFirst().getKey()) + " / [");
                for (Association<K, V> element : chain) {
                    if (element != null) {
                        System.out.print("Value: " + element.getValue());
                    }
                    if (chain.getLast() != element) { System.out.print(" => "); }
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    private void initChains() {
        for (int i = 0; i < this.chains.length; i++) {
            this.chains[i] = new LinkedList<>();
        }
    }
}
