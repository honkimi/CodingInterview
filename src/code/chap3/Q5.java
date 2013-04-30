package code.chap3;

/**
 * MyQueueというクラス名で2つのスタックを用いてキューを実装してください。
 * @author kimi
 *
 * シンプルにバッファー用のスタックを作って、dequeueの時は
 * 一時的にスタックの一番下までbufferに持って行って、一番下のオブジェクトを取り出す。
 * だが、これだと毎回dequeueの度に計算しないといけなくなる。
 *
 * これの対応としてdequeueが呼ばれたときにもう一つのスタックに
 * 現在あるスタック全てをpop→pushしておく。
 * もう一つのスタックが空になるまではそのスタックから
 * 要素を取り出すだけでよくなる。
 * もし空になったら、また現在のスタックからもう一つのスタックに移すことをすればよい。
 * 思いつかねぇ・・。
 *
 */
public class Q5 {

    public class MyQueue {
        public Stack queue, buffer;

        public MyQueue() {
            queue  = new Stack();
            buffer = new Stack();
        }

        public Object dequeue() {
            Object mov = queue.pop();;
            Object ret;
            if(mov == null) {
                return null;
            }
            while (mov != null) {
                buffer.push(mov);
                mov = queue.pop();
            }
            ret = buffer.pop();

            mov = buffer.pop();
            while (mov != null ) {
                queue.push(mov);
                mov = buffer.pop();
            }
            return ret;
        }

        public void enqueue(Object obj) {
            queue.push(obj);
        }
    }
}
