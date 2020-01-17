package binaryTree;

import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A partial implementation of sorted binary trees.
 * <p>
 * The three constructors (construct an empty tree ({@link #BinaryTree()}, or a tree with a root value but no subtrees
 * ({@link #BinaryTree(Comparable)}, or a tree with a root value and left and right subtrees
 * ({@link #BinaryTree(Comparable, BinaryTree, BinaryTree)}), as well as the {@link #isEmpty()} method are already implemented.
 * <p>
 * For the remaining methods specified in the {@link BTree} interface ({@link #insert(Comparable)}, {@link #getValue()},
 * {@link #setValue(Comparable)}, {@link #getLeft()}, {@link #setLeft(BTree)}, {@link #getRight()}, {@link #setRight(BTree)},
 * {@link #contains(Comparable)}, and {@link #traverse()}) only a "stub" is provided.  For the logbook exercise you
 * should implement these methods.
 * <p>
 * Don't forget to test your implementation!
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root; 

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     * @param value the value to be stored in the root of the tree.
     * @param left the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value,BinaryTree<T> left,BinaryTree<T> right) {
        root = new TreeNode<>(value,left,right);
    }

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) {
        //This is the node we try to insert
        TreeNode<T> insertedNode = new TreeNode<T>(value);

        /*
            If the tree is empty then our node becomes the root
            else our current node is the root
         */
        if (root == null){
            root = insertedNode;
        }else{
            TreeNode<T> currentNode = root;
            TreeNode<T> parent = null;

            //Traverse the tree
            while(true){
                parent = currentNode;
                /*
                    If our inserted node data is less than the current node data then
                    get the root node of the left subtree of the current node.
                    If this node is null then place your inserted node here.
                 */
                if(insertedNode.getValue().compareTo(currentNode.getValue()) < 0){
                    currentNode = currentNode.getLeft().getRoot();

                    if(currentNode==null){
                        parent.getLeft().setRoot(insertedNode);
                        break;
                    }
                }else {
                    /*
                    If our inserted node data is higher than the current node data then
                    get the root node of the right subtree of the current node.
                    If this node is null then place your inserted node here.
                    */
                    currentNode = currentNode.getRight().getRoot();
                    if(currentNode ==null){
                        parent.getRight().setRoot(insertedNode);
                        break;
                    }
                }

            }
        }

    }

    /**
     * Get the root of the tree.
     * @return the root of the tree.
     */
    public TreeNode<T> getRoot (){
        return root;
    }

    /**
     * Set the root of the tree.
     */
    public void setRoot(TreeNode<T> root){
        this.root = root;
    }
    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */
    public T getValue() {
        T value = root.getValue();

        return value;
    }

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) {
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    public BTree<T> getLeft() {
        BTree<T> left = root.getLeft();
        return left;
    }

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) {
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() {
        BTree<T> right = root.getRight();
        return right;
    }

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) {
        TreeNode<T> currentNode = root;
        while (currentNode != null){
            if(currentNode.getValue() == value){
                return true;
            }else if (currentNode.getValue().compareTo(value) > 0){
                currentNode = currentNode.getLeft().getRoot();
            }else{
                currentNode = currentNode.getRight().getRoot();
            }

        }

        return false;
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() {

        List<T> treeValueList = new ArrayList<T>();

        if (root != null){
            Stack<TreeNode<T>> treeNodeStack = new Stack<TreeNode<T>>();
            TreeNode<T> currentNode = root;

            // traverse the tree
            while (currentNode != null || treeNodeStack.size() > 0)
            {

            /* Reach the left most Node of the
            curr Node */
                while (currentNode !=  null)
                {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                    treeNodeStack.push(currentNode);
                    currentNode = currentNode.getLeft().getRoot();
                }

                /* Current must be NULL at this point */
                currentNode = treeNodeStack.pop();

                treeValueList.add(currentNode.getValue());

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
                currentNode = currentNode.getRight().getRoot();
            }
        }
        return treeValueList;
    }


}

