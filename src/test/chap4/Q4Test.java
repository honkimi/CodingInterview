package test.chap4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import code.chap4.Node;
import code.chap4.Q4;
import code.chap4.TreeNode;

public class Q4Test {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(0);
        root.appendLeft(1);
        root.appendRight(2);
        root.left.appendLeft(3);
        root.left.appendRight(4);
        root.right.appendLeft(5);
        root.right.appendRight(6);

        List<Node> ret = Q4.makeSameDeepNodeInTree(root);
        assertEquals(ret.size(), 3);

        assertEquals((int) ret.get(0).data, 0);
        assertEquals((int) ret.get(1).data, 1);
        assertEquals((int) ret.get(1).next.data, 2);
        assertEquals((int) ret.get(2).data, 3);
        assertEquals((int) ret.get(2).next.data, 4);
        assertEquals((int) ret.get(2).next.next.data, 5);
        assertEquals((int) ret.get(2).next.next.next.data, 6);
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(0);
        root.appendLeft(1);
        root.appendRight(2);
        root.left.appendLeft(3);
        root.left.appendRight(4);
        root.left.left.appendLeft(5);

        List<Node> ret = Q4.makeSameDeepNodeInTree(root);
        assertEquals(ret.size(), 4);

        assertEquals((int) ret.get(0).data, 0);
        assertEquals((int) ret.get(1).data, 1);
        assertEquals((int) ret.get(1).next.data, 2);
        assertEquals((int) ret.get(2).data, 3);
        assertEquals((int) ret.get(2).next.data, 4);
        assertEquals((int) ret.get(3).data, 5);
    }
}
