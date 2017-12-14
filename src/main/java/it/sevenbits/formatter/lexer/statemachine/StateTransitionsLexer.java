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
        states.put(new Pair<>(new State("default"), null), new State("finalstate"));
        states.put(new Pair<>(new State("default"), ';'), new State("finalstate"));
        states.put(new Pair<>(new State("default"), '{'), new State("finalstate"));
        states.put(new Pair<>(new State("default"), '}'), new State("finalstate"));
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("default"), '\n'), new State("finalstate"));


        states.put(new Pair<>(new State("spacing"), null), new State("finalstate"));

        states.put(new Pair<>(new State("spacing"), ';'), new State("finalstate"));

        states.put(new Pair<>(new State("spacing"), '{'), new State("finalstate"));

        states.put(new Pair<>(new State("spacing"), '}'), new State("finalstate"));

        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        states.put(new Pair<>(new State("spacing"), '\n'), new State("finalstate"));

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
