package test.chap4;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap4.Q3;
import code.chap4.TreeNode;

public class Q3Test {

    @Test
    public void test01() {

        int data[] = { 1, 2, 3, 4, 5, 6, 7 };

        TreeNode ret = Q3.makeBinTree(data);

        assertEquals(ret.data, 4);
        assertEquals(ret.left.data, 2);
        assertEquals(ret.left.left.data, 1);
        assertEquals(ret.left.right.data, 3);
        assertEquals(ret.right.data, 6);
        assertEquals(ret.right.left.data, 5);
        assertEquals(ret.right.right.data, 7);
    }

    @Test
    public void test02() {

        int data[] = { 1, 2 };

        TreeNode ret = Q3.makeBinTree(data);

        assertEquals(ret.data, 2);
        assertEquals(ret.left.data, 1);
    }

    @Test
    public void test03() {

        int data[] = { 1, 2, 3, 4 };

        TreeNode ret = Q3.makeBinTree(data);

        assertEquals(ret.data, 3);
        assertEquals(ret.left.data, 2);
        assertEquals(ret.left.left.data, 1);
        assertEquals(ret.right.data, 4);
    }


    @Test
    public void test04() {

        int data[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        TreeNode ret = Q3.makeBinTree(data);

        assertEquals(ret.data, 5);
        assertEquals(ret.left.data, 3);
        assertEquals(ret.left.left.data, 2);
        assertEquals(ret.left.left.left.data, 1);
        assertEquals(ret.left.right.data, 4);
        assertEquals(ret.right.data, 7);
        assertEquals(ret.right.left.data, 6);
        assertEquals(ret.right.right.data, 8);
    }
}
