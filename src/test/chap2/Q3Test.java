package test.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap2.Node;
import code.chap2.Q3;

public class Q3Test {

    @Test
    public void test() {
        char[] datas = {'a','b','c','d','e'};
        Node node = new Node(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            node.appendToTail(datas[i]);
        }

        Q3.removeCenterElm(node);

        assertEquals('d', node.next.next.data);
    }

}
