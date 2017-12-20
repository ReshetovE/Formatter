package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerICommandRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Lexer command repository class.
 */
public class LexerCommandRepository implements LexerICommandRepository {

    private Map<Pair<State, Character>, LexerICommand> commands;

    /**
     * Constructor Command repository.
     */
    public LexerCommandRepository() {
        commands = new HashMap<>();
    }

    @Override
    public LexerICommand getCommand(final State state, final char c) {
        LexerICommand command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }

    @Override
    public void insert(final String state, final Character input, final LexerICommand command) {
        commands.put(new Pair<>(new State(state), input), command);
    }
}
