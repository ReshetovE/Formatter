package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.core.IToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StateTransitionsTest {

    @Test
    public void testSimpleTransitions() {
        StateTransitions stateTransitions = new StateTransitions();

        IToken token = new Token("Semicolon", ";");

        IState nowState = stateTransitions.nextState(new State("DefaultState"), token);

        IState state = new State("NewLineState");

        assertEquals(nowState, state);

    }
}
