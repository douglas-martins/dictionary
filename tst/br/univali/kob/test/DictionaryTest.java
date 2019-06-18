package br.univali.kob.test;

import br.univali.kob.model.Hash;
import br.univali.kob.model.Map;

public class DictionaryTest {
    private Map<Integer, String> dictionary;

    public static void main(String[] args) {
        System.out.println("==================== DICTIONARY TEST ====================");
        DictionaryTest dictionaryTest = new DictionaryTest();

        dictionaryTest.simulateTestCase();
    }

    private void init() { this.dictionary = new Map<>(); }

    public void simulateTestCase() {
        init();

        // insertMul() test case
        System.out.println();
        insertMulTestCase(new Integer[] {0, 1, 2, 3, 0, 1, 2, 0, 3, 0, 2}, new String[] {"Abacate", "Banana", "Caju",
                "Damasco", "Acamante", "Benja", "Caramba", "Abalou", "Deito", "Aalinho", "Correio"});
        System.out.println();

        // insert() test case
        System.out.println();
        insertTestCase(4, "Elele");
        System.out.println();

        // remove() test case
        System.out.println();
        removeTestCase(0);
        System.out.println();

        // remove() test case
        System.out.println();
        removeTestCase(1);
        System.out.println();

        // get() test case
        System.out.println();
        getTestCase(4);
        System.out.println();

        // isEmpty() test case
        System.out.println();
        isEmptyTestCase();
        System.out.println();

        // getTotal() test case
        System.out.println();
        getTotalTestCase();
        System.out.println();

        // isInside() test case
        System.out.println();
        isInsideTestCase(new Hash<>(0, "Abacate"));
        System.out.println();

        // isInside() test case
        System.out.println();
        isInsideTestCase(new Hash<>(0, "Acamante"));
        System.out.println();

        // getHashPosition() test case
        System.out.println();
        getHashPositionTestCase(new Hash<>(1, "Banana"));
        System.out.println();

        // getHashPosition() test case
        System.out.println();
        getHashPositionTestCase(new Hash<>(0, "Aalinho"));
        System.out.println();

        System.out.println("==================== DICTIONARY TEST ====================");
    }

    public void isEmptyTestCase() {
        System.out.println("#################### IS EMPTY TEST CASE ####################");
        System.out.println("The Map is empty? " + this.dictionary.isEmpty());
        this.dictionary.print();
        System.out.println("#################### IS EMPTY TEST CASE ####################");
    }

    public void insertTestCase(Integer key, String value) {
        System.out.println("#################### INSERT TEST CASE ####################");
        System.out.println("Try to insert on key " + key + " with the value " + value + "...");
        this.dictionary.insert(key, value);
        this.dictionary.print();
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void insertMulTestCase(Integer[] keys, String[] values) {
        System.out.println("#################### INSERT TEST CASE ####################");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Try to insert on key " + keys[i] + " with the value " + values[i] + "...");
            this.dictionary.insert(keys[i], values[i]);
            this.dictionary.print();
        }
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void removeTestCase(Integer key) {
        System.out.println("#################### REMOVE TEST CASE ####################");
        System.out.println("Try to remove on key " + key);
        this.dictionary.remove(key);
        this.dictionary.print();
        System.out.println("#################### REMOVE TEST CASE ####################");
    }

    public void getTestCase(Integer key) {
        System.out.println("#################### GET TEST CASE ####################");
        System.out.println("Try to get value from the key " + key + "...");
        System.out.println(this.dictionary.get(key).getValue());
        this.dictionary.print();
        System.out.println("#################### GET TEST CASE ####################");
    }

    public void getTotalTestCase() {
        System.out.println("#################### GET TOTAL TEST CASE ####################");
        System.out.println("Total on the Map: " + this.dictionary.getTotal());
        this.dictionary.print();
        System.out.println("#################### GET TOTAL TEST CASE ####################");
    }

    public void isInsideTestCase(Hash<Integer, String> hash) {
        System.out.println("#################### IS INSIDE TEST CASE ####################");
        System.out.print("The hash ");
        hash.print();
        System.out.print("]");
        System.out.print(" is inside? " + this.dictionary.isInside(hash));
        System.out.println();
        this.dictionary.print();
        System.out.println("#################### IS INSIDE TEST CASE ####################");
    }

    public void getHashPositionTestCase(Hash<Integer, String> hash) {
        System.out.println("#################### GET HASH POSITION TEST CASE ####################");
        int position = this.dictionary.getHashPosition(hash);

        if (position < 0) {
            System.out.print("The hash ");
            hash.print();
            System.out.print("] is not inside the dictionary!");
        } else {
            System.out.print("The position on the dictionary for the hash ");
            hash.print();
            System.out.print("] is " + position);
        }
        System.out.println();
        this.dictionary.print();
        System.out.println("#################### GET HASH POSITION TEST CASE ####################");
    }
}
