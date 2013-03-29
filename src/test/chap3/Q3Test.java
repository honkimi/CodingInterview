package test.chap3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.chap3.Q3;
import code.chap3.Q3.SetOfStacks;

public class Q3Test {

	@Test
	public void test() {
		Q3 q3 = new Q3();
		SetOfStacks stacks= q3.new SetOfStacks();
		int popped;

		stacks.push(3);
		stacks.push(5);
		stacks.push(7);

		popped = (int) stacks.pop();
		assertEquals(7, popped);

		stacks.push(2);
		stacks.push(6);
		stacks.push(1);

		popped = (int) stacks.pop();
		assertEquals(1, popped);

		popped = (int) stacks.pop();
		popped = (int) stacks.pop();
		popped = (int) stacks.pop();
		popped = (int) stacks.pop();
		assertEquals(3, popped);

	}
}
