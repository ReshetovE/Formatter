package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.core.ICommandLexer;
import it.sevenbits.formatter.lexer.statemachine.core.ICommandRepositoryLexer;

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

        //Default state.

        commands.put(new Pair<>(new State("default"), null),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("Char"); });

        commands.put(new Pair<>(new State("default"), ';'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("Semicolon"); });

        commands.put(new Pair<>(new State("default"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("Space"); });

        commands.put(new Pair<>(new State("default"), '{'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("OpenBracket"); });

        commands.put(new Pair<>(new State("default"), '}'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("CloseBracket"); });


        //spacing state

        commands.put(new Pair<>(new State("spacing"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("Space"); });

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
