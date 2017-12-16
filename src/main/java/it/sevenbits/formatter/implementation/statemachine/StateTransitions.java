package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.IState;
import it.sevenbits.formatter.implementation.statemachine.core.IStateTransitions;

import java.util.HashMap;

/**
 * State transitions implements.
 */
public class StateTransitions implements IStateTransitions {

    private HashMap<Pair, IState> map;

    /**
     * Constructor command repository.
     */
    public StateTransitions() {
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
        Pair<State, String> pairNewLinetStringLiteral = new Pair<>(new State("NewLineState"), "StringLiteral");

        //StringLiteralState
        Pair<State, String> pairStringLiteralSimpleChar = new Pair<>(new State("StringLiteralState"), "Char");
        Pair<State, String> pairStringLiteralOpenBracket = new Pair<>(new State("StringLiteralState"), "OpenBracket");
        Pair<State, String> pairStringLiteralCloseBracket = new Pair<>(new State("StringLiteralState"), "CloseBracket");
        Pair<State, String> pairStringLiteralSemicolon = new Pair<>(new State("StringLiteralState"), "Semicolon");
        Pair<State, String> pairStringLiteralSpace = new Pair<>(new State("StringLiteralState"), "Space");
        Pair<State, String> pairStringLiteralNewLine = new Pair<>(new State("StringLiteralState"), "NewLine");
        Pair<State, String> pairStringLiteralStringLiteral = new Pair<>(new State("StringLiteralState"), "StringLiteral");


        map = new HashMap<>();

        //Default state.
        map.put(pairDefaultSimpleChar, new State("DefaultState"));
        map.put(pairDefaultOpenBracket, new State("NewLineState"));
        map.put(pairDefaultCloseBracket, new State("NewLineState"));
        map.put(pairDefaultSemicolon, new State("NewLineState"));
        map.put(pairDefaultSpace, new State("DefaultState"));
        map.put(pairDefaultNewLine, new State("NewLineState"));
        map.put(pairDefaultStringLiteral, new State("StringLiteralState"));

        //NewLine state.
        map.put(pairNewLineSimpleChar, new State("DefaultState"));
        map.put(pairNewLineOpenBracket, new State("NewLineState"));
        map.put(pairNewLineCloseBracket, new State("NewLineState"));
        map.put(pairNewLineSemicolon, new State("NewLineState"));
        map.put(pairNewLineSpace, new State("NewLineState"));
        map.put(pairNewLineNewLine, new State("NewLineState"));
        map.put(pairNewLinetStringLiteral, new State("StringLiteralState"));

        // StringLiteral state.
        map.put(pairStringLiteralSimpleChar, new State("StringLiteralState"));
        map.put(pairStringLiteralOpenBracket, new State("StringLiteralState"));
        map.put(pairStringLiteralCloseBracket, new State("StringLiteralState"));
        map.put(pairStringLiteralSemicolon, new State("StringLiteralState"));
        map.put(pairStringLiteralSpace, new State("StringLiteralState"));
        map.put(pairStringLiteralNewLine, new State("StringLiteralState"));
        map.put(pairStringLiteralStringLiteral, new State("DefaultState"));
    }


    @Override
    public IState nextState(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}
