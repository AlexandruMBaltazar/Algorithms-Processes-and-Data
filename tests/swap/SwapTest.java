package swap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapTest {

    private void testArrayString (){

        String[] names = {"Alex","Miruna","Ryan","Diane","Simon","Luke"};

        String[] expectedArray = {"Alex", "Luke", "Ryan", "Diane","Simon", "Miruna"};

        assertArrayEquals(expectedArray, Swap.swap(names, 1, 5));

    }

    private void testArrayInteger(){
        Integer[] integers = {10, 40, 25, 14, 22, 72, 12 , 1};

        Integer[] expectedArray = {10, 40, 25, 12, 22, 72, 14, 1};

        assertArrayEquals(expectedArray, Swap.swap(integers, 3, 6));
    }

    private void testArrayObjects(){
        Person[] persons = {new Person("Tony"), new Person("Andrew"), new Person("Hugh"), new Person("Diane"), new Person("Simon"), new Person("Gary")};

        Person[] expectedArray = {new Person("Tony"), new Person("Simon"), new Person("Hugh"), new Person("Diane"), new Person("Andrew"), new Person("Gary")};

        assertArrayEquals(expectedArray, Swap.swap(persons, 1, 4));

    }

    @Test
    public void testStringGenerics(){
        testArrayString();
    }

    @Test
    public void testIntegerGenerics(){
        testArrayInteger();
    }

    @Test
    public void testCustomObject(){
        testArrayObjects();
    }



}