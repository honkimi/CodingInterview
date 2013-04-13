package code.chap3;

/**
 * push��pop�ƍŏ��̗v�f��Ԃ��֐�min�����X�^�b�N���ǂ̂悤�Ƀf�U�C�����܂����H
 * ������push, pop, min �֐��͂��ׂ�O(1)�̎��s���ԂɂȂ�悤�ɂ��Ă��������B
 * @author kiminari.homma
 *
 */
public class Q2 {

	public class StackMin extends Stack {
		int min;
		/** �����ōŏ��l���X�^�b�N�Ƃ��ĕۑ����Ă��� */
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
