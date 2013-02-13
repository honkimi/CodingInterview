package test.chap1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.chap1.Q6;

public class Q6Test {

    @Test
    public void test001() {
        final int size = 5;
        Q6.Pixcel[][] rect = new Q6.Pixcel[size][size];
        Q6 q6 = new Q6();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rect[i][j] = q6.new Pixcel(i, j);
            }
        }

        Q6.rotateRect(rect);

        assertEquals(rect[0][0].width, 0);
        assertEquals(rect[0][0].height, 4);
        assertEquals(rect[1][0].width, 0);
        assertEquals(rect[1][0].height, 3);
        assertEquals(rect[3][2].width, 2);
        assertEquals(rect[3][2].height, 1);
        assertEquals(rect[2][2].width, 2);
        assertEquals(rect[2][2].height, 2);
        assertEquals(rect[4][1].width, 1);
        assertEquals(rect[4][1].height, 0);
    }

    @Test
    public void test002() {
        final int size = 3;
        Q6.Pixcel[][] rect = new Q6.Pixcel[size][size];
        Q6 q6 = new Q6();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rect[i][j] = q6.new Pixcel(i, j);
            }
        }

        Q6.rotateRect(rect);

        assertEquals(rect[0][0].width, 0);
        assertEquals(rect[0][0].height, 2);
        assertEquals(rect[2][1].width, 1);
        assertEquals(rect[2][1].height, 0);
        assertEquals(rect[0][2].width, 2);
        assertEquals(rect[0][2].height, 2);

    }

}
