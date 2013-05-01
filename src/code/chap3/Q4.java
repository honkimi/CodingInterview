package code.chap3;

/**
 * 古典的なハノイの塔の問題では、3つの塔とN枚のサイズの異なる 円盤を用いて塔の間を移動させます。最初は円盤が下から上に
 * 向かって小さくなるように（どの円盤も自身より大きな円盤の上に載っているように） なっています。そして下のような制約を持ちます。
 * １、一度に1枚の円盤しか動かせない。 ２、塔の一番上にある円盤を他の塔に移動させる。 ３、円盤を置くときは、それ自身より大きなものの上にしか置けない。
 * スタックを用いて、最初の塔に積みあがっている円盤を最後の塔に 移動させるプログラムを書いてください。
 *
 * @author kiminari.homma
 *
 */
public class Q4 {

    public class Tower {

        public java.util.Stack<Integer> disks;
        private int index;
        public Tower(int i) {
            disks = new java.util.Stack<Integer>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void add(int d) {
            if(!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk" + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

}

/*
 * 再帰を考えるときのメモ
 *
 * ・まず始めに、n=1からはじめ、1個ずつ増やしてみる。
 * [重要]nが1増えるときに、前の結果が流用できないかを考える！
 *
 * もし流用できそうな場合は、それは再帰が使える可能性が高い。
 *
 *
 * 今回のハノイの塔の問題の場合:
 *
 * n=0 のときは何もしない。
 *
 * n=1 のときは塔1から塔3へに移すだけ.      moveTopTo(destination);
 *
 * n=2 のときは
 *      円盤1を塔1から塔2へもっていき、     moveDisks(n - 1, buffer, destination);
 *      円盤2を塔1から塔3へもっていき、     moveTopTo(destination);
 *      円盤1を塔2から塔3へ                 buffer.moveDisks(n - 1, destination, this);
 *
 * n=3 のときは
 *      n=2のときのようにして上2つの円盤を塔2へ持っていき、      moveDisks(n - 1, buffer, destination);
 *      円盤3を塔1から塔3へ移したあとに                          moveTopTo(destination);
 *      n=2のときのようにして塔2にある円盤たちを塔3へもっていく  buffer.moveDisks(n - 1, destination, this);
 *
 * n=4 のときは
 *      n=3のときのようにして上3つの円盤を塔2へ持っていき、      moveDisks(n - 1, buffer, destination);
 *      円盤4を塔1から塔3へ移したあとに                          moveTopTo(destination);
 *      n=3のときのようにして塔2にある円盤たちを塔3へもっていく  buffer.moveDisks(n - 1, destination, this);
 * ...
 *
 * てな感じになる。
 *
 */
