package unaryPredicate;

/**
 * An extension to the UnaryPredicate interface.  Implementations must implement
 * the numberSatisfying method.
 *
 * @author Hugh Osborne
 * @version October 2019
 *
 */
public interface UnaryPredicateCount<T> extends UnaryPredicate<T> {

    /**
     * Count the number of entries in an array that satisfy this predicate's test.
     *
     * @param array An array of objects of the type tested by this predicate's test
     * @return the number of objects in the array which satisfy the test
     */
    abstract int numberSatisfying(T[] array);

}
