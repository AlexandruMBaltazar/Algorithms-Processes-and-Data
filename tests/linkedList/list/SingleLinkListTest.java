package linkedList.list;

import arrayGenerator.generator.IntegerArrayGenerator;
import arrayGenerator.scope.IntegerScope;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkListTest {

    /**
     * Testing that the lower boundary of the linked list
     * In this test we are trying to get the first element in the linked list
     * It should not throw an exception
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void lowerBoundaryChecking(int arraySize) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        try {
            singleLinkList.get(0);
        } catch (ListAccessError listAccessError) {
            fail("Out of bounds error happened");
        }

    }

    /**
     * Testing that the lower boundary of the linked list
     * It SHOULD throw an exception
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void lowerBoundaryExceptionChecking(int arraySize) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        try {
            singleLinkList.get(-1);
            fail("Out of bounds error didn't happened");
        } catch (ListAccessError listAccessError) {

        }

    }


    /**
     * Testing that the upper boundary of the linked list
     * In this test we are trying to get the last element in the linked list
     * It should not throw an exception
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void upperBoundaryChecking(int arraySize) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        try {
            singleLinkList.get(arraySize - 1);
        } catch (ListAccessError listAccessError) {
            fail("Out of bounds error happened");
        }

    }

    /**
     * Testing that the upper boundary of the array
     * It SHOULD throw an exception
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void upperBoundaryExceptionChecking(int arraySize) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        try {
            singleLinkList.get(arraySize);
            fail("Out of bounds error didn't happened");
        } catch (ListAccessError listAccessError) {

        }

    }

    /**
     * In this test the linked list is populated with the same values as the ones in a random generated array
     * This will test that the value returned when we access the linked list at a particular index is the same
     * as the value returned when we access the random generated array at the same index
     * @param arraySize the size of the array
     * @param index the index that we want to access
     * @throws ListAccessError if index is an invalid index.
     */
    private void testLinkedList(int arraySize, int index) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        assertEquals(myArray[index], singleLinkList.get(index));

    }

    /**
     * This tests that if the correct value from the linked list is removed
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void testRemove(int arraySize, int index) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        assertEquals(myArray[index], singleLinkList.remove(index));

    }


    /**
     * This tests that if we remove an out of bounds index an exception will be thrown
     * @param arraySize the size of the array
     * @throws ListAccessError if index is an invalid index.
     */
    private void testRemoveOutOfBoundsIndex(int arraySize) throws ListAccessError {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));

        Integer [] myArray = integerArrayGenerator.getArray(arraySize);

        for(int i = 0; i < myArray.length; i++){
            singleLinkList.add(i, myArray[i]);
        }

        try {
            singleLinkList.remove(arraySize);
            fail("Out of bounds error didn't happened");
        } catch (ListAccessError listAccessError) {

        }

    }

    /**
     * This tests if our linked list generics works
     * Test by storing custom objects inside the linked list
     * @throws ListAccessError if index is an invalid index.
     */
    private void testCustomObjectsLinkedList() throws ListAccessError {
        SingleLinkList<Person> singleLinkList = new SingleLinkList<>();

        Person testPerson = new Person("Mike", 21);

        singleLinkList.add(0, new Person("Alex", 20));
        singleLinkList.add(0, new Person("Ryan", 19));
        singleLinkList.add(0, new Person("Mike", 21));
        singleLinkList.add(0, new Person("Steve", 46));

        assertEquals(testPerson, singleLinkList.get(1));
    }


    @Test
    void test2ndIn10() throws ListAccessError {
        testLinkedList(10, 2);
    }

    @Test
    void test5thIn10() throws ListAccessError {
        testLinkedList(10, 5);
    }

    @Test
    void test40thIn100() throws ListAccessError {
        testLinkedList(100, 40);
    }

    @Test
    void test57thIn100() throws ListAccessError {
        testLinkedList(100, 57);
    }

    @Test
    void test356thIn1000() throws ListAccessError {
        testLinkedList(1000, 356);
    }

    @Test
    void test789thIn1000() throws ListAccessError {
        testLinkedList(1000, 789);
    }

    @Test
    void testRemove2ndIn10() throws ListAccessError {
        testRemove(10, 2);
    }

    @Test
    void testRemove5thIn10() throws ListAccessError {
        testRemove(10, 5);
    }

    @Test
    void testRemove40thIn100() throws ListAccessError {
        testRemove(100, 40);
    }

    @Test
    void testRemove57thIn100() throws ListAccessError {
        testRemove(100, 57);
    }

    @Test
    void testRemove356thIn1000() throws ListAccessError {
        testRemove(1000, 356);
    }

    @Test
    void testRemove789thIn1000() throws ListAccessError {
        testRemove(1000, 789);
    }

    @Test
    void testRemoveExceptionIn10() throws ListAccessError {
        testRemoveOutOfBoundsIndex(10);
    }

    @Test
    void testRemoveExceptionIn100() throws ListAccessError {
        testRemoveOutOfBoundsIndex(100);
    }

    @Test
    void testRemoveExceptionIn1000() throws ListAccessError {
        testRemoveOutOfBoundsIndex(1000);
    }

    @Test
    void testLowerBoundaryIn10() throws ListAccessError {
        lowerBoundaryChecking(10);
    }

    @Test
    void testLowerBoundaryIn100() throws ListAccessError {
        lowerBoundaryChecking(100);
    }

    @Test
    void testLowerBoundaryIn1000() throws ListAccessError {
        lowerBoundaryChecking(1000);
    }

    @Test
    void testLowerBoundaryExceptionIn10() throws ListAccessError {
        lowerBoundaryExceptionChecking(10);
    }

    @Test
    void testLowerBoundaryExceptionIn100() throws ListAccessError {
        lowerBoundaryExceptionChecking(100);
    }

    @Test
    void testLowerBoundaryExceptionIn1000() throws ListAccessError {
        lowerBoundaryExceptionChecking(1000);
    }

    @Test
    void testUpperBoundaryIn10() throws ListAccessError {
        upperBoundaryChecking(10);
    }

    @Test
    void testUpperBoundaryIn100() throws ListAccessError {
        upperBoundaryChecking(100);
    }

    @Test
    void testUpperBoundaryIn1000() throws ListAccessError {
        upperBoundaryChecking(1000);
    }

    @Test
    void testUpperBoundaryExceptionIn10() throws ListAccessError {
        upperBoundaryExceptionChecking(10);
    }

    @Test
    void testUpperBoundaryExceptionIn100() throws ListAccessError {
        upperBoundaryExceptionChecking(100);
    }

    @Test
    void testUpperBoundaryException1000() throws ListAccessError {
        upperBoundaryExceptionChecking(1000);
    }

    @Test
    void testGenericsCustomObjects() throws ListAccessError {
        testCustomObjectsLinkedList();
    }


}