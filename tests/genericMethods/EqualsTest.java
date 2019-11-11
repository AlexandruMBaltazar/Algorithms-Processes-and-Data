package genericMethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    /**
     * A selection of tests for equals
     */

    @Test
    void testEqualIntegers() {
        assertTrue(Equals.equals(3, 3));
    }

    @Test
    void testNotEqualIntegers() {
        assertFalse(Equals.equals(3, 7));
    }

    @Test
    void testEqualStrings() {
        assertTrue(Equals.equals("Hugh", "Hugh"));
    }

    @Test
    void testNotEqualStrings() {
        assertFalse(Equals.equals("Hugh", "hugh"));
    }

    @Test
    void testEqualNull() {
        assertTrue(Equals.equals(null, null));
    }

    @Test
    void testNotEqualNull1() {
        assertFalse(Equals.equals(null, 4));
    }

    @Test
    void testNotEqualNull2() {
        assertFalse(Equals.equals("Hugh", null));
    }    
}