package graph;

public class Main {
    public static void main(String[] args) throws GraphError {
        Graph<Integer> refSort = new ReferenceCountingSort<Integer>();

//        refSort.add(0);
//        refSort.add(1);
//        refSort.add(2);
//        refSort.add(3);
//        refSort.add(4);
//        refSort.add(5);
//        refSort.add(6);
//        refSort.add(7);
//        refSort.add(8);
//        refSort.add(9);
//
//        refSort.add(0,1);
//        refSort.add(0,5);
//        refSort.add(1,7);
//        refSort.add(3,2);
//        refSort.add(3,4);
//        refSort.add(3,8);
//        refSort.add(6,0);
//        refSort.add(6,1);
//        refSort.add(6,2);
//        refSort.add(8,4);
//        refSort.add(8,7);
//        refSort.add(9,4);


//        refSort.add(2);
//        refSort.add(3);
//        refSort.add(5);
//        refSort.add(7);
//        refSort.add(8);
//        refSort.add(9);
//        refSort.add(10);
//        refSort.add(11);
//
//        refSort.add(3,8);
//        refSort.add(3,10);
//        refSort.add(5,11);
//        refSort.add(7,11);
//        refSort.add(7,8);
//        refSort.add(8,9);
//        refSort.add(11,2);
//        refSort.add(11,9);
//        refSort.add(11,10);

        for(Integer item : ((ReferenceCountingSort<Integer>) refSort).getSort()){
            System.out.print(item + ",");
        }
    }
}
