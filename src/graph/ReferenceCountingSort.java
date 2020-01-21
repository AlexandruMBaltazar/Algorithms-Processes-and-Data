package graph;

import java.util.*;

public class ReferenceCountingSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {


    /**
     * Performs reference counting topological sort on the graph.
     @return a topological sort of this graph
     @throws GraphError if the graph is not acyclic
     */
    @Override
    public List<T> getSort() throws GraphError {

        //Here we store our nodes for reference counting topological sort
        List<T> referenceCountingTopologicalSort = new ArrayList<T>();

        int initialNoOfNodes = this.getNoOfNodes();

        for(int i = 0; i < initialNoOfNodes; i++){
            referenceCountingTopologicalSort.add(getNodeWithNoIncomingEdges());
        }


        return referenceCountingTopologicalSort;

    }

    /**
     * This method is use to provide a node with no incoming edges for the reference counting topological sort
     * It works my creating a "table" with the nodes and their reference counter
     * Our topological sort implementation must work on the principle "smallest-numbered available vertex first"
     * As a result we will always get the smallest node available with no incoming edges
     @return T a node with no incoming edges
     @throws GraphError if the graph is not acyclic
     */
    public T getNodeWithNoIncomingEdges() throws GraphError {

        //This will store our nodes together with their reference counter
        HashMap<T, Integer> refCountNodes = new HashMap<T, Integer>(this.getNoOfNodes());


        //Add all nodes with 0 reference counter currently
        for(T node: this.getNodes()){
            refCountNodes.put(node, 0);
        }

        //Find out the reference counter for each vertex
        for(T node : this.getNodes()){ //We get a node from our graph
            if(!this.getNeighbours(node).isEmpty()) {
                Set<T> neighbours = this.getNeighbours(node); //We get the neighbours that the node points to

                for (T neighbour : neighbours) {
                    refCountNodes.replace(neighbour, refCountNodes.get(neighbour) + 1); //We add one incoming edge to each of these neighbours
                }
            }

        }

        //Here we store the nodes with no incoming edges
        TreeSet<T> nodesWithNoIncomingEdges = new TreeSet<T>();

        //We populate our set with nodes with no incoming edges
        for(T node : refCountNodes.keySet()){
            if(refCountNodes.get(node) == 0){
                nodesWithNoIncomingEdges.add(node);
            }
        }

        //We get the first node from the set with no incoming edges
       T node = nodesWithNoIncomingEdges.first();

        nodesWithNoIncomingEdges.remove(node);
        this.remove(node);

        return node;

    }

}
