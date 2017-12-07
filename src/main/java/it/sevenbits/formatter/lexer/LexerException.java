package it.sevenbits.formatter.lexer;

/**
 * Exception for Lexer
 */
public class LexerException extends Exception {

    /**
     * LexerException for Lexer.
     * @param s Message Exception.
     * @param e Exception.
     */
    public LexerException(final String s, final Throwable e) {
        super(s, e);
    }
}
