package code.chap1;

import java.util.LinkedList;

/**
 * MxNの行列について、要素が0であれば、その行と列を全て0にするようなアルゴリズムを実装してください。
 *
 * @author kiminari.homma
 *
 */
public class Q7 {

    private static class Position {
        public int width;
        public int height;

        public Position(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static void setZeroBom(int[][] rect) {
        Position[] points = findZeroPosition(rect);

        for (Position position: points) {
            for (int i = 0; i < rect[position.width].length; i++) {
                rect[position.width][i] = 0;
            }
            for (int i = 0; i < rect.length; i++) {
                rect[i][position.height] = 0;
            }
        }
    }

    private static Position[] findZeroPosition(int[][] rect) {
        LinkedList<Position> posList = new LinkedList<Position>();
        for (int i = 0; i< rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                if (rect[i][j] == 0) {
                    posList.add(new Position(i, j));
                }
            }
        }

        return (Position[]) posList.toArray(new Position[posList.size()]);
    }
}
