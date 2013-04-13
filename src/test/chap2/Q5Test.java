package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Node;
import code.chap2.Q5;

public class Q5Test {

    @Test
    public void test001() {
        int[] data1 = { 7, 1, 6 };
        int[] data2 = { 5, 9, 2 };
        Node node1 = new Node(data1[0]);
        Node node2 = new Node(data2[0]);

        for (int i = 1; i < data1.length; i++) {
            node1.appendToTail(data1[i]);
        }
        for (int i = 1; i < data2.length; i++) {
            node2.appendToTail(data2[i]);
        }

        Node ret = Q5.add(node1, node2);

        assertEquals(ret.data, 2);
        assertEquals(ret.next.data, 1);
        assertEquals(ret.next.next.data, 9);
    }

     @Test
    public void test002() {
        int[] data1 = { 7, 1, 9 };
        int[] data2 = { 5, 9, 2 };
        Node node1 = new Node(data1[0]);
        Node node2 = new Node(data2[0]);

        for (int i = 1; i < data1.length; i++) {
            node1.appendToTail(data1[i]);
        }
        for (int i = 1; i < data2.length; i++) {
            node2.appendToTail(data2[i]);
        }

        Node ret = Q5.add(node1, node2);

        assertEquals(ret.data, 2);
        assertEquals(ret.next.data, 1);
        assertEquals(ret.next.next.data, 2);
        assertEquals(ret.next.next.next.data, 1);
    }

     @Test
    public void test003() {
        int[] data1 = { 7, 1, 9, 3 };
        int[] data2 = { 5, 9, 2 };
        Node node1 = new Node(data1[0]);
        Node node2 = new Node(data2[0]);

        for (int i = 1; i < data1.length; i++) {
            node1.appendToTail(data1[i]);
        }
        for (int i = 1; i < data2.length; i++) {
            node2.appendToTail(data2[i]);
        }

        Node ret = Q5.add(node1, node2);

        assertEquals(ret.data, 2);
        assertEquals(ret.next.data, 1);
        assertEquals(ret.next.next.data, 2);
        assertEquals(ret.next.next.next.data, 4);
    }

    @Test
    public void test101() {
        int[] data1 = { 2, 1, 6 };
        int[] data2 = { 5, 9, 2 };
        Node node1 = new Node(data1[0]);
        Node node2 = new Node(data2[0]);

        for (int i = 1; i < data1.length; i++) {
            node1.appendToTail(data1[i]);
        }
        for (int i = 1; i < data2.length; i++) {
            node2.appendToTail(data2[i]);
        }

        Node ret = Q5.add2(node1, node2);

        assertEquals(ret.data, 8);
        assertEquals(ret.next.data, 0);
        assertEquals(ret.next.next.data, 8);
    }
}
