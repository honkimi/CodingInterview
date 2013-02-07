package code.chap1;

/**
 * 文字の連続する数を使って基本的な文字列圧縮を行うメソッドを実装してください。
 * たとえば、「aabcccccaaa」は「a2b1c5a3」のようにしてください。もし、圧縮変換された文字列
 * が元の文字列よりも短くならなかった場合は、元の文字列を返してください。
 *
 * @author kiminari.homma
 *
 */
public class Q5 {

    public static String strCompress(String str) {
        if (str.length() <= 1)
            return str;

        StringBuffer ret = new StringBuffer();
        char currentChr = str.charAt(0);

        int sameCharCnt = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChr) {
                sameCharCnt++;
            } else {
                ret.append(currentChr).append(sameCharCnt);
                sameCharCnt = 1;
                currentChr = str.charAt(i);
            }
        }
        //最後の文字列の状態を追加
        ret.append(currentChr).append(sameCharCnt);

        if (str.length() <= ret.length()) {
            return str;
        }

        return ret.toString();
    }
}
