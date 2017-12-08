package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.implementation.core.IToken;

/**
 * Lexer interface.
 */
public interface ILexer {
    /**
     * Read token.
     * @return Token.
     * @throws LexerException Failed or interrupted I/O operations.
     */
    IToken readToken() throws LexerException;

    /**
     * Checker lexeme.
     * @return Are there next lexeme?
     * @throws LexerException Failed or interrupted I/O operations.
     */
    boolean hasMoreTokens() throws LexerException;
}
