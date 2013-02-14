package code.chap1;

/**
 * 片方の文字列が、もう片方の文字列の一部分になっているかどうかを調べるメソッド
 * [isSubstring]が使えると仮定します。2つの文字列s1とs2が与えられたとき、isSubsstring
 * メソッドを一度だけ使ってs2がs1を回転させたものかどうかを判定するコードを書いてください。
 * （たとえば、「waterbottle」は「erbottlewat」を回転させたものになっています。)
 * @author kiminari.homma
 *
 */
public class Q8 {

    public static boolean isRotatedString(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        String concated = str1.concat(str1);

        return isSubstring(concated, str2);
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}
