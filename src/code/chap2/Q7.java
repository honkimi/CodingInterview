package code.chap2;

/**
 * 連結リストが回文（先頭から巡回しても末尾から巡回しても、各ノードの要素が全く同じになっている）かどうかを
 * 調べる関数を実装してください。
 * @author kiminari.homma
 *
 */
public class Q7 {

    public static boolean isKaibun(Node node) {
        Node tail, head, runner;
        tail = node;
        head = node;
        runner = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        if (tail.data != head.data) {
            return false;
        }

        while (head.next != tail && head != tail) {
            while (runner.next != tail) {
                runner = runner.next;
            }
            if (head.next.data != runner.data) {
                return false;
            }

            head = head.next;
            tail = runner;
            runner = head;
        }

        return true;
    }
}
