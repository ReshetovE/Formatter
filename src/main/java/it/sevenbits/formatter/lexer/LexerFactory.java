package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.core.ILexerFactory;

/**
 * Lexer factory.
 */
public class LexerFactory implements ILexerFactory {

    @Override
    public ILexer createLexer(final IReader in) {
        return new Lexer(in);
    }
}
