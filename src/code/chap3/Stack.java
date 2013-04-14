package code.chap3;

import code.chap3.Node;

/**
 * �X�^�b�N�x�[�X�N���X
 *
 * @author kiminari.homma
 *
 */
public class Stack {
	Node top = null;

	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public Object peek() {
		return top.data;
	}

	public boolean isEmpty() {
	    return top == null;
	}

}
