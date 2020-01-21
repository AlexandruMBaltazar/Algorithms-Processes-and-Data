package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Perform a depth first topological sort on a graph.
 *
 * This version is slightly different from the one presented in the lecture, as that version did not properly identify
 * cyclic graphs.
 *
 * @author Hugh Osborne
 * @version December 2019
 */

public class DepthFirstSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {

    Stack<T> sort; // contains the sort
    Set<T> visiting = new HashSet<T>(); // nodes that are being visited, but not yet added to the sort

    @Override
    /**
     * Perform a topological sort on the graph.
     * Note: a Java Stack, somewhat counterintuitively, has the top of the stack (the most recent
     * addition) as the rightmost entry when listed.  To achieve the ordering we want it is necessary
     * to reverse the final result.
     */
    public List<T> getSort() throws GraphError {
        sort = new Stack<T>(); // start a new sort
        for (T node: getNodes()) {
            visitNode(node);
        }
        if (sort.size() != getNodes().size()) { // if not all of the nodes are in the sort
            throw new GraphError("Cannot get topological sort.  Graph is not acyclic.");
        } else {
            Collections.reverse(sort); // reverse the sort to have the top entry at the left
            return sort;
        }
    }

     /**
     * Visit a node by adding it to the traversal, and then recursively visiting all its neighbours.
     * @param node the node to be visited
     * @throws GraphError if the graph is not acyclic, or if if the node does not exist in this graph
     */
    private void visitNode(T node) throws GraphError {
        if (sort.contains(node)) { // If the node is already in the sort ...
            return; // ... there is no need to visit it again.
        }
        if (visiting.contains(node)) { // This node is already somewhere on the current depth first path, so following
                                       // links from this node has led us back to the same node.  The graph is
                                       // therefore cyclic, and a topological sort is impossible.
            throw new GraphError("Cannot get topological sort.  Graph is not acyclic.");
        }
        visiting.add(node); // We are now visiting this node.  It will be added to the sort once all its
                            // descendants have been visited and added to the sort.
        for (T neighbour: getNeighbours(node)) { // Continue the sort recursively in all the node's neighbours...
            visitNode(neighbour); // ...so that all its descendants are added to the sort before it is
        }
        sort.push(node); // Add this node to the front of the traversal now that all its descendants have been added.
        visiting.remove(node); // Also remove it from the visiting list, as the visit is no complete.
    }
}