package unaryPredicate;

/**
 * A unary predicate is a function that takes a single values and returns a boolean.
 *
 * In this interface this function is called test.
 *
 * @param <T> the type of object to be tested by the test function
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public interface UnaryPredicate<T> {

    /**
     * Test whether a given value satisifies this predicate's condition.
     *
     * @param object the object to be tested
     * @return true iff the object satisfies this predicate's condition
     */
    public boolean test(T object);
}

