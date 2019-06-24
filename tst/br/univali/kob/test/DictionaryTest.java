package br.univali.kob.test;

import br.univali.kob.model.Association;
import br.univali.kob.model.Dictionary;
import br.univali.kob.model.Hash;
import br.univali.kob.model.HashTest;

public class DictionaryTest {
    private Dictionary<Integer, String> dictionary;

    public static void main(String[] args) {
        DictionaryTest dictionaryTest = new DictionaryTest();

        dictionaryTest.simulateTestCase();
    }

    private void init() { this.dictionary = new Dictionary<>(10, new Hash()); }

    public void simulateTestCase() {
        init();

        System.out.println("==================== DICTIONARY TEST ====================");

        // insertMul() test case
        System.out.println();
        insertMulTestCase(new String[] {"Abacate", "Banana", "Caju", "Damasco", "Acamante", "Benja", "Caramba",
                "Abalou", "Deito", "Aalinho", "Correio"});
        System.out.println();

        // insert() test case
        System.out.println();
        insertTestCase("Elele");
        System.out.println();

        // remove() test case
        System.out.println();
        removeTestCase(("Abacate").hashCode());
        System.out.println();

        // remove() test case
        System.out.println();
        removeTestCase(("Banana").hashCode());
        System.out.println();

        // get() test case
        System.out.println();
        getTestCase(("Acamante").hashCode());
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
        isInsideTestCase(new Association<>(("Abacate").hashCode(), "Abacate"));
        System.out.println();

        // isInside() test case
        System.out.println();
        isInsideTestCase(new Association<>(("Acamante").hashCode(), "Acamante"));
        System.out.println();

        // getAssociationPosition() test case
        System.out.println();
        getAssociationPositionTestCase(new Association<>(("Banana").hashCode(), "Banana"));
        System.out.println();

        // getAssociationPosition() test case
        System.out.println();
        getAssociationPositionTestCase(new Association<>(("Aalinho").hashCode(), "Aalinho"));
        System.out.println();

        // getAssociationPosition() test case
        System.out.println();
        getGroupPositionTestCase(new Association<>(("Banana").hashCode(), "Banana"));
        System.out.println();

        // getAssociationPosition() test case
        System.out.println();
        getGroupPositionTestCase(new Association<>(("Aalinho").hashCode(), "Aalinho"));
        System.out.println();

        System.out.println("==================== DICTIONARY TEST ====================");
    }

    public void isEmptyTestCase() {
        System.out.println("#################### IS EMPTY TEST CASE ####################");
        System.out.println("The Dictionary is empty? " + this.dictionary.isEmpty());
        this.dictionary.print();
        System.out.println("#################### IS EMPTY TEST CASE ####################");
    }

    public void insertTestCase(String value) {
        System.out.println("#################### INSERT TEST CASE ####################");
        int hash = this.dictionary.hash(value.hashCode());
        System.out.println("Try to insert on key " + hash + " with the value " + value + "...");
        this.dictionary.insert(value.hashCode(), value);
        this.dictionary.print();
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void insertMulTestCase(String[] values) {
        System.out.println("#################### INSERT TEST CASE ####################");
        for (String value : values) {
            int hash = this.dictionary.hash(value.hashCode());
            System.out.println("Try to insert on key " + hash + " with the value " + value + "...");
            this.dictionary.insert(value.hashCode(), value);
            this.dictionary.print();
        }
        System.out.println("#################### INSERT TEST CASE ####################");
    }

    public void removeTestCase(Integer key) {
        System.out.println("#################### REMOVE TEST CASE ####################");
        int hash = this.dictionary.hash(key.hashCode());
        System.out.println("Try to remove on key " + hash);
        this.dictionary.remove(key.hashCode());
        this.dictionary.print();
        System.out.println("#################### REMOVE TEST CASE ####################");
    }

    public void getTestCase(Integer key) {
        System.out.println("#################### GET TEST CASE ####################");
        int hash = this.dictionary.hash(key.hashCode());
        System.out.println("Try to get value from the key " + hash + "...");
        System.out.println(this.dictionary.get(key.hashCode()).getValue());
        this.dictionary.print();
        System.out.println("#################### GET TEST CASE ####################");
    }

    public void getTotalTestCase() {
        System.out.println("#################### GET TOTAL TEST CASE ####################");
        System.out.println("Total on the Dictionary: " + this.dictionary.getTotal());
        this.dictionary.print();
        System.out.println("#################### GET TOTAL TEST CASE ####################");
    }

    public void isInsideTestCase(Association<Integer, String> association) {
        System.out.println("#################### IS INSIDE TEST CASE ####################");
        System.out.print("The association ");
        association.print();
        System.out.print("]");
        System.out.print(" is inside? " + this.dictionary.isInside(association));
        System.out.println();
        this.dictionary.print();
        System.out.println("#################### IS INSIDE TEST CASE ####################");
    }

    public void getAssociationPositionTestCase(Association<Integer, String> association) {
        System.out.println("#################### GET ASSOCIATION POSITION TEST CASE ####################");
        int position = this.dictionary.getAssociationPosition(association);

        if (position < 0) {
            System.out.print("The association ");
            association.print();
            System.out.print("] is not inside the dictionary!");
        } else {
            System.out.print("The position on the dictionary for the association ");
            association.print();
            System.out.print("] is " + position);
        }
        System.out.println();
        this.dictionary.print();
        System.out.println("#################### GET ASSOCIATION POSITION TEST CASE ####################");
    }

    public void getGroupPositionTestCase(Association<Integer, String> association) {
        System.out.println("#################### GET GROUP POSITION TEST CASE ####################");
        int position = this.dictionary.getAssociationPosition(association);
        System.out.print("The position on the vector for the dictionary ");
        association.print();
        System.out.print("] is " + position);
        System.out.println();
        System.out.println("#################### GET GROUP POSITION TEST CASE ####################");
    }
}
