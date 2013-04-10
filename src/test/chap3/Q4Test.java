package test.chap3;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap3.Q4;

public class Q4Test {

    @Test
    public void test() {
        Q4 q4 = new Q4();

        int n = 4;

        Q4.Tower[] towers = new Q4.Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = q4.new Tower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        assertEquals((int) towers[2].disks.peek(), 0);
        assertTrue(towers[0].disks.isEmpty());
    }

}
