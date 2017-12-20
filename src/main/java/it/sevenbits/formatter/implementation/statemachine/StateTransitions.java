package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.IState;
import it.sevenbits.formatter.implementation.statemachine.core.IStateTransitions;

import java.util.HashMap;

/**
 * State transitions implements.
 */
public class StateTransitions implements IStateTransitions {

    private HashMap<Pair, IState> map;

    /**
     * Constructor command repository.
     */
    public StateTransitions() {
        map = new HashMap<>();
    }

    @Override
    public IState nextState(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }

    @Override
    public void insert(final String currentStateName, final String tokenName, final String state) {
        map.put(new Pair<>(new State(currentStateName), tokenName), new State(state));
    }
}
