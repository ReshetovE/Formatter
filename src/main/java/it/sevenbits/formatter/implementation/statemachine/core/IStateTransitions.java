package it.sevenbits.formatter.implementation.statemachine.core;

import it.sevenbits.formatter.implementation.core.IToken;

/**
 * State transitions interface.
 */
public interface IStateTransitions {

    /**
     * Get new state.
     * @param state Old state.
     * @param token Token.
     * @return New state.
     */
    IState nextState(IState state, IToken token);

    /**
     * Insert new pair for get new state.
     * @param currentStateName Name current stateю
     * @param tokenName Token name.
     * @param state New state.
     */
    void insert(String currentStateName, String tokenName, String state);
}
