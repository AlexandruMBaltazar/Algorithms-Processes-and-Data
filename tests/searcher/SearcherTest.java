package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Alexanru Baltazar
 * @version October 2019
 */

abstract class SearcherTest {

    /**
     * Create a searcher of the right type
     */
    abstract protected Searcher createSearcher(int[] array, int index) throws IndexingError;

    /**
     * Test that the searcher finds the correct value.  The test uses a random listing generator to create
     * a random listing of the requited size.  Because of the properties of random listings, the kth largest
     * element of a random listing of size n must be n-k.
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the index (the "k" value)
     * @throws IndexingError if k is out of bounds for n
     */
    private void testSearcher(int arraySize,int index) throws IndexingError {
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);
        Searcher search = createSearcher(generator.getArray(), index);
        assertEquals(arraySize - index, search.findElement());
    }

    /**
     * Test if the searcher throws an indexing error when the index provided is negative
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the negative index (the "k" value)
     * @throws IndexingError if k is out of bounds for n
     */
    private void testNegativeIndex(int arraySize, int index) throws IndexingError{
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);

        try{
            Searcher search = createSearcher(generator.getArray(),index );
            search.findElement(); // negative search index should throw an exception
            fail("Expected indexing error didn't happen");
        } catch (IndexingError indexingError){
            // expected due to negative search index
        }
    }

    /**
     * Test if the searcher throws an indexing error.
     * It should throw an indexing error as the index is higher than the arraySize
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the index (the "k" value) which is higher than the arraySize
     * @throws IndexingError if k is out of bounds for n
     */
    private void testOutOfBoundsIndex(int arraySize, int index) throws IndexingError{
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);

        try{
            Searcher search = createSearcher(generator.getArray(),index );
            search.findElement(); // out of bounds search index should throw an exception
            fail("Expected indexing error didn't happen");
        } catch (IndexingError indexingError){
            // expected due to index out of bounds
        }
    }





    @Test
    void testForNegativeValue() throws IndexingError{
        testNegativeIndex(10,-3);
    }


    @Test
    void testForOutOfBoundsIndex() throws IndexingError{
        testOutOfBoundsIndex(10,20);
    }


    @Test
    void test2ndIn10() throws IndexingError {
        testSearcher(10,2);
    }

    @Test
    void test5thIn10() throws IndexingError {
        testSearcher(10,5);
    }
    @Test
    void test3rdIn100() throws IndexingError {
        testSearcher(100,3);
    }

    @Test
    void test16thIn100() throws IndexingError {
        testSearcher(100,16);
    }

    @Test
    void test8thIn1000() throws IndexingError {
        testSearcher(1000,8);
    }

    @Test
    void test107thIn1000() throws IndexingError {
        testSearcher(1000,107);
    }

    @Test
    void test1stIn10000() throws IndexingError {
        testSearcher(10000,1);
    }

    @Test
    void test1003rdn10000() throws IndexingError {
        testSearcher(10000,1003);
    }

    @Test
    void test11thIn100000() throws IndexingError {
        testSearcher(100000,11);
    }

    @Test
    void test4thIn1000000() throws IndexingError {
        testSearcher(1000000,4);
    }
}