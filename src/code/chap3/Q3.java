package code.chap3;

/**
 * 皿が積みあがっている状況をイメージしてください。もし、高く積み上がりすぎたら倒れてしまうでしょう。
 * ですから、実生活ではスタックがある領域を超えたとき、新しいスタックを用意することになるでしょう。
 * これをまねたデータ構造SetOfStacksを実装してください。SetOfStacksはいくつかのスタックを持ち、スタックのデータが一杯になったら
 * スタックを新たに作らなければなりません。また、SetOfStacks.push()とSetOfStacks.pop()は普通のスタック
 * のようにふるまうようにしてください（つまり、pop()は通常の一つのスタックの場合と同じ値を返さなければなりません）。
 * @author kiminari.homma
 *
 */
public class Q3 {

    public class SetOfStacks {
        final static int MAX_STACK = 2;
        Node top = null;
        Stack stacks = null;
        int current_num = 0;

        public SetOfStacks() {
            stacks = new Stack();
            stacks.push(new Stack());
        }

        public Object pop() {
            if (current_num != 0) {
                current_num--;
                return ((Stack) stacks.peek()).pop();
            } else {
                //ここが-1は時間かかった。。
                current_num = MAX_STACK-1;
                stacks.pop();
                return ((Stack) stacks.peek()).pop();
            }
        }

        public void push (Object item) {
            if (MAX_STACK > current_num) {
                ((Stack)stacks.peek()).push(item);
                current_num++;
            } else {
                stacks.push(new Stack());
                ((Stack) stacks.peek()).push(item);
                current_num = 1;
            }
        }
    }
}
