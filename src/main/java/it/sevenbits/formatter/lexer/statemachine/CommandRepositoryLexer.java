package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.command.CloseBracketCommand;
import it.sevenbits.formatter.lexer.statemachine.command.IntactCommand;
import it.sevenbits.formatter.lexer.statemachine.command.NewLineCommand;
import it.sevenbits.formatter.lexer.statemachine.command.OpenBracketCommand;
import it.sevenbits.formatter.lexer.statemachine.command.SemicolonCommand;
import it.sevenbits.formatter.lexer.statemachine.command.SpaceCommand;
import it.sevenbits.formatter.lexer.statemachine.command.StringLiteralCommand;
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

        commands.put(new Pair<>(new State("Default"), null), new IntactCommand());

        commands.put(new Pair<>(new State("Default"), ';'), new SemicolonCommand());

        commands.put(new Pair<>(new State("Default"), '{'), new OpenBracketCommand());

        commands.put(new Pair<>(new State("Default"), '}'), new CloseBracketCommand());

        commands.put(new Pair<>(new State("Default"), ' '), new SpaceCommand());

        commands.put(new Pair<>(new State("Default"), '\n'), new NewLineCommand());

        commands.put(new Pair<>(new State("Default"), '"'), new StringLiteralCommand());

        //spacing state
        commands.put(new Pair<>(new State("Default"), '/'), new IntactCommand());


        commands.put(new Pair<>(new State("Slash"), null), (c, context) ->
                context.appendPostpone(c));
        commands.put(new Pair<>(new State("Slash"), '/'), (c, context) -> {
            context.appendLexeme(c); context.setTokenName("SingleLineComment"); });
        commands.put(new Pair<>(new State("SingleLineComment"), null), (c, context) ->
                context.appendPostpone(c));
        commands.put(new Pair<>(new State("Slash"), '*'), (c, context) -> {
            context.appendLexeme(c); context.setTokenName("OpenMultiLineComment"); });
        commands.put(new Pair<>(new State("OpenMultiLineComment"), null), (c, context) ->
                context.appendPostpone(c));
        commands.put(new Pair<>(new State("Default"), '*'), new IntactCommand());
        commands.put(new Pair<>(new State("Star"), null), (c, context) ->
                context.appendPostpone(c));
        commands.put(new Pair<>(new State("Star"), '/'), (c, context) -> {
            context.appendLexeme(c); context.setTokenName("CloseMultiLineComment"); });
        commands.put(new Pair<>(new State("CloseMultiLineComment"), null), (c, context) ->
                context.appendPostpone(c));

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
