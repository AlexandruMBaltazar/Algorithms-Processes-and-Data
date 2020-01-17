package binaryTree;

import arrayGenerator.generator.IntegerArrayGenerator;
import arrayGenerator.scope.IntegerScope;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest extends BTreeTest {

    @Override
    protected BTree createBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        return binaryTree;
    }
}