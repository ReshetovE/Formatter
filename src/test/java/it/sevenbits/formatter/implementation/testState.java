package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.statemachine.State;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class testState {

    @Test
    public void testEqualState() {
        State state1 = new State("A");
        State state2 = new State("A");

        assertNotSame(state1, state2);
        assertEquals(state1, state2);
        assertEquals(state1.hashCode(), state2.hashCode());
    }

    @Test
    public void testNotEqualsState() {
        State state1 = new State("A");
        State state2 = new State("B");

        assertNotSame(state1, state2);
        assertNotEquals(state1, state2);
        assertNotEquals(state1.hashCode(), state2.hashCode());
    }
}
