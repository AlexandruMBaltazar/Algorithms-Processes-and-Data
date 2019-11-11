package swap;

/**
 * Implements the static swap() in order to swap elements in an array
 * @author Alexandru Baltazar
 * @version November 2019
 */
public class Swap {

    /**
     * This is a generic method that exchange two elements of an array
     * @param array the array in which the swap will take place
     * @param index the first elements to be switched
     * @param indexSwap the second element to be switched
     * @param <T> the type of elements that the array will contain
     * @return the array with the swapped elements inside
     */
    public static <T> T[] swap(T[] array, int index, int indexSwap){

        T temp = array[index];

        array[index] = array[indexSwap];
        array[indexSwap] = temp;

        return array;
    }

}

