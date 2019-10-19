package arrayGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides some default test methods for ArrayGenerators, checking that these generate arrays of the required
 * size.
 *
 * @author Hugh Osborne
 * @version September 2019
 */
abstract class ArrayGeneratorTest {

    abstract protected ArrayGenerator createArrayGenerator(int size);

    /**
     * Test whether the generator generates arrays of the correct size
     * @param generator the generator to be tested
     */
    private void testSize(ArrayGenerator generator) {
        assertEquals(generator.getSize(), generator.getArray().length);
    }

    @Test
    void testOneSize() {
        testSize(createArrayGenerator(1));
    }

    @Test
    void testTwoSize() {
        testSize(createArrayGenerator(2));
    }

    @Test
    void testFourSize() {
        testSize(createArrayGenerator(4));
    }

    @Test
    void testHundredSize() {
        testSize(createArrayGenerator(100));
    }

   @Test
   void testThousandSize() {
        testSize(createArrayGenerator(1000));
    }

    @Test
    void testMillionSize() {
        testSize(createArrayGenerator(1000000));
    }

}