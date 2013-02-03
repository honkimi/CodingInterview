package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q1;

public class Q1Test {

    @Test
    public void testReturnTrue() {
        Q1 obj = new Q1();
        assertTrue(obj.returnTrue());
    }

}
