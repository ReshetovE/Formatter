package it.sevenbits.formatter.lexer.statemachine.core;

import it.sevenbits.formatter.implementation.statemachine.State; /**
 * Interface for StateTransitions class.
 */
public interface IStateTransitionsLexer {
    /**
     * Get new state.
     * @param state Old state.
     * @param s Name lexeme.
     * @return New state.
     */
    State getNextState(State state, char c);
}
