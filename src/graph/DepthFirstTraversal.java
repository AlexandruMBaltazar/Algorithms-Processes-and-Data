package graph;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

    @Override
    public List<T> traverse() throws GraphError {

        //Stores all the nodes in our graph
        Set<T> allNodes = this.getNodes();

        //Stores our visited nodes
        List<T> visitedNodes = new ArrayList<T>(this.getNoOfNodes());

        //We are getting the first node in our graph
        T currentNode = this.getNodes().iterator().next();

        //We are creating a stack in order to store the nodes we need to visit
        Stack<T> backTrack = new Stack<T>();
        backTrack.push(currentNode);


        while(!backTrack.isEmpty()){
            //We are getting a node from the stack and store it as a current node
            currentNode = backTrack.peek();
            backTrack.pop();

            /*
                Now we need to check if we've already visited this node
                If we haven't then store in the visited nodes list
             */
            if(!visitedNodes.contains(currentNode)){
                visitedNodes.add(currentNode);
                allNodes.remove(currentNode);
            }

            //We will store the neighbours of the current node here
            Set<T> nodeNeighbours = this.getNeighbours(currentNode);

            //If our neighbour nodes have not been visited yet place them in the stack
            for(T item : nodeNeighbours){
                if (!visitedNodes.contains(item)){
                    backTrack.push(item);
                }
            }

            if(backTrack.isEmpty() && !allNodes.isEmpty()){
                backTrack.push(allNodes.iterator().next());
            }
        }

        return visitedNodes;
    }
}
