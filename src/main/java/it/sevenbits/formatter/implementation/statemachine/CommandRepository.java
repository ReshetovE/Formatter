package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.command.CloseBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.DefaultCommand;
import it.sevenbits.formatter.implementation.statemachine.command.OpenBracketCommand;

import java.util.HashMap;

/**
 * CommandRepository class.
 */
public class CommandRepository {

    private HashMap<Pair, ICommand> map;

    /**
     * Constructor command repository.
     */
    public CommandRepository() {
        Pair<State, String> pairDefault = new Pair<>(new State("Default"), "Default");
        Pair<State, String> pairOpenBracket = new Pair<>(new State("Default"), "OpenBracket");
        Pair<State, String> pairCloseBracket = new Pair<>(new State("Default"), "CloseBracket");
        map = new HashMap<>();

        map.put(pairDefault, new DefaultCommand());
        map.put(pairOpenBracket, new OpenBracketCommand());
        map.put(pairCloseBracket, new CloseBracketCommand());
    }

    /**
     * Get command method.
     * @param state Now state.
     * @param token Token.
     * @return new command.
     */
    public ICommand getCommand(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
       return map.get(currentPair);
    }
}
