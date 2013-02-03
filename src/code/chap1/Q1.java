package code.chap1;

import java.util.HashMap;
import java.util.Map;

/**
 * ある文字列が、全てユニークである(重複する文字がない)かどうかを判定するアルゴリズムを実装してください。
 * また、それを実装するのに新たなデータ構造が使えない場合、どのようにすればよいですか？
 * @author kimi
 */
public class Q1 {
    public static boolean isUnique(String str) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        String ch;
        for(int i = 0; i < str.length(); i++) {
            ch = String.valueOf(str.charAt(i));
            if (map.containsKey(ch)) {
                return false;
            }
            map.put(ch, 1);
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        String ch1, ch2;

        for (int i = 0; i < str.length(); i++) {
            ch1 = String.valueOf(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                ch2 = String.valueOf(str.charAt(j));
                if (ch1.equals(ch2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
