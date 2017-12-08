package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.ReaderException;
import it.sevenbits.formatter.implementation.Token;

/**
 * Lexical analyzer.
 */
public class Lexer implements ILexer {

    private StringBuilder lexeme = new StringBuilder();
    private IReader reader;


    /**
     * Constructor Lexer.
     * @param reader Reader.
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public IToken readToken() throws LexerException {
        try {
            while (reader.hasNextChars()) {
                char c = reader.readChar();
                switch (c) {
                    case ' ':
                        return new Token("Space", " ");
                    case '{':
                        return new Token("OpenBracket", "{");
                    case '}':
                        return new Token("CloseBracket", "}");
                    case ';':
                        return new Token("Semicolon", ";");
                    default:
                        return new Token("Default", String.valueOf(c));
                }
            }
        } catch (Exception e) {
            throw new LexerException("Method format failed", e);
        }
        return new Token("Default", "Default");
    }

    @Override
    public boolean hasMoreTokens() throws ReaderException {
        return reader.hasNextChars();
    }
}
