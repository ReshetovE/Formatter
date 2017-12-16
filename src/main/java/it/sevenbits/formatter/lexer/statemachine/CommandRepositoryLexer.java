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

        commands.put(new Pair<>(new State("default"), null), new IntactCommand());

        commands.put(new Pair<>(new State("default"), ';'), new SemicolonCommand());

        commands.put(new Pair<>(new State("default"), '{'), new OpenBracketCommand());

        commands.put(new Pair<>(new State("default"), '}'), new CloseBracketCommand());

        commands.put(new Pair<>(new State("default"), ' '), new SpaceCommand());

        commands.put(new Pair<>(new State("default"), '\n'), new NewLineCommand());

        commands.put(new Pair<>(new State("default"), '"'), new StringLiteralCommand());

        //spacing state

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
