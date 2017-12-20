package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIStateTransitions;

import java.util.HashMap;
import java.util.Map;

/**
 * State transitions implementation.
 */
public class LexerStateTransitions implements LexerIStateTransitions {

    private final Map<Pair<State, Character>, State> states = new HashMap<>();

    /**
     * Constructor state transitions.
     */
    public LexerStateTransitions() {
        states.put(new Pair<>(new State("Default"), null), new State("Final"));
/*
        states.put(new Pair<>(new State("Default"), '\\'), new State("BackSlash"));
        states.put(new Pair<>(new State("BackSlash"), '"'), new State("IgnoreStringLiteral"));

        states.put(new Pair<>(new State("Default"), 'f'), new State("FFromLoop"));
        states.put(new Pair<>(new State("FFromLoop"), 'o'), new State("FoFromLoop"));
        states.put(new Pair<>(new State("FoFromLoop"), 'r'), new State("FullLoop"));

        states.put(new Pair<>(new State("Default"), '/'), new State("Slash"));
        states.put(new Pair<>(new State("Slash"), '/'), new State("SingleLineComment"));
        states.put(new Pair<>(new State("Slash"), '*'), new State("OpenMultiLineComment"));
        states.put(new Pair<>(new State("Default"), '*'), new State("Star"));
        states.put(new Pair<>(new State("Star"), '/'), new State("CloseMultiLineComment"));*/

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
