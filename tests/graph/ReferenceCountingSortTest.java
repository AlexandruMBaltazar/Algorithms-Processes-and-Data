package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceCountingSortTest {


    /**
     * This tests if our topological sort with reference counting works on the first graph
     * Our topological sort implementation must work on the principle
     * "smallest-numbered available vertex first"
     */
    private void testReferenceCountingTopologicalSortGraph1() throws GraphError {
        ReferenceCountingSort<Integer> refSort = new ReferenceCountingSort<Integer>();
        Integer[] expect = {3,6,0,1,2,5,8,7,9,4};
        for(int i = 0; i < 10; i++){
            refSort.add(i);
        }

        refSort.add(0,1);
        refSort.add(0,5);
        refSort.add(1,7);
        refSort.add(3,2);
        refSort.add(3,4);
        refSort.add(3,8);
        refSort.add(6,0);
        refSort.add(6,1);
        refSort.add(6,2);
        refSort.add(8,4);
        refSort.add(8,7);
        refSort.add(9,4);

        assertArrayEquals(expect, refSort.getSort().toArray());

    }

    /**
     * This tests if our topological sort with reference counting works on the second graph
     * Our topological sort implementation must work on the principle
     * "smallest-numbered available vertex first"
     */
    private void testReferenceCountingTopologicalSortGraph2() throws GraphError {
        ReferenceCountingSort<Integer> refSort = new ReferenceCountingSort<Integer>();
        Integer[] expect = {3,5,7,8,11,2,9,10};

        refSort.add(2);
        refSort.add(3);
        refSort.add(5);
        refSort.add(7);
        refSort.add(8);
        refSort.add(9);
        refSort.add(10);
        refSort.add(11);

        refSort.add(3,8);
        refSort.add(3,10);
        refSort.add(5,11);
        refSort.add(7,11);
        refSort.add(7,8);
        refSort.add(8,9);
        refSort.add(11,2);
        refSort.add(11,9);
        refSort.add(11,10);

        assertArrayEquals(expect, refSort.getSort().toArray());

    }





    @Test
    void testTopologicalSortGraph1() throws GraphError {
        testReferenceCountingTopologicalSortGraph1();
    }

    @Test
    void testTopologicalSortGraph2() throws GraphError {
        testReferenceCountingTopologicalSortGraph2();
    }


}