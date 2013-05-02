package test.chap4;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap4.GraphNode;

public class Q2Test {

    @Test
    public void test() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node1.addToNode(node3);
        node1.addToNode(node2);

        node2.addToNode(node4);
        node3.addToNode(node4);
        node4.addToNode(node1);

    }

}
