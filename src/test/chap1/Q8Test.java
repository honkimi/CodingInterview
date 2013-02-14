package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q8;

public class Q8Test {

    @Test
    public void test() {
        assertTrue(Q8.isRotatedString("waterbottle", "erbottlewat"));
    }

}
