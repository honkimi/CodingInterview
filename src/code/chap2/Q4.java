package code.chap2;

/**
 * ある数xが与えられたとき、連結リストの要素を並び替え、xより小さいものが前に来るようにするコードを 書いてください。
 *
 * @author kiminari.homma
 *
 */
public class Q4 {

    /**
     * Answer 指定したものより低いノードと、高いノードの二つを作り、それを後で連結させる方法。
     *
     * @param node
     * @param x
     */
    public static Node swapLinkedList(Node node, int x) {
        Node underStart = null;
        Node underEnd= null;
        Node upperStart = null;
        Node upperEnd = null;

        while (node != null) {
            if (node.data < x) {
                if (underStart == null) {
                    underStart = new Node(node.data);
                    underEnd = underStart;
                } else {
                    underEnd.next = node;
                    underEnd = underEnd.next;
                }
            } else {
                if (upperStart == null) {
                    upperStart = new Node(node.data);
                    upperEnd = upperStart;
                } else {
                    upperEnd.next = node;
                    upperEnd = upperEnd.next;
                }
            }
            node = node.next;
        }

        underEnd.next = upperStart;
        return underStart;
    }

    /**
     * ギブアップ！ 1つの連結リストで、もし対象ノードが指定した値よりも大きければ、その
     * 値を連結リストの末尾に持ってくるという戦法でいったものの、撃沈。。 ノードの指す方向がぐちゃぐちゃになり、うまく整形できなかった。
     *
     * @param node
     * @param x
     */
    public static void mySwapLinkedList(Node node, int x) {
        Node n1 = node;
        Node n2 = node;

        while (n1.next != null) {
            if (n1.next.data < x) {
                n1 = n1.next;
                continue;
            }
            n2 = n1.next;
            while (n2.next != null) {
                n2 = n2.next;
            }
            Node nextnext = n1.next.next;
            n2.next = n1.next;
            n2.next.next = null;
            n1.next = nextnext;
            n1 = n1.next;
        }

    }
}
