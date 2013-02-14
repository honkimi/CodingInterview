package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q7;

public class Q7Test {

    @Test
    public void test001() {
        int[] a = { 1, 2, 3, 0 };
        int[] b = { 4, 5, 6, 4 };

        int[][] rect = { a, b };

        Q7.setZeroBom(rect);

        assertEquals(0, rect[0][0]);
        assertEquals(0, rect[0][1]);
        assertEquals(0, rect[0][2]);
        assertEquals(0, rect[1][3]);
        assertEquals(5, rect[1][1]);
    }

    @Test
    public void test002() {
        int[] a = { 1, 2, 3, 3 };
        int[] b = { 4, 5, 1, 4 };
        int[] c = { 4, 0, 6, 0 };
        int[] d = { 4, 5, 6, 4 };

        int[][] rect = { a, b, c, d };

        Q7.setZeroBom(rect);

        assertEquals(4, rect[1][0]);
        assertEquals(0, rect[1][1]);
        assertEquals(1, rect[1][2]);
        assertEquals(0, rect[1][3]);
        assertEquals(4, rect[3][0]);
        assertEquals(0, rect[3][1]);
        assertEquals(6, rect[3][2]);
        assertEquals(0, rect[3][3]);
        assertEquals(0, rect[2][2]);
        assertEquals(3, rect[0][2]);

        assertEquals(1, rect[0][0]);
        assertEquals(0, rect[0][1]);
    }

}
