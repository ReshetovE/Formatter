package it.sevenbits.formatter.core;

/**
 * Exception for Closable.
 */
public class CloseException extends Exception {

    /**
     * Exception for Closable.
     * @param s Message Exception.
     * @param e Exception.
     */
    public CloseException(final String s, final Exception e) {
        super(s, e);
    }
}
