package code.chap1;

/**
 * 文字列内に出現する全ての空白文字を%20で置き換えるメソッドを書いてください。ただし、文字列の後ろには
 * 新たに文字を追加するためのスペースが十分にある（バッファのサイズは気にしなくてもよい）ことと、その追加用
 * スペースを除いた文字列の真の長さが与えられます（注意：Javaで実装する場合は、追加の領域を使用せずに処理 できるよう文字配列を使ってください）。
 *
 * @author kiminari.homma
 *
 */
public class Q4 {

    public static String encodeSpace2(String str) {
        return str.trim().replaceAll(" ", "%20");
    }

    public static String encodeSpace(String str) {
        final int MAX = 256;

        char[] ret = new char[MAX];
        char[] chrs = str.toCharArray();
        int size = str.length();

        for (int i = size - 1; i > 0; i--) {
            if (chrs[i] != ' ') {
                size = i;
                break;
            }
        }

        int retCursor = 0;
        for (int i = 0; i <= size; i++) {
            if (chrs[i] == ' ') {
                ret[retCursor++] = '%';
                ret[retCursor++] = '2';
                ret[retCursor++] = '0';
            } else {
                ret[retCursor++] = chrs[i];
            }
        }

        char[] r = new char[retCursor];
        for (int i = 0; i < retCursor; i++) {
            r[i] = ret[i];
        }

        return String.valueOf(r);
    }
}
