package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.ILexer;
import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.IToken;
import it.sevenbits.formatter.core.ReaderException;

/**
 * Lexical analyzer.
 */
public class Lexer implements ILexer {

    private StringBuilder lexeme = new StringBuilder();
    private IReader in;


    /**
     * Constructor Lexer.
     *
     * @param in Reader.
     */
    public Lexer(final IReader in) {
        this.in = in;
    }

    @Override
    public IToken readToken() throws ReaderException {
        try {
            while (in.hasChars()) {
                char c = in.nextChar();
                switch (c) {
                    case '{':
                        return new Token("OpenBrace", "{");
                    case '}':
                        return new Token("CloseBrace", "}");
                    case ';':
                        return new Token("Brackets", ";");
                    default:
                        return new Token("default", String.valueOf(c));
                }
            }
        } catch (ReaderException e) {
            throw new ReaderException("Method format failed", e);
        }
        return new Token("default", "default");
    }

    @Override
    public boolean hasMoreTokens() throws ReaderException {
        return in.hasChars();
    }
}
