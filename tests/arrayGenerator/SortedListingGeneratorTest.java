package arrayGenerator;

/**
 *  Provides some default test methods for SortedListingGenerators, checking that these generate sorted arrays
 *  (as well as inheriting the size checks from ArrayGeneratorTest nad content checks from ListingGeneratorTest).
 *
 *  @author Hugh Osborne
 * @version September 2019
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedListingGeneratorTest extends ListingGeneratorTest {

    @Override
    protected SortedListingGenerator createArrayGenerator(int size) {
        return new SortedListingGenerator(size);
    }

    private void testSorted(SortedListingGenerator generator) {
        for (int i = 0; i < generator.getSize()-1; i++) {
            if (generator.getArray()[i] > generator.getArray()[i+1]) {
                fail("Array is not in ascending order");
            }
        }
    }

    @Test
    void testOneSorted() {
        testSorted(createArrayGenerator(1));
    }

    @Test
    void testTwoSorted() {
        testSorted(createArrayGenerator(2));
    }

    @Test
    void testFourSorted() {
        testSorted(createArrayGenerator(4));
    }

    @Test
    void testHundredSorted() { testSorted(createArrayGenerator(100)); }

    @Test
    void testThousandSorted() {
        testSorted(createArrayGenerator(1000));
    }

    @Test
    void testMillionSorted() {
        testSorted(createArrayGenerator(1000000));
    }

}