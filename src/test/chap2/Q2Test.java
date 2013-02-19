package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Q2;
import code.chap2.Q2.Node;


public class Q2Test {

    @Test
    public void test() {
        int[] datas = { 1, 3, 3, 7, 9, 1, 2 };
        Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        int ret = Q2.findFromTail(node, 2);
        assertEquals(1, ret);

        ret = Q2.findFromTail(node, 5);
        assertEquals(3, ret);

        ret = Q2.findFromTail(node, 10);
        assertEquals(-1, ret);
    }

}
