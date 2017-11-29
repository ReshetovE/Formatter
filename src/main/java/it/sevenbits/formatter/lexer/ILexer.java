package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.ReaderException;

/**
 * Lexer interface.
 */
public interface ILexer {
    /**
     * Read token.
     * @return Token.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    IToken readToken() throws ReaderException;

    /**
     * Checker lexem.
     * @return Are there next lexeme?
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    boolean hasMoreTokens() throws ReaderException;
}
