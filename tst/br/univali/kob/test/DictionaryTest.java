package br.univali.kob.test;

import br.univali.kob.model.Map;

public class DictionaryTest {
    private Map<Integer, String> dictionary;

    public static void main(String[] args) {
        System.out.println("==================== DICTIONARY TEST ====================");
        DictionaryTest dictionaryTest = new DictionaryTest();

        dictionaryTest.init();

        // insertMul() test case
        System.out.println();
        dictionaryTest.insertMulTestCase(new Integer[] {0, 1, 2, 3, 0, 1, 2, 0, 3, 0, 2},
                new String[] {"Abacate", "Banana", "Caju", "Damasco", "Abacate", "Banana", "Caju", "Abacate",
                        "Damasco", "Abacate", "Caju"});
        System.out.println();

        // insert() test case
        System.out.println();
        dictionaryTest.insertTestCase(4, "Elele");
        System.out.println();

        // remove() test case
        System.out.println();
        dictionaryTest.removeTestCase(0);
        System.out.println();

        // remove() test case
        System.out.println();
        dictionaryTest.removeTestCase(1);
        System.out.println();

        // get() test case
        System.out.println();
        dictionaryTest.getTestCase(4);
        System.out.println();

        // isEmpty() test case
        System.out.println();
        dictionaryTest.isEmptyTestCase();
        System.out.println();

        System.out.println("==================== DICTIONARY TEST ====================");
    }

    private void init() {
        this.dictionary = new Map<>();
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
}
