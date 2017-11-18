package it.sevenbits.formatter.core;

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
