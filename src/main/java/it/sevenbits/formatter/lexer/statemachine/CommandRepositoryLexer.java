package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.command.AppendPostponeCommand;
import it.sevenbits.formatter.lexer.statemachine.command.CloseMultiLineCommentCommand;
import it.sevenbits.formatter.lexer.statemachine.command.CloseBracketCommand;
import it.sevenbits.formatter.lexer.statemachine.command.IntactCommand;
import it.sevenbits.formatter.lexer.statemachine.command.NewLineCommand;
import it.sevenbits.formatter.lexer.statemachine.command.OpenBracketCommand;
import it.sevenbits.formatter.lexer.statemachine.command.OpenMultiLineCommentCommand;
import it.sevenbits.formatter.lexer.statemachine.command.SemicolonCommand;
import it.sevenbits.formatter.lexer.statemachine.command.SingleLineCommentCommand;
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
        commands.put(new Pair<>(new State("Default"), '/'), new IntactCommand());
        commands.put(new Pair<>(new State("Default"), '*'), new IntactCommand());

        //Slash state

        commands.put(new Pair<>(new State("Slash"), null), new AppendPostponeCommand());
        commands.put(new Pair<>(new State("Slash"), '/'), new SingleLineCommentCommand());
        commands.put(new Pair<>(new State("Slash"), '*'), new OpenMultiLineCommentCommand());

        //SingleLineComment state
        commands.put(new Pair<>(new State("SingleLineComment"), null), new AppendPostponeCommand());

        //OpenMultiLineComment state
        commands.put(new Pair<>(new State("OpenMultiLineComment"), null), new AppendPostponeCommand());

        //Star state
        commands.put(new Pair<>(new State("Star"), null), new AppendPostponeCommand());
        commands.put(new Pair<>(new State("Star"), '/'), new CloseMultiLineCommentCommand());

        //CloseMultiComment state
        commands.put(new Pair<>(new State("CloseMultiLineComment"), null), new AppendPostponeCommand());

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
