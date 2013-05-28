package code.chap4;

/**
 * Node for Tree. Objectå^
 * @author kiminari.homma
 *
 */
public class Node {
    public Object data;
    public Node next = null;

    public Node(Object d) {
        this.data = d;
    }

    public void appendToTail(Object d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static Node deleteNode(Node head, Object d) {
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

    public String toString() {
        return "data: " + this.data;
    }
}
