package it.sevenbits.formatter.lexer.statemachine.core;

import it.sevenbits.formatter.implementation.statemachine.State;

/**
 * Interface for StateTransitions class.
 */
public interface ILexerStateTransitions {

    /**
     * Get new state.
     * @param state Old state.
     * @param c Char lexeme.
     * @return New state.
     */
    State getNextState(State state, char c);

    /**
     * Insert new pair for get new state.
     * @param stateName Name current state.
     * @param input Char.
     * @param state New state.
     */
    void insert(String stateName, Character input, State state);
}
