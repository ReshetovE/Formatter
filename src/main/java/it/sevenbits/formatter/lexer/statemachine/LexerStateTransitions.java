package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerStateTransitions;

import java.util.HashMap;
import java.util.Map;

/**
 * State transitions implementation.
 */
public class LexerStateTransitions implements ILexerStateTransitions {

    private Map<Pair<State, Character>, State> states;

    /**
     * Constructor state transitions.
     */
    public LexerStateTransitions() {
        states = new HashMap<>();
    }

    @Override
    public State getNextState(final State state, final char c) {
        State nextState = states.get(new  Pair<>(state, c));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }

    @Override
    public void insert(final String stateName, final Character input, final State state) {
        states.put(new Pair<>(new State(stateName), input), state);
    }
}
