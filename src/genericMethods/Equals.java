package genericMethods;

/**
 * A demonstration of a generic method.
 *
 * This class defines a (rather superfluous) static method that will test for
 * equality (according to the equals() method!) of two objects of the same type.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public class Equals {

    /**
     * Check if two objects are equal
     * @param <T> the type of objects to be compared
     * @param object1 the first object
     * @param object2 the second object
     * @return true if the objects are equal (according to the equals() method)
     */
    public static <T> boolean equals(T object1, T object2) {
        if (object1==null) {
            return object2==null;
        } else {
            return object1.equals(object2);
        }
    }
}
