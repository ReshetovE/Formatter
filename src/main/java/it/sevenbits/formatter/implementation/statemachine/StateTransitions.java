package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;

import java.util.HashMap;

/**
 * State transitions implements.
 */
public class StateTransitions {

    /**
     * Get new state.
     * @param state Old state.
     * @param token Token.
     * @return New state.
     */
    public IState nextState(IState state, IToken token){
        HashMap<Pair, IState> newStateMap = new HashMap<Pair, IState>();


    }
}
