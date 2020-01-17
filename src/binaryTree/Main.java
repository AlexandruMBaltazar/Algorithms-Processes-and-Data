package binaryTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Integer[] array = {7,5,4,6,7,10,9,11};


        for(Integer element : array){
            binaryTree.insert(element);
        }

        for (Integer value : binaryTree.traverse()){
            System.out.print(value + ", ");
        }
    }
}
