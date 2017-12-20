package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommand;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommandRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Lexer command repository class.
 */
public class LexerCommandRepository implements ILexerCommandRepository {

    private Map<Pair<State, Character>, ILexerCommand> commands;

    /**
     * Constructor Command repository.
     */
    public LexerCommandRepository() {
        commands = new HashMap<>();
    }

    @Override
    public ILexerCommand getCommand(final State state, final char c) {
        ILexerCommand command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }

    @Override
    public void insert(final String state, final Character input, final ILexerCommand command) {
        commands.put(new Pair<>(new State(state), input), command);
    }
}
