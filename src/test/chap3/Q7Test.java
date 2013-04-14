package test.chap3;

import static org.junit.Assert.*;

import org.junit.Test;

import code.chap3.Q7;
import code.chap3.Q7.Facility;

public class Q7Test {

    @Test
    public void test01() {
        Q7 q7 = new Q7();
        Facility fac = q7.new Facility();
        fac.add(q7.new Dog());
        fac.add(q7.new Dog());
        fac.add(q7.new Cat());
        fac.add(q7.new Dog());
        fac.add(q7.new Cat());
        fac.add(q7.new Cat());

        assertEquals("Cat",fac.dequeueAny().getClass().getSimpleName());

        assertEquals("Dog",fac.dequeueDog().getClass().getSimpleName());
        assertEquals("Cat",fac.dequeueAny().getClass().getSimpleName());
        assertEquals("Cat",fac.dequeueAny().getClass().getSimpleName());

    }
    @Test
    public void test02() {
        Q7 q7 = new Q7();
        Facility fac = q7.new Facility();
        fac.add(q7.new Dog());
        fac.add(q7.new Cat());
        fac.add(q7.new Cat());
        fac.add(q7.new Dog());
        fac.add(q7.new Dog());
        fac.add(q7.new Cat());

        assertEquals("Cat",fac.dequeueCat().getClass().getSimpleName());
        assertEquals("Cat",fac.dequeueCat().getClass().getSimpleName());
        assertEquals("Cat",fac.dequeueCat().getClass().getSimpleName());
        assertEquals("Dog",fac.dequeueAny().getClass().getSimpleName());
        assertEquals("Dog",fac.dequeueAny().getClass().getSimpleName());

    }
}
