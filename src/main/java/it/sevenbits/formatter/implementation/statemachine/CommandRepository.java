package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.command.CharNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.CloseBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.DefaultCommand;
import it.sevenbits.formatter.implementation.statemachine.command.NewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.OpenBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.SemicolonCommand;
import it.sevenbits.formatter.implementation.statemachine.command.SpaceCommand;

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
        //Default state.
        Pair<State, String> pairDefaultSimpleChar = new Pair<>(new State("DefaultState"), "Char");
        Pair<State, String> pairDefaultOpenBracket = new Pair<>(new State("DefaultState"), "OpenBracket");
        Pair<State, String> pairDefaultCloseBracket = new Pair<>(new State("DefaultState"), "CloseBracket");
        Pair<State, String> pairDefaultSemicolon = new Pair<>(new State("DefaultState"), "Semicolon");
        Pair<State, String> pairDefaultSpace = new Pair<>(new State("DefaultState"), "Space");
        Pair<State, String> pairDefaultNewLine = new Pair<>(new State("DefaultState"), "NewLine");
        //NewLine state.
        Pair<State, String> pairNewLineSimpleChar = new Pair<>(new State("NewLineState"), "Char");
        Pair<State, String> pairNewLineOpenBracket = new Pair<>(new State("NewLineState"), "OpenBracket");
        Pair<State, String> pairNewLineCloseBracket = new Pair<>(new State("NewLineState"), "CloseBracket");
        Pair<State, String> pairNewLineSemicolon = new Pair<>(new State("NewLineState"), "Semicolon");
        Pair<State, String> pairNewLineSpace = new Pair<>(new State("NewLineState"), "Space");

        map = new HashMap<>();

        map.put(pairDefaultSimpleChar, new DefaultCommand());
        map.put(pairDefaultOpenBracket, new OpenBracketCommand());
        map.put(pairDefaultCloseBracket, new CloseBracketCommand());
        map.put(pairDefaultSemicolon, new SemicolonCommand());
        map.put(pairDefaultSpace, new DefaultCommand());
        map.put(pairDefaultNewLine, new NewLineCommand());

        map.put(pairNewLineSimpleChar, new CharNewLineCommand());
        map.put(pairNewLineOpenBracket, new OpenBracketCommand());
        map.put(pairNewLineCloseBracket, new CloseBracketCommand());
        map.put(pairNewLineSemicolon, new SemicolonCommand());
        map.put(pairNewLineSpace, new SpaceCommand());
    }


    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}
