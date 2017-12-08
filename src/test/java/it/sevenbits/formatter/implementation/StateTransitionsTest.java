package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.IState;
import it.sevenbits.formatter.implementation.statemachine.IStateTransitions;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.implementation.statemachine.StateTransitions;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StateTransitionsTest {

    @Test
    public void testTransferState() {
        IStateTransitions stateTransitions = new StateTransitions();
        IState state;
        IToken token = mock(IToken.class);
        when(token.getName()).thenReturn("NewLine", "Space");


        state = stateTransitions.nextState(new State("DefaultState"), token);
        assertEquals(state, new State("NewLineState"));

        state = stateTransitions.nextState(new State("NewLine"), token);
        assertEquals(state, new State("NewLineState"));
    }
}
