package test.chap3;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap3.Q2;
import code.chap3.Q2.StackMin;

public class Q2Test {

	@Test
	public void test() {
		Q2 q2 = new Q2();
		StackMin sMin = q2.new StackMin();
		int popped;

		sMin.push(3);
		assertEquals(3, sMin.min());

		sMin.push(5);
		assertEquals(3, sMin.min());

		sMin.push(7);
		assertEquals(3, sMin.min());

		popped = (int) sMin.pop();
		assertEquals(7, popped);
		assertEquals(3, sMin.min());

		sMin.push(3);
		assertEquals(3, sMin.min());

		sMin.push(1);
		assertEquals(1, sMin.min());

		popped = (int) sMin.pop();
		assertEquals(1, popped);
		assertEquals(3, sMin.min());

	}
}
