package searcher;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implements the findElement() in order to find the k largest elements.
 *
 * It is a more efficient approach compared to the findElement() implementation in the SimpleSearcher class
 *
 * @author Alexandru Baltazar
 * @version October 2019
 *
 */

public class CleverSearcher extends Searcher {


    /**
     *
     * @param array the array in which this CleverSearcher object will search
     * @param k this CleverSearcher object searches for the kth largest entry in the array
     */
    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    /**
     * Get the k largest element in a more efficient way
     * The new value from the big array is slotted into the correct position "by hand"
     * @return k largest element of the array
     * @throws IndexingError if the index, k, is out of bounds
     */
    @Override
    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();
        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }

        int[] mySmallArray = new int[k];

        for (int i = 0; i < k; i++){
            mySmallArray[i] = array[i];
        }

        Arrays.sort(mySmallArray);

        //Bellow we are inserting the value in the correct position "by hand"
        for(int i = k; i < array.length; i++){
            if(array[i] > mySmallArray[0]){
                mySmallArray[0] = array[i];
                for (int z = 0; z < k; z++){
                    if(z == k-1){
                        break;
                    }
                    if(mySmallArray[z] > mySmallArray[z+1]){
                        int temp = mySmallArray[z];
                        mySmallArray[z] = mySmallArray[z+1];
                        mySmallArray[z+1] = temp;
                    }
                }
            }


        }

        return mySmallArray[0];
    }
}
