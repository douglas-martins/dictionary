package br.univali.kob.test;

import br.univali.kob.model.Dictionary;

public class MapTest {
    private Dictionary<String, Integer> dictionary;

    public static void main(String[] args) {
        System.out.println("==================== MAP TEST ====================");
        MapTest mapTest = new MapTest();

        mapTest.init();

        // insertMul() test case
        System.out.println();
        mapTest.insertMulTestCase(new String[] {"A", "B", "C", "D", "A", "B", "C", "A", "D", "A", "C"},
                new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11});
        System.out.println();

        // insert() test case
        System.out.println();
        mapTest.insertTestCase("E", 20);
        System.out.println();

        // remove() test case
        System.out.println();
        mapTest.removeTestCase("A");
        System.out.println();

        // remove() test case
        System.out.println();
        mapTest.removeTestCase("B");
        System.out.println();

        // get() test case
        System.out.println();
        mapTest.getTestCase("E");
        System.out.println();

        // isEmpty() test case
        System.out.println();
        mapTest.isEmptyTestCase();
        System.out.println();

        System.out.println("==================== MAP TEST ====================");
    }

    private void init() {
        this.dictionary = new Dictionary<>(10);
    }

    public void isEmptyTestCase() {
        System.out.println("#################### IS EMPTY TEST CASE ####################");
        System.out.println("The Dictionary is empty? " + this.dictionary.isEmpty());
        this.dictionary.print();
        System.out.println("#################### IS EMPTY TEST CASE ####################");
    }

    public void insertTestCase(String key, Integer value) {
        System.out.println("#################### INSERT TEST CASE ####################");
        System.out.println("Try to insert on key " + key + " with the value " + value + "...");
        this.dictionary.insert(key, value);
        this.dictionary.print();
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void insertMulTestCase(String[] keys, Integer[] values) {
        System.out.println("#################### INSERT TEST CASE ####################");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Try to insert on key " + keys[i] + " with the value " + values[i] + "...");
            this.dictionary.insert(keys[i], values[i]);
            this.dictionary.print();
        }
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void removeTestCase(String key) {
        System.out.println("#################### REMOVE TEST CASE ####################");
        System.out.println("Try to remove on key " + key);
        this.dictionary.remove(key);
        this.dictionary.print();
        System.out.println("#################### REMOVE TEST CASE ####################");
    }

    public void getTestCase(String key) {
        System.out.println("#################### GET TEST CASE ####################");
        System.out.println("Try to get value from the key " + key + "...");
        System.out.println(this.dictionary.get(key).getValue());
        this.dictionary.print();
        System.out.println("#################### GET TEST CASE ####################");
    }
}
