package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;

import java.util.HashMap;


/**
 * CommandRepository class.
 */
public class CommandRepository {

    private HashMap<PairStateToken, ICommand> map;

    CommandRepository() {
        PairStateToken pair = new PairStateToken(new State("default"), "OpenBrace");
        map = new HashMap<>();

        map.put(pair, new DefaultCommand());
    }
    
    /**
     * Get command method.
     * @param state Now state.
     * @param token Token.
     * @return new Command.
     */
    public ICommand getCommand(final IState state, final IToken token) {
        PairStateToken currentPair = new PairStateToken(state, token.getName());
       return map.get(currentPair);
    }
}
