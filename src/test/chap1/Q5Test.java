package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q5;

public class Q5Test {

    @Test
    public void test001() {
        String str = "aabcccccaaa";
        String exp = "a2b1c5a3";

        assertEquals(exp, Q5.strCompress(str));
    }

    @Test
    public void test002() {
        String str = "abbcccddddeeeeeffffff";
        String exp = "a1b2c3d4e5f6";

        assertEquals(exp, Q5.strCompress(str));
    }

    @Test
    public void test003() {
        String str = "zfkgljaghhghgala";
        String exp = "zfkgljaghhghgala";

        assertEquals(exp, Q5.strCompress(str));
    }

    @Test
    public void test011() {
        String str = "abcdefg";
        String exp = "abcdefg";

        assertEquals(exp, Q5.strCompress(str));
    }

    @Test
    public void test012() {
        String str = "";
        String exp = "";

        assertEquals(exp, Q5.strCompress(str));
    }

    @Test
    public void test013() {
        String str = "l";
        String exp = "l";

        assertEquals(exp, Q5.strCompress(str));
    }
}
