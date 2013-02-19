package code.chap2;

/**
 * 単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください
 *
 * @author kiminari.homma
 *
 */
public class Q2 {
    public static class Node {
        public int data;
        public Node next = null;

        public Node(int d) {
            this.data = d;
        }

        public void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    /**
     * 末尾からk番目の要素を返却。1からスタート
     *
     * @param node
     *            Node
     * @param k
     *            後ろからk番目
     * @return data
     */
    public static int findFromTail(Node node, int k) {
        int i = 0;
        Node head = node;
        while (node.next != null) {
            node = node.next;
            i++;
        }
        int idx = i - k + 1;

        if (idx < 0)
            return -1;

        i = 0;
        node = head;
        while (i < idx) {
            node = node.next;
            i++;
        }
        return node.data;
    }
}
