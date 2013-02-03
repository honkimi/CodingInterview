package test.chap1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap1.Q1;

public class Q1Test {

    @Test
    public void test011() {
        assertTrue(Q1.isUnique("aiueo"));
    }

    @Test
    public void test012() {
        assertTrue(Q1.isUnique("kKiuUytagh15"));
    }

    @Test
    public void test013() {
        assertTrue(Q1.isUnique("123456789[@p]\""));
    }

    @Test
    public void test911() {
        assertFalse(Q1.isUnique("aiueokakikukeko"));
    }

    @Test
    public void test912() {
        assertFalse(Q1.isUnique("112235786342"));
    }

    @Test
    public void test913() {
        assertFalse(Q1.isUnique("[@@p:][fjlgawl"));
    }

    @Test
    public void test021() {
        assertTrue(Q1.isUnique2("aiueo"));
    }

    @Test
    public void test022() {
        assertTrue(Q1.isUnique2("kKiuUytagh15"));
    }

    @Test
    public void test023() {
        assertTrue(Q1.isUnique2("123456789[@p]\""));
    }

    @Test
    public void test921() {
        assertFalse(Q1.isUnique2("aiueokakikukeko"));
    }

    @Test
    public void test922() {
        assertFalse(Q1.isUnique2("112235786342"));
    }

    @Test
    public void test923() {
        assertFalse(Q1.isUnique2("[@@p:][fjlgawl"));
    }
}
