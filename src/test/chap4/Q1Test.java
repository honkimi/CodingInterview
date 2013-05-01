package test.chap4;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap4.Q1;
import code.chap4.Tree;

public class Q1Test {

    @Test
    public void testTrue() {
        Tree tree = new Tree(0);

        tree.current.appendLeft(1);
        tree.current.appendRight(2);
        tree.moveLeft();
        tree.current.appendLeft(3);
        tree.current.appendRight(4);

        boolean ret = Q1.isBalancedTree(tree);
        assertTrue(ret);
    }

    @Test
    public void testFalse() {
        Tree tree = new Tree(0);

        tree.current.appendLeft(1);
        tree.current.appendRight(2);
        tree.moveLeft();
        tree.current.appendLeft(3);
        tree.current.appendRight(4);
        tree.moveLeft();
        tree.current.appendLeft(5);

        boolean ret = Q1.isBalancedTree(tree);
        assertFalse(ret);
    }
}
