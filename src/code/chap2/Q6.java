package code.chap2;

import java.util.ArrayList;
import java.util.List;

/**
 * 循環する連結リストが与えられたとき、循環する部分の最初のノードを返すアルゴリズムを実装してください。
 * 定義
 *   循環を含む連結リスト：連結リストAではループを作るために、リスト内のノードの次へのポインタが以前に出現した
 *   ノードを挿している。
 * 例
 *  入力： A -> B -> C -> D -> E -> [最初のC と同じもの]
 *  出力： C
 * @author kiminari.homma
 *
 */
public class Q6 {

    public static Node findPeriodicalNode(Node node) {
        List<Node> nodeList = new ArrayList<Node>();
        while (node.next != null) {
            nodeList.add(node);
            for (Node n : nodeList) {
                if (n == node) {
                    return node;
                }
            }
            node = node.next;
        }

        return null;
    }
}
