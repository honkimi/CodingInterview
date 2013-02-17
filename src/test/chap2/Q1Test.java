package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Q1;
import code.chap2.Q1.Node;

public class Q1Test {

    @Test
    public void test001() {
        int[] datas = { 1, 3, 3, 7, 9, 1, 2};
        Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        node = Q1.uniq(node);

        assertEquals(node.data, 3);
        assertEquals(node.next.data, 7);
        assertEquals(node.next.next.data, 9);
        assertEquals(node.next.next.next.data, 1);
        assertEquals(node.next.next.next.next.data, 2);
    }

    public void test002() {
        int[] datas = { 1, 2, 3, 4, 9, 1, 2};
        Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        node = Q1.uniq(node);

        assertEquals(node.data, 3);
        assertEquals(node.next.data, 7);
        assertEquals(node.next.next.data, 9);
        assertEquals(node.next.next.next.data, 1);
        assertEquals(node.next.next.next.next.data, 2);
    }
}
