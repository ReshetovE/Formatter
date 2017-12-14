package it.sevenbits.formatter.lexer.statemachine.core;

import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.ICommandLexer;

/**
 * Interface for CommandRepository class.
 */
public interface ICommandRepositoryLexer {

    /**
     * Get new command.
     * @param state Now state.
     * @param c Char.
     * @return New command.
     */
    ICommandLexer getCommand(State state, char c);
}
