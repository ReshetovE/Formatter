package it.sevenbits.formatter.lexer.core;

import it.sevenbits.formatter.io.core_io.IReader;

/**
 * Lexer factory interface.
 */
public interface ILexerFactory {
    /**
     * Create lexer.
     * @param in Input interface Reader.
     * @return New lexer.
     */
    ILexer createLexer(IReader in);
}
