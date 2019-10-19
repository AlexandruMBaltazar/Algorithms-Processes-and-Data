package arrayGenerator;

/**
 * A simple array generator, that generates a sorted array [0,1,2,..,n-1]
 *
 * @author Hugh Osborne
 * @version September 2019
 */

public class SortedListingGenerator implements ListingGenerator {

    private int[] array;

    /**
     * Create an array of ints of size <tt>size</tt>, and populate it
     * with the values 0..<tt>size</tt>-1.
     *
     * @param size the size of the array to be created
     */
    SortedListingGenerator(int size)
    {
        array = new int[size]; // create the array
        for (int index = 0; index < array.length; index++) {  // populate it
            array[index] = index;
        }
    }

    /**
     * Get this ArrayGenerator's array.
     *
     * @return the array created by this ArrayGenerator
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Get the size of this ArrayGenerator's array.
     *
     * @return the size of the array
     */
    public int getSize() {
        return array.length;
    }
}
