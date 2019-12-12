package linkedList.list;

import linkedList.node.ListNode;
import linkedList.node.SingleLinkNode;

public class SingleLinkList <T> extends BasicList<SingleLinkNode<T>, T> implements List<T> {

    private int size;

    private void incrementSize(){
        size++;
    }

    private void decreaseSize(){
        size--;
    }

    private int getSize(){
       return size;
    }

    @Override
    public void add(int index, T value) throws ListAccessError {
        SingleLinkNode<T> nodeCurrent = getRoot();
        SingleLinkNode<T> prev = null;
        int counter = 0;

        if(isEmpty()){
            nodeCurrent = new SingleLinkNode<T>(value, null);
            setRoot(nodeCurrent);
        }


        if(nodeCurrent != null){

            if(index == 0){
                SingleLinkNode<T> nodeTemp = new SingleLinkNode<T>(value, nodeCurrent);
                setRoot(nodeTemp);

                incrementSize();
            }else{
                while(nodeCurrent != null) {
                    if (counter == index) {
                        SingleLinkNode<T> nodeTemp = new SingleLinkNode<T>(value, nodeCurrent);
                        prev.setNext(nodeTemp);
                        incrementSize();
                        break;
                    } else {
                        prev = nodeCurrent;
                        nodeCurrent = nodeCurrent.getNext();
                        counter++;
                    }

                }
            }

        }

    }

    @Override
    public T remove(int index) throws ListAccessError {
        SingleLinkNode<T> nodeCurrent = getRoot();
        SingleLinkNode<T> prev = null;
        int counter = 0;
        T removedValue = null;

        if(index < 0 || index >= getSize()){
            throw new ListAccessError("Index out of bounds");
        }

        if(index == 0 && nodeCurrent != null){
            setRoot(nodeCurrent.getNext());
        }

        while(nodeCurrent != null){
            if(counter == index){
                removedValue = nodeCurrent.getValue();
                if(prev != null){
                    prev.setNext(nodeCurrent.getNext());
                }
                break;
            }else{
                prev = nodeCurrent;
                nodeCurrent = nodeCurrent.getNext();
                counter++;
            }
        }

        return  removedValue;
    }

    @Override
    public T get(int index) throws ListAccessError {
        SingleLinkNode<T> nodeCurrent = getRoot();

        if(index < 0 || index >= getSize()){
            throw new ListAccessError("Index out of bounds");
        }

        if(index == 0){
            return nodeCurrent.getValue();
        }else{
            for (int i = 0; i < index ; i++) {
                nodeCurrent = nodeCurrent.getNext();
            }
            return nodeCurrent.getValue();
        }

    }
}
