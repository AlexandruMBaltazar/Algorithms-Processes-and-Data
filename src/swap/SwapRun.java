package swap;

public class SwapRun {

    public static void main(String[] args) {

        String[] myArray = {"Tony","Andrew","Hugh","Diane","Simon","Gary"};

        myArray =  Swap.swap(myArray,1,4);

        for ( String element : myArray) {
            System.out.println(element);
        }

    }
}
