package graph;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstTraversalTest {
    /**
     *There are some special graphs for which correct depth first traversals
     * will have relatively easily checkable properties.
     * We will try to traverse some of these
     */


    /**
     * In this test we will have a graph that only has four correct depth-first traversals
     * 0,1,2,3
     * 1,2,3,0
     * 2,3,0,1
     * 3,0,1,2
     * We will test if my depth-first traversal outputs any of these
     * @throws GraphError if the node is not a node in the graph
     */
    private void specificGraph4DepthFirst() throws GraphError {

        Traversal<Integer> g = new DepthFirstTraversal();
        Integer[] expectedOutput = {0,1,2,3};

        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);

        g.add(0,1);
        g.add(1,2);
        g.add(2,3);
        g.add(3,0);

        for (int i = 0; i < 3; i++){
            if(Arrays.equals(g.traverse().toArray(), expectedOutput)){
                break;
            }

            for(int x = 0; x < expectedOutput.length ; x++){
                if(expectedOutput[x] == 3){
                    expectedOutput[x] = 0;
                }else {
                    expectedOutput[x]++;
                }
            }

        }

        if(Arrays.equals(g.traverse().toArray(), expectedOutput)){
            assertArrayEquals(expectedOutput, g.traverse().toArray());
        }else{
            fail("Your traverse is wrong");
        }

    }


    /**
     * In this test we will have a graph with the property that nodes 0 and 1
     * must be adjacent in the traversal, as must nodes 2 and 3
     * We will test if my depth-first traversal outputs the expected pairs
     * @throws GraphError if the node is not a node in the graph
     */
    private void specificGraphAdjacentNodes() throws GraphError {
        Traversal<Integer> g = new DepthFirstTraversal();

        List<Integer> expectedFirstPair = new ArrayList<>();
        expectedFirstPair.add(0);
        expectedFirstPair.add(1);

        List<Integer> expectedSecondPair = new ArrayList<>();
        expectedSecondPair.add(2);
        expectedSecondPair.add(3);

        g.add(0);
        g.add(1);
        g.add(3);
        g.add(2);

        g.add(0,1);
        g.add(1,0);
        g.add(3,2);
        g.add(2,3);

        List<Integer> actualFirstPair = g.traverse().subList(0,2);
        List<Integer> actualSecondPair = g.traverse().subList(2,4);

        if(!actualFirstPair.containsAll(expectedFirstPair) || !actualSecondPair.containsAll(actualSecondPair)){
            fail("Your traverse is wrong");
        }

    }

    /**
     * In this test we will have a more complex graph
     * For this type of graph we have many correct traversals
     * In this test we want to check if our traversal contain all the nodes in the graph
     * Indirectly
     * and if the traversal contain each node once
     */
    private void complexGraphsContainsAllNodes() throws GraphError {
        Traversal<Integer> g = new DepthFirstTraversal();

        Set<Integer> expectedNodes = new HashSet<>();
        expectedNodes.add(0);
        expectedNodes.add(1);
        expectedNodes.add(2);
        expectedNodes.add(3);
        expectedNodes.add(4);
        expectedNodes.add(5);

        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);

        g.add(0,1);
        g.add(0,3);
        g.add(1,2);
        g.add(2,1);
        g.add(2,5);
        g.add(2,4);
        g.add(4,5);
        g.add(5,4);

        if(!g.getNodes().containsAll(expectedNodes)){
            fail("Your traverse is wrong");
        }
    }


    /**
     * In this test we will have a more complex graph
     * For this type of graph we have many correct traversals
     * In this test we want to check if our traversal contain each node only once
     */
    private void complexGraphsContainsEachNodeOnce() throws GraphError {
        Traversal<Integer> g = new DepthFirstTraversal();

        Set<Integer> expectedNodes = new HashSet<>();
        expectedNodes.add(0);
        expectedNodes.add(1);
        expectedNodes.add(2);
        expectedNodes.add(3);
        expectedNodes.add(4);
        expectedNodes.add(5);

        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);

        g.add(0,1);
        g.add(0,3);
        g.add(1,2);
        g.add(2,1);
        g.add(2,5);
        g.add(2,4);
        g.add(4,5);
        g.add(5,4);

        //If we store our output in a set then we will be sure that there are no repeated nodes
        Set<Integer> actualOutput = new TreeSet<Integer>(g.traverse());

        assertEquals(expectedNodes, actualOutput);

    }


    @Test
    void testSpecificGraph4DepthFirst() throws GraphError {
        specificGraph4DepthFirst();
    }

    @Test
    void testSpecificGraphAdjacentNodes() throws GraphError {
        specificGraphAdjacentNodes();
    }

    @Test
    void testcomplexGraphsContainsAllNodes() throws GraphError {
        complexGraphsContainsAllNodes();
    }

    @Test
    void testComplexGraphsContainsEachNodeOnce() throws GraphError {
        complexGraphsContainsEachNodeOnce();
    }

}