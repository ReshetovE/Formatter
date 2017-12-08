package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;

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
        Pair<State, String> pairDefaultSimpleChar = new Pair<>(new State("DefaultState"), "Default");
        Pair<State, String> pairDefaultOpenBracket = new Pair<>(new State("DefaultState"), "OpenBracket");
        Pair<State, String> pairDefaultCloseBracket = new Pair<>(new State("DefaultState"), "CloseBracket");
        Pair<State, String> pairDefaultSemicolon = new Pair<>(new State("DefaultState"), "Semicolon");
        Pair<State, String> pairDefaultSpace = new Pair<>(new State("DefaultState"), "Space");
        Pair<State, String> pairDefaultNewLine = new Pair<>(new State("DefaultState"), "NewLine");
        //NewLine state.
        Pair<State, String> pairNewLineSimpleChar = new Pair<>(new State("NewLineState"), "Default");
        Pair<State, String> pairNewLineOpenBracket = new Pair<>(new State("NewLineState"), "OpenBracket");
        Pair<State, String> pairNewLineCloseBracket = new Pair<>(new State("NewLineState"), "CloseBracket");
        Pair<State, String> pairNewLineSemicolon = new Pair<>(new State("NewLineState"), "Semicolon");
        Pair<State, String> pairNewLineSpace = new Pair<>(new State("NewLineState"), "Space");


        map = new HashMap<>();

        map.put(pairDefaultSimpleChar, new State("DefaultState"));
        map.put(pairDefaultOpenBracket, new State("NewLineState"));
        map.put(pairDefaultCloseBracket, new State("NewLineState"));
        map.put(pairDefaultSemicolon, new State("NewLineState"));
        map.put(pairDefaultSpace, new State("DefaultState"));
        map.put(pairDefaultNewLine, new State("NewLineState"));

        map.put(pairNewLineSimpleChar, new State("DefaultState"));
        map.put(pairNewLineOpenBracket, new State("DefaultState"));
        map.put(pairNewLineCloseBracket, new State("DefaultState"));
        map.put(pairNewLineSemicolon, new State("DefaultState"));
        map.put(pairNewLineSpace, new State("NewLineState"));
    }


    @Override
    public IState nextState(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}
