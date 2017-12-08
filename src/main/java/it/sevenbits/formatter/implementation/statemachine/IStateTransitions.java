package it.sevenbits.formatter.implementation.statemachine;

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
}
