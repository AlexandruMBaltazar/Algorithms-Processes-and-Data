package binaryTree;

import arrayGenerator.generator.IntegerArrayGenerator;
import arrayGenerator.scope.IntegerScope;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class BTreeTest{

    /**
     * Create a binary tree for integers
     */
    abstract protected BTree<Integer> createBinaryTree();

    /**
     * Testing inorder traversal for the binary tree
     * In this test we want to make sure that we get the expected output when we traverse it
     * We will make use of the arrayGenerator used in previous practicals in order to generate our values
     * @param arraySize the size of the generated binary tree and list
     */
    private void inOrderTraversal(int arraySize){
        BTree<Integer> binaryTree = createBinaryTree();
        Integer[] arrayOfValues = new Integer[arraySize];
        Integer[] expectedOutput = new Integer[arraySize];

        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));
        arrayOfValues = integerArrayGenerator.getArray(arraySize);

        for (Integer element : arrayOfValues ){
            binaryTree.insert(element);
        }

        expectedOutput = arrayOfValues;
        Arrays.sort(expectedOutput);

        assertArrayEquals(expectedOutput, binaryTree.traverse().toArray());

    }

    /**
     * Testing contains for the binary tree
     * This will test if our binary tree contains a given value
     * The output should be true in this case
     */
    private void containsCheckTrue(){

        BTree<Integer> binaryTree = createBinaryTree();

        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(27);

        assertEquals(true, binaryTree.contains(3));
    }

    /**
     * Testing contains for the binary tree
     * This will test if our binary tree contains a given value
     * The output should be false in this case
     */
    private void containsCheckFalse(){
        BTree<Integer> binaryTree = createBinaryTree();

        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(27);

        assertEquals(false, binaryTree.contains(12));

    }

    /**
     * This tests if we get the correct value at the root of the tree
     * @param arraySize the size of the generated binary tree and list
     * @throws NullPointerException if the tree is empty
     */
    private void getValue(int arraySize) throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();
        Integer[] arrayOfValues = new Integer[arraySize];


        IntegerArrayGenerator integerArrayGenerator = new IntegerArrayGenerator(new IntegerScope(1,100));
        arrayOfValues = integerArrayGenerator.getArray(arraySize);

        for (Integer element : arrayOfValues ){
            binaryTree.insert(element);
        }

        int rootValue = arrayOfValues[0];

        assertEquals(rootValue, binaryTree.getValue());
    }

    /**
     * This tests that if our binary tree is empty and we get the value stored at the root of the tree
     * a NullPointerException will be thrown
     * @throws NullPointerException if the tree is empty
     */
    private void getValueException() throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();

        try {
            binaryTree.getValue();
            fail("NullPointerException didn't happened");
        }catch (NullPointerException exception){

        }

    }

    /**
     * This tests that if we traverse the right subtree we get the expected output
     * @throws NullPointerException if the tree is empty
     */
    private void traverseRightSubtree() throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();
        Integer[] array = {7,5,4,6,7,10,9,11};

        for(Integer element : array){
            binaryTree.insert(element);
        }

        Integer[] expectedRightTree = {7,9,10,11};

        assertArrayEquals(expectedRightTree, binaryTree.getRight().traverse().toArray());

    }

    /**
     * This tests that if we traverse the right subtree we get the expected output
     * @throws NullPointerException if the tree is empty
     */
    private void traverseLeftSubtree() throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();
        Integer[] array = {7,5,4,6,7,10,9,11};

        for(Integer element : array){
            binaryTree.insert(element);
        }

        Integer[] expectedLeftTree = {4,5,6};

        assertArrayEquals(expectedLeftTree, binaryTree.getLeft().traverse().toArray());

    }


    /**
     * This tests that if our binary tree is empty and we get the right subtree
     * a NullPointerException will be thrown
     * @throws NullPointerException if the tree is empty
     */
    private void getRightSubtreeException() throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();

        try {
            binaryTree.getRight();
            fail("NullPointerException didn't happened");
        }catch (NullPointerException exception){

        }
    }

    /**
     * This tests that if our binary tree is empty and we get the left subtree
     * a NullPointerException will be thrown
     * @throws NullPointerException if the tree is empty
     */
    private void getLeftSubtreeException() throws NullPointerException{
        BTree<Integer> binaryTree = createBinaryTree();

        try {
            binaryTree.getLeft();
            fail("NullPointerException didn't happened");
        }catch (NullPointerException exception){

        }
    }

    /**
     * This tests if our binary tree generics work
     * We are going to store some custom objects
     */
    private void testCustomObjects(){
        BinaryTree<Person> binaryTree = new BinaryTree<Person>();

        binaryTree.insert(new Person("Ryan"));
        binaryTree.insert(new Person("Alex"));
        binaryTree.insert(new Person("Mike"));
        binaryTree.insert(new Person("Miruna"));
        binaryTree.insert(new Person("Andrew"));

        Person[] persons = {new Person("Alex"), new Person("Andrew"), new Person("Mike"), new Person("Miruna") ,new Person("Ryan")};
        assertArrayEquals(persons, binaryTree.traverse().toArray());
    }




    @Test
    void testInOrderTraversalIn10(){
        inOrderTraversal(10);
    }

    @Test
    void testInOrderTraversalIn50(){
        inOrderTraversal(50);
    }

    @Test
    void testInOrderTraversalIn100(){
        inOrderTraversal(100);
    }

    @Test
    void testContainsTrueIn1000(){
        containsCheckTrue();
    }

    @Test
    void testContainsFalse(){
        containsCheckFalse();
    }

    @Test
    void testGetValueIn10(){
        getValue(10);
    }

    @Test
    void testGetValueIn100(){
        getValue(100);
    }

    @Test
    void testGetValueIn1000(){
        getValue(1000);
    }

    @Test
    void testGetValueException(){
        getValueException();
    }

    @Test
    void testTraverseRightSubtreeIn10(){
        traverseRightSubtree();
    }

    @Test
    void testTraverseLeftSubtreeIn10(){
        traverseLeftSubtree();
    }

    @Test
    void testGetRightSubtreeException(){
        getRightSubtreeException();
    }

    @Test
    void testGetLeftSubtreeException(){
        getLeftSubtreeException();
    }

    @Test
    void testGenerics(){
        testCustomObjects();
    }

}