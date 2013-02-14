package code.chap1;

/**
 * NxNの行列に描かれた、1つのピクセルが4バイト四方の画像があります。その画像を90度開店させるメソッド
 * を書いてください。あなたはこれを追加の領域なしでできますか？
 * @author kiminari.homma
 *
 */
public class Q6 {

    public class Pixcel {
        public int width;
        public int height;

        public Pixcel (int width, int height) {
            this.width = width;
            this.height = height;
        }

        public String toString() {
            return "width: " + width + ", height: " + height;
        }
    }

    public static Pixcel[][] rotateRect(Pixcel[][] rect) {
        if (!isNxN(rect)) {
            return null;
        }
        int size = rect.length;
        int lastIdx = size - 1;

        for (int i = 0; i < (size + 1) / 2; i++) {
            for (int j = 0; j < (size + 1) / 2 - 1; j ++) {
                Pixcel swap = rect[i][j];
                rect[i][j] = rect[j][lastIdx-i];
                rect[j][lastIdx-i] = rect[lastIdx-i][lastIdx-j];
                rect[lastIdx-i][lastIdx-j] = rect[lastIdx-j][i];
                rect[lastIdx-j][i] = swap;
            }
        }
        return rect;
    }

    private static boolean isNxN(Object[][] rect) {
        int size = rect.length;
        for (int i =0; i < rect.length; i++) {
            if (size != rect[i].length) {
                return false;
            }
        }
        return true;
    }

}
