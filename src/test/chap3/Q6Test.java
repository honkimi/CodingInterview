package test.chap3;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap3.Q6;
import code.chap3.Stack;

public class Q6Test {

    @Test
    public void test() {

        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(6);
        stack.push(4);

        //Stack ret = Q6.sortStack(stack);
        Stack ret = Q6.sort(stack);

        assertEquals(ret.pop(), 1);
        assertEquals(ret.pop(), 3);
        assertEquals(ret.pop(), 4);
        assertEquals(ret.pop(), 5);
        assertEquals(ret.pop(), 6);
        assertEquals(ret.pop(), 8);
    }

}
