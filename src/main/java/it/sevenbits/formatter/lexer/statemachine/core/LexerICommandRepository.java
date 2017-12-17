package it.sevenbits.formatter.lexer.statemachine.core;

import it.sevenbits.formatter.implementation.statemachine.State;

/**
 * Interface for CommandRepository class.
 */
public interface LexerICommandRepository {

    /**
     * Get new command.
     * @param state Now state.
     * @param c Char.
     * @return New command.
     */
    LexerICommand getCommand(State state, char c);
}
