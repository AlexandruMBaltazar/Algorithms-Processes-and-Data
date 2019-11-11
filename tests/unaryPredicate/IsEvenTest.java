package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsEvenTest {

    private IsEven predicate = new IsEven();

   @Test
    void testZero() {
        assertTrue(predicate.test(0));
    }

    @Test
    void testOne() {
        assertFalse(predicate.test(1));
    }

    @Test
    void testTwo() {
        assertTrue(predicate.test(2));
    }

    @Test
    void testThree() {
        assertFalse(predicate.test(3));
    }

    @Test
    void testBigEven() {
        assertTrue(predicate.test(2*((Integer.MAX_VALUE-1)/2)));
    }

    @Test
    void testBigOdd() {
        assertFalse(predicate.test(2*((Integer.MAX_VALUE-1)/2)-1));
    }

   @Test
    void testMinusOne() {
        assertFalse(predicate.test(-1));
    }

    @Test
    void testMinusTwo() {
        assertTrue(predicate.test(-2));
    }

    @Test
    void testMinusThree() {
        assertFalse(predicate.test(-3));
    }

    @Test
    void testMinusBigEven() {
        assertTrue(predicate.test(2*((Integer.MIN_VALUE+1)/2)));
    }

    @Test
    void testMinusBigOdd() {
        assertFalse(predicate.test(2*((Integer.MIN_VALUE+1)/2)+1));
    }
}