package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.IToken;

/**
 * Token implementation.
 */
public class Token implements IToken {

    private String name = "";
    private String lexeme = "";

    /**
     * Constructor Token.
     * @param name Name token.
     * @param lexeme This lexem.
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
