package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.IStateTransitionsLexer;

import java.util.HashMap;
import java.util.Map;

/**
 * State transitions implementation.
 */
public class StateTransitionsLexer implements IStateTransitionsLexer {

    private final Map<Pair<State, Character>, State> states = new HashMap<>();

    /**
     * Constructor state transitions.
     */
    public StateTransitionsLexer() {
        states.put(new Pair<>(new State("Default"), '/'), new State("Slash"));
        states.put(new Pair<>(new State("Slash"), '/'), new State("SingleLineComment"));
        states.put(new Pair<>(new State("Slash"), '*'), new State("OpenMultiLineComment"));
        states.put(new Pair<>(new State("Default"), '*'), new State("Star"));
        states.put(new Pair<>(new State("Star"), '/'), new State("CloseMultiLineComment"));

    }

    @Override
    public State getNextState(final State state, final char c) {
        State nextState = states.get(new  Pair<>(state, c));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }
}
