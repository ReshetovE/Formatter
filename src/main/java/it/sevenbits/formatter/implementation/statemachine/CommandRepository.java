package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommandRepository;
import it.sevenbits.formatter.implementation.statemachine.core.IState;

import java.util.HashMap;

/**
 * CommandRepository class.
 */
public class CommandRepository implements ICommandRepository {

    private HashMap<Pair, ICommand> map;

    /**
     * Constructor command repository.
     */
    public CommandRepository() {
        map = new HashMap<>();
    }

    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }

    @Override
    public void insert(final String currentStateName, final String tokenName, final ICommand command) {
        map.put(new Pair<>(new State(currentStateName), tokenName), command);
    }
}
