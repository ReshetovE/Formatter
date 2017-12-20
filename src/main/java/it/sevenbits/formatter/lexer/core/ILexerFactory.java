package it.sevenbits.formatter.lexer.core;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.lexer.LexerConfig;

/**
 * Lexer factory interface.
 */
public interface ILexerFactory {
    /**
     * Create lexer.
     * @param in Input interface Reader.
     * @param lexerConfig Lexer config.
     * @return New lexer.
     */
    ILexer createLexer(IReader in, LexerConfig lexerConfig);
}
