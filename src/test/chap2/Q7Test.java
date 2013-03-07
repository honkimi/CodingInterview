package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Node;
import code.chap2.Q7;

public class Q7Test {
    @Test
    public void test001() {
        int[] datas = { 1, 3, 7, 7, 3, 1 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        boolean ret = Q7.isKaibun(node);
        assertTrue(ret);
    }

    @Test
    public void test002() {
        int[] datas = { 5, 4, 7, 4, 5 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        boolean ret = Q7.isKaibun(node);
        assertTrue(ret);
    }

    @Test
    public void test003() {
        int[] datas = { 5, 4, 7, 4, 3, 4, 7, 4, 5 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        boolean ret = Q7.isKaibun(node);
        assertTrue(ret);
    }

    @Test
    public void test101() {
        int[] datas = { 1, 3, 3, 7, 9, 1, 2 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        boolean ret = Q7.isKaibun(node);
        assertFalse(ret);
    }
    @Test
    public void test102() {
        int[] datas = { 5, 4, 7, 3, 3, 4, 7, 4, 5 };
        code.chap2.Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        boolean ret = Q7.isKaibun(node);
        assertFalse(ret);
    }
}
