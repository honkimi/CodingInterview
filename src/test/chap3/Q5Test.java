package test.chap3;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap3.Q5;
import code.chap3.Q5.MyQueue;

public class Q5Test {

    @Test
    public void test() {
        Q5 q5 = new Q5();
        MyQueue queue = q5.new MyQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        queue.enqueue(4);

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertNull(queue.dequeue());

        queue.enqueue(5);
        assertEquals(5, queue.dequeue());

    }

}
