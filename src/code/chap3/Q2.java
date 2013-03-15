package code.chap3;

/**
 * pushとpopと最小の要素を返す関数minを持つスタックをどのようにデザインしますか？
 * ただしpush, pop, min 関数はすべてO(1)の実行時間になるようにしてください。
 * @author kiminari.homma
 *
 */
public class Q2 {

	public class StackMin extends Stack {
		int min;
		/** 内部で最小値をスタックとして保存していく */
		Stack minStack;

		public void push(int item) {
			if (top == null) {
				min = item;
				minStack = new Stack();
				minStack.push(min);
			} else {
				if (min >= item) {
					min = item;
					minStack.push(min);
				}
			}
			super.push(item);
		}

		public Object pop() {
			if (min == (int) top.data) {
				minStack.pop();
				min = (int) minStack.pop();
			}
			return super.pop();
		}

		public int min() {
			return min;
		}
	}
}
