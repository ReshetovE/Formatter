package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;

/**
 * Command repository interface.
 */
public interface ICommandRepository {

    /**
     * Get command method.
     * @param state Now state.
     * @param token Token.
     * @return new command.
     */
    ICommand getCommand(IState state, IToken token);
}
