package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q4;

public class Q4Test extends Q4 {

    @Test
    public void test011() {
        String str      = "Mr John Smith     ";
        String expected = "Mr%20John%20Smith";

        assertEquals(expected, Q4.encodeSpace(str));
    }
}
