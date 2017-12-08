package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Lexer command repository class.
 */
public class CommandRepositoryLexer implements ICommandRepositoryLexer {

    private final Map<Pair<State, Character>, ICommandLexer> commands = new HashMap<>();

    /**
     * Constructor Command repository.
     */
    public CommandRepositoryLexer() {
        commands.put(new Pair<>(new State("default"), null),
                (c, context) -> {
            context.appendLexeme(c); context.setTokenName("char"); });
        commands.put(new Pair<>(new State("default"), ';'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("semicolon"); });
        commands.put(new Pair<>(new State("default"), '\n'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("newline"); });
        commands.put(new Pair<>(new State("default"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("space"); });
        commands.put(new Pair<>(new State("spacing"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("space"); });
        commands.put(new Pair<>(new State("spacing"), null),
                (c, context) -> {
                    context.appendPostpone(c); });
    }

    @Override
    public ICommandLexer getCommand(final State state, final char c) {
        ICommandLexer command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }
}
