package codei1.q440;

import java.util.HashMap;
import java.util.Map;

/**
 * 下記の表はユーザとアイテムの評価行列の一例です。(添付に"small.rating"としてデータを出力しています) アイテム1 アイテム2 アイテム3
 * アイテム4 アイテム5 ユーザ1 3 1 2 3 3 ユーザ2 4 3 4 3 5 ユーザ3 3 3 1 5 4 ユーザ4 1 5 5 2 1
 *
 * 上の表において各アイテム1,2,3,4,5について最もコサイン類似度が高いものを出力してください。 出力フォーマットは以下のようにしてください。
 *
 * @author kimi
 *
 */
public class Q1 {
    public static void main(String[] args) {
        RateManager mng = FileManager.fileToRates("resources/small.rating");
        HashMap<Integer, Integer> ret = new CosInSimilarity(mng).calc();

        for (Map.Entry<Integer, Integer> entry : ret.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
