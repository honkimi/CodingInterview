package code.chap2;


/**
 * ソートされていない連結リストから、重複する要素を削除する コードを書いてください。
 *
 * 発展問題 もし、一時的なバッファが使用できないとすれば、 どうやってこの問題を解きますか？
 *
 * @author kimi
 *
 */
public class Q1 {

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

        public static Node deleteNode(Node head, int d) {
            Node n = head;

            if (n.data == d) {
                return head.next;
            }

            while (n.next != null) {
                if (n.next.data == d) {
                    n.next = n.next.next;
                    return head;
                }
                n = n.next;
            }
            return head;
        }
    }

    /**
     * 2つのポインタを用いて重複があれば先頭のを削除
     * @param node 対象Node
     * @return データがユニークなNode
     */
    public static Node uniq(Node node) {
        Node node1 = node;
        Node node2;

        while (node1 != null) {
            node2 = node1.next;
            while (node2 != null) {
                if (node1.data == node2.data) {
                    node = Node.deleteNode(node, node1.data);
                }
                node2 = node2.next;
            }

            node1 = node1.next;
        }
        return node;
    }
}
