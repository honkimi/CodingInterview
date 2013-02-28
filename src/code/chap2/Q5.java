package code.chap2;

import java.util.LinkedList;
import java.util.List;

/**
 * 各ノードの要素が1桁の数である連結リストで表された2つの数があります。一の位がリストの先頭になるように、
 * 各位の数は逆順に並んでいます。このとき2つの数の和を求め、それを連結リストで表したものを返す関数を書いてください。 例： 入力: (7 -> 1 ->
 * 6) + (5 -> 9 -> 2) -> 617 + 295 結果: 2 -> 1 -> 9 -> 912
 *
 * 発展問題 上位の桁から順方向に連結されたリストを用いて、同様に解いてみてください。 例: 入力: ( 6 -> 1 -> 7) + (2 -> 9 ->
 * 5) -> 617 + 295 出力: 9 -> 1 -> 2 -> 912
 *
 * @author kiminari.homma
 *
 */
public class Q5 {

    static class AddNum {
        public int addNext;
        public int ret;
    }

    public static Node add(Node node1, Node node2) {
        AddNum added = add1dig(node1.data, node2.data, 0);
        Node node = new Node(added.ret);
        Node head = node;
        int num1, num2;
        while (node1 != null || node2 != null) {
            node1 = tryNext(node1);
            node2 = tryNext(node2);
            num1 = tryGetData(node1);
            num2 = tryGetData(node2);
            if (num1 == 0 && num2 == 0) {
                break;
            }
            added = add1dig(num1, num2, added.addNext);
            node.appendToTail(added.ret);
            node = node.next;
        }
        if (added.addNext == 1) {
            node.appendToTail(added.addNext);
        }

        return head;
    }

    public static Node add2(Node node1, Node node2) {
        node1 = reverse(node1);
        node2 = reverse(node2);
        Node ret = add(node1, node2);
        return reverse(ret);
    }

    /**
     * 1桁足し算。
     *
     * @param n1
     *            数1
     * @param n2
     *            数2
     * @param addition
     *            下の位から上がってきたもの
     * @return
     */
    private static AddNum add1dig(int n1, int n2, int addition) {
        int ret = n1 + n2 + addition;
        AddNum num = new AddNum();
        if (ret < 10) {
            num.addNext = 0;
            num.ret = ret;
        } else {
            num.addNext = 1;
            num.ret = ret - 10;
        }
        return num;
    }

    private static Node tryNext(Node node) {
        if (node == null) {
            return null;
        }
        return node.next;
    }
    private static int tryGetData(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data;
    }

    private static Node reverse(Node node) {
        List<Integer> dataList = new LinkedList<Integer>();
        while (node != null) {
            dataList.add(node.data);
            node = node.next;
        }
        Node ret = new Node(dataList.get(dataList.size() - 1));
        for (int i = dataList.size() -2; i >= 0; i--) {
            ret.appendToTail(dataList.get(i));
        }
        return ret;
    }
}
