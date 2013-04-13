package code.chap2;

/**
 * 単方向連結リストにおいて、中央の要素のみアクセス可能であるとします。その要素を削除するアルゴリズムを実装してください。 例 入力： a -> b -> c
 * -> d -> e という連結リストのcが与えられます。 結果： 何も返しませんが、リストは a -> b -> d -> e のように見えます。
 *
 * @author kiminari.homma
 *
 */
public class Q3 {

    /**
     * 問題的には、いきなり中央の要素にアクセスされていること前提で考えてよかったみたい。。
     * 完全に問題の意図とずれてしまってる。
     * @param node Node
     */
    public static void removeCenterElm(Node node) {
        if (node.next == null) {
            //Javaって値渡しだから、nodeの値にnullを入れても、
            //呼び出しもとに影響がでないっぽい。。
            //でもその要素の中身(ポインタの先)の変更は置き換わるようだ。
            //つまり、↓はNG
            node = null;
            return;
        }

        int i = 0;
        Node head = node;
        // Nodeサイズ取得
        while (node.next != null) {
            node = node.next;
            i++;
        }

        // 中央を求める
        int center = i / 2;

        i = 0;
        node = head;
        // 中央に来たら、その要素のnextをnext.nextにセット
        while (node.next != null) {
            if (i == center - 1) {
                node.next = node.next.next;
            }
            node = node.next;
            i++;
        }
    }
}
