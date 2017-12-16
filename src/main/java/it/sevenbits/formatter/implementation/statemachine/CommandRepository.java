package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.CloseBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.StringLiteralCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.CharNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.CloseBracketNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.DefaultCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.OpenBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.NewLineNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.OpenBracketNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.SemicolonCommand;
import it.sevenbits.formatter.implementation.statemachine.command.NopeCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.SemicolonNewLineCommand;
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

        //Default state.
        Pair<State, String> pairDefaultSimpleChar = new Pair<>(new State("DefaultState"), "Char");
        Pair<State, String> pairDefaultOpenBracket = new Pair<>(new State("DefaultState"), "OpenBracket");
        Pair<State, String> pairDefaultCloseBracket = new Pair<>(new State("DefaultState"), "CloseBracket");
        Pair<State, String> pairDefaultSemicolon = new Pair<>(new State("DefaultState"), "Semicolon");
        Pair<State, String> pairDefaultSpace = new Pair<>(new State("DefaultState"), "Space");
        Pair<State, String> pairDefaultNewLine = new Pair<>(new State("DefaultState"), "NewLine");
        Pair<State, String> pairDefaultStringLiteral = new Pair<>(new State("DefaultState"), "StringLiteral");

        //NewLine state.
        Pair<State, String> pairNewLineSimpleChar = new Pair<>(new State("NewLineState"), "Char");
        Pair<State, String> pairNewLineOpenBracket = new Pair<>(new State("NewLineState"), "OpenBracket");
        Pair<State, String> pairNewLineCloseBracket = new Pair<>(new State("NewLineState"), "CloseBracket");
        Pair<State, String> pairNewLineSemicolon = new Pair<>(new State("NewLineState"), "Semicolon");
        Pair<State, String> pairNewLineSpace = new Pair<>(new State("NewLineState"), "Space");
        Pair<State, String> pairNewLineNewLine = new Pair<>(new State("NewLineState"), "NewLine");
        Pair<State, String> pairNewLineStringLiteral = new Pair<>(new State("NewLineState"), "StringLiteral");

        //StringLiteral state.
        Pair<State, String> pairStringLiteralSimpleChar = new Pair<>(new State("StringLiteralState"), "Char");
        Pair<State, String> pairStringLiteralOpenBracket = new Pair<>(new State("StringLiteralState"), "OpenBracket");
        Pair<State, String> pairStringLiteralCloseBracket = new Pair<>(new State("StringLiteralState"), "CloseBracket");
        Pair<State, String> pairStringLiteralSemicolon = new Pair<>(new State("StringLiteralState"), "Semicolon");
        Pair<State, String> pairStringLiteralSpace = new Pair<>(new State("StringLiteralState"), "Space");
        Pair<State, String> pairStringLiteralNewLine = new Pair<>(new State("StringLiteralState"), "NewLine");
        Pair<State, String> pairStringLiteralStringLiteral = new Pair<>(new State("StringLiteralState"), "StringLiteral");

        map = new HashMap<>();

        //Default state.
        map.put(pairDefaultSimpleChar, new DefaultCommand());
        map.put(pairDefaultOpenBracket, new OpenBracketCommand());
        map.put(pairDefaultCloseBracket, new CloseBracketCommand());
        map.put(pairDefaultSemicolon, new SemicolonCommand());
        map.put(pairDefaultSpace, new DefaultCommand());
        map.put(pairDefaultNewLine, new NopeCommand());
        map.put(pairDefaultStringLiteral, new DefaultCommand());

        //NewLine state.
        map.put(pairNewLineSimpleChar, new CharNewLineCommand());
        map.put(pairNewLineOpenBracket, new OpenBracketNewLineCommand());
        map.put(pairNewLineCloseBracket, new CloseBracketNewLineCommand());
        map.put(pairNewLineSemicolon, new SemicolonNewLineCommand());
        map.put(pairNewLineSpace, new NopeCommand());
        map.put(pairNewLineNewLine, new NewLineNewLineCommand());
        map.put(pairNewLineStringLiteral, new DefaultCommand());

        //StringLiteral state.
        map.put(pairStringLiteralSimpleChar, new DefaultCommand());
        map.put(pairStringLiteralOpenBracket, new DefaultCommand());
        map.put(pairStringLiteralCloseBracket, new DefaultCommand());
        map.put(pairStringLiteralSemicolon, new DefaultCommand());
        map.put(pairStringLiteralSpace, new DefaultCommand());
        map.put(pairStringLiteralNewLine, new DefaultCommand());
        map.put(pairStringLiteralStringLiteral, new DefaultCommand());
    }


    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}
