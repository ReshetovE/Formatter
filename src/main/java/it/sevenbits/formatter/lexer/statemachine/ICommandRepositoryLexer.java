package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.State;

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
