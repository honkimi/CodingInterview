package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Node;
import code.chap2.Q6;

public class Q6Test {

    @Test
    public void test001() {
        int[] datas = { 1, 3, 7, 9, 3, 4 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }
        Node head = node;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head.next.next.next;
        node = node.next;

        Node ret = Q6.findPeriodicalNode(node);
        assertEquals(ret.data, 9);
    }

    @Test
    public void test002() {
        int[] datas = { 1, 3, 7, 9, 3, 4 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }
        Node head = node;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head.next.next;
        node = node.next;

        Node ret = Q6.findPeriodicalNode(node);
        assertEquals(ret.data, 7);
    }

     @Test
    public void test902() {
        int[] datas = { 1, 3, 7, 9, 3, 4 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        Node ret = Q6.findPeriodicalNode(node);
        assertNotNull(ret);
    }
}
