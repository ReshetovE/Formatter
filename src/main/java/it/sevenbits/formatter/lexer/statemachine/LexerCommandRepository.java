package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.statemachine.Pair;
import it.sevenbits.formatter.implementation.statemachine.State;

import java.util.HashMap;

/**
 * Lexer command repository class.
 */
public class LexerCommandRepository {

    private HashMap<Pair, ILexerCommand> map;

    public LexerCommandRepository() {


    }
}