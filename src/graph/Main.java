package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws GraphError {
        Graph g = new DepthFirstTraversal();

        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);

        g.add(0,1);
        g.add(1,0);
        g.add(3,2);
        g.add(2,3);


        System.out.println("Following is the Depth First Traversal");
        List<Integer> list = ((DepthFirstTraversal) g).traverse();

        for(Integer item : list){
            System.out.println(item);
        }

    }
}
