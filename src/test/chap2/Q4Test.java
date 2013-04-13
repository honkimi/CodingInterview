package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Node;
import code.chap2.Q4;

public class Q4Test {

    @Test
    public void test() {
        int[] datas = { 1, 3, 7, 9, 3, 4 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }
        node = Q4.swapLinkedList(node, 5);

        assertTrue(node.data < 5);
        assertTrue(node.next.data < 5);
        assertTrue(node.next.next.data < 5);
        assertTrue(node.next.next.next.data < 5);
        assertTrue(node.next.next.next.next.data > 5);
        assertTrue(node.next.next.next.next.next.data > 5);
    }
}
